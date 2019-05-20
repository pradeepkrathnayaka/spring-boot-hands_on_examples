package junit.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.rmpksoft.interceptor.controller.Post;

@TestInstance(Lifecycle.PER_CLASS)
public class TestPostController extends AbstractTestController {
	@BeforeAll
	public void setUp() {
		super.setUp();
	}

	@Disabled
	@Test
	public void getPostsList() throws Exception {
		String uri = "/api/posts";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andDo(MockMvcResultHandlers.print()).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(HttpStatus.OK, status);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println("content->" + content);
		System.out.println("contentType->" + mvcResult.getResponse().getContentType());

		Post[] postslist = super.mapFromJson(content, Post[].class);
		assertTrue(postslist.length > 0);
	}

	@Disabled
	@Test
	public void createPost() throws Exception {
		String uri = "/api/posts";
		Post post = new Post();
		post.setId("Post3");
		post.setContent("Post3");
		String inputJson = super.mapToJson(post);

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andDo(MockMvcResultHandlers.print()).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status);

		// String content = mvcResult.getResponse().getContentAsString();
		// assertEquals(content, "Post is created successfully");
	}

	@Disabled
	@Test
	public void updatePost() throws Exception {
		String uri = "/api/posts/2";
		Post post = new Post();
		post.setId("2");
		post.setContent("Post3");
		String inputJson = super.mapToJson(post);

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andDo(MockMvcResultHandlers.print()).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();

		// assertEquals(content, "Post is updated successsfully");
	}

	@Test
	public void deletePost() throws Exception {
		String uri = "/api/posts/2";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andDo(MockMvcResultHandlers.print())
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(204, status);
		String content = mvcResult.getResponse().getContentAsString();
		// assertEquals(content, "Post is deleted successsfully");
	}

}
