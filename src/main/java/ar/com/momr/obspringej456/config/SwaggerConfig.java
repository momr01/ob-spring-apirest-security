package ar.com.momr.obspringej456.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
/**
 * http://localhost:8081/swagger-ui/index.html
 * http://localhost:8081/v2/api-docs
 * @author maxio
 *
 */
@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiDetails())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo("Spring BOOT Laptop API REST",
				"Library API REST docs",
				"1.0",
				"https://www.google.com.ar",
				new Contact("Maxi", "https://www.google.com.ar", "maxi@correo.com"),
				"MIT",
				"https://www.google.com.ar",
				Collections.emptyList());
	}

}
