package lol.maki.socks.catalog;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

@Repository
public class ItemMapper {
	private final JdbcTemplate jdbcTemplate;

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private final Set<String> acceptedOrder = Set.of("item_id", "name", "price");

	private final RowMapper<Item> itemBuilderRowMapper = (rs, i) -> new Item(
			UUID.fromString(rs.getString("item_id")),
			rs.getString("name"),
			rs.getString("description"),
			new BigDecimal(rs.getString("price")),
			rs.getInt("count"),
			List.of(rs.getString("image_url_1"), rs.getString("image_url_2")),
			Arrays.stream(Objects.requireNonNullElse(rs.getString("tag"), "").split(","))
					.map(Tag::new).toList());

	private static final String BASE_QUERY = "SELECT s.item_id, s.name, description, price, count, image_url_1, image_url_2, array_to_string(ARRAY(SELECT unnest(array_agg(t.name))), ',') AS tag"
			+ " FROM item AS s"
			+ " JOIN item_tag AS st ON s.item_id = st.item_id"
			+ " JOIN tag AS t ON st.tag_id = t.tag_id";

	public ItemMapper(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public Optional<Item> findOne(UUID itemId) {
		try {
			final Item item = this.jdbcTemplate.queryForObject(BASE_QUERY
					+ " GROUP BY s.name, s.price, s.item_id"
					+ " HAVING s.item_id = ?", this.itemBuilderRowMapper, itemId.toString());
			return Optional.ofNullable(item);
		}
		catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	public List<Item> findItems(List<Tag> tags, String order, int page, int size) {
		final MapSqlParameterSource source = new MapSqlParameterSource();
		final StringBuilder sql = new StringBuilder(BASE_QUERY);
		if (!CollectionUtils.isEmpty(tags)) {
			sql.append(" WHERE t.name IN (:tags)");
			source.addValue("tags", tags.stream().map(Tag::name).toList());
		}
		sql
				.append(" GROUP BY s.name, s.price, s.item_id");
		if (this.acceptedOrder.contains(order)) {
			sql
					.append(" ORDER BY ")
					.append("s.")
					.append(order);
		}
		if (page > 0 && size > 0) {
			sql
					.append(" LIMIT ")
					.append(size)
					.append(" OFFSET ")
					.append((page - 1) * size);
		}
		return this.namedParameterJdbcTemplate.query(sql.toString(), source, this.itemBuilderRowMapper);
	}

	public long countByTag(List<Tag> tags) {
		final MapSqlParameterSource source = new MapSqlParameterSource();
		final StringBuilder sql = new StringBuilder("SELECT COUNT(DISTINCT s.item_id) FROM item AS s");
		if (!CollectionUtils.isEmpty(tags)) {
			sql
					.append(" JOIN item_tag AS st ON s.item_id = st.item_id")
					.append(" JOIN tag AS t ON st.tag_id = t.tag_id")
					.append(" WHERE t.name IN (:tags)");
			source.addValue("tags", tags.stream().map(Tag::name).toList());
		}
		final Long count = this.namedParameterJdbcTemplate.queryForObject(sql.toString(), source, Long.class);
		return Objects.requireNonNullElse(count, 0L);
	}
}