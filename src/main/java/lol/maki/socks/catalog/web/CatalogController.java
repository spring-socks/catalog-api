package lol.maki.socks.catalog.web;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import lol.maki.socks.catalog.Item;
import lol.maki.socks.catalog.ItemMapper;
import lol.maki.socks.catalog.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CatalogController {
	private final ItemMapper itemMapper;

	public CatalogController(ItemMapper itemMapper) {
		this.itemMapper = itemMapper;
	}

	@GetMapping(path = "/catalogue/{id}")
	public ResponseEntity<ItemResponse> getItem(@PathVariable("id") UUID id) {
		return ResponseEntity.of(this.itemMapper.findOne(id).map(ItemResponse::fromItem));
	}

	@GetMapping(path = "/catalogue/size")
	public ResponseEntity<CountResponse> getItemCount(@RequestParam(value = "tags", required = false) List<String> tags) {
		final long count = this.itemMapper.countByTag(tags == null ? null : tags.stream().map(Tag::new).toList());
		return ResponseEntity.ok(new CountResponse(count));
	}

	@GetMapping(path = "/catalogue")
	public ResponseEntity<List<ItemResponse>> getItems(@RequestParam(value = "order", required = false, defaultValue = "price") String order,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
			@RequestParam(value = "tags", required = false) List<String> tags) {
		final List<Item> items = this.itemMapper.findItems(tags == null ? null : tags.stream().map(Tag::new).toList(), order, page, size);
		return ResponseEntity.ok(items.stream().map(ItemResponse::fromItem).toList());
	}

	record ItemResponse(UUID id, String name, String description, BigDecimal price,
						int count,
						List<String> imageUrl, List<String> tag) {

		static ItemResponse fromItem(Item item) {
			return new ItemResponse(item.itemId(), item.name(), item.description(), item.price(), item.count(), item.imageUrl(), item.tags().stream().map(Tag::name).toList());
		}
	}

	record CountResponse(long size) {}
}