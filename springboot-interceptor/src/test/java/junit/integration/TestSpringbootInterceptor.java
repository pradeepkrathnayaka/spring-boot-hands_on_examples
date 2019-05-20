package junit.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.rmpksoft.interceptor.SpringbootInterceptor;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringbootInterceptor.class , webEnvironment = WebEnvironment.RANDOM_PORT)
@Rollback
public class TestSpringbootInterceptor {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@DisplayName("Test message REST API ")
	void test_message() {
		String message = this.restTemplate.getForObject("/api/posts/test", String.class);
		assertEquals("Test Message", message);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	@DisplayName("GET post list")
	void test_post() {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("/api/posts", String.class);
		 String body = entity.getBody();
		 MediaType contentType = entity.getHeaders().getContentType();
		 HttpStatus statusCode = entity.getStatusCode();
		 System.out.println("contentType->" + contentType);
		 
		 System.out.println("body->" + body);
		 
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		
	}

}
