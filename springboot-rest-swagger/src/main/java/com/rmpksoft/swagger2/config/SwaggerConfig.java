package com.rmpksoft.swagger2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	static {
		System.out.println("Init SwaggerConfig..........................................");
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(Predicates.not(PathSelectors.regex("/error.*")))
				.build();
	}
	
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Product Information Web Application")
                .description("Description for Product Information Web Application.")
                .termsOfServiceUrl("#")
                .contact(new Contact("Product Information", "http://www.google.com/", "info@test.org"))
                .license("Licence")
                .licenseUrl("#")
                .version("1.0")
                .build();
    }

}
