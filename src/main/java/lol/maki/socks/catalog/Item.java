package lol.maki.socks.catalog;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record Item(UUID itemId, String name, String description, BigDecimal price,
				   int count, List<String> imageUrl, List<Tag> tags) {

}