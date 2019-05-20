package junit.integration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.rmpksoft.swagger2.SpringbootRestSwagger;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringbootRestSwagger.class , webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestSpringbootRestSwagger {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
		assertNotNull(restTemplate);
	}

}
