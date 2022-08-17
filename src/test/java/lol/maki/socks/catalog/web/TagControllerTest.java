package lol.maki.socks.catalog.web;

import java.util.List;

import lol.maki.socks.catalog.Tag;
import lol.maki.socks.catalog.TagMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;

import static com.atlassian.oai.validator.mockmvc.OpenApiValidationMatchers.openApi;
import static org.mockito.BDDMockito.given;

@WebMvcTest(controllers = TagController.class)
class TagControllerTest {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	TagMapper tagMapper;

	private final Tag tag1 = new Tag("red");

	private final Tag tag2 = new Tag("blue");

	private final Tag tag3 = new Tag("green");

	WebTestClient webTestClient;

	@BeforeEach
	void setup() throws Exception {
		this.webTestClient = MockMvcWebTestClient.bindTo(this.mockMvc).build();
	}

	@Test
	void getTags() throws Exception {
		given(this.tagMapper.findAll()).willReturn(List.of(this.tag1, this.tag2, this.tag3));
		final EntityExchangeResult<byte[]> result = this.webTestClient.get()
				.uri("/tags")
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$.tags.length()").isEqualTo(3)
				.jsonPath("$.tags[0]").isEqualTo("red")
				.jsonPath("$.tags[1]").isEqualTo("blue")
				.jsonPath("$.tags[2]").isEqualTo("green")
				.returnResult();
		MockMvcWebTestClient.resultActionsFor(result)
				.andExpect(openApi().isValid("static/openapi/doc.yml"));
	}
}