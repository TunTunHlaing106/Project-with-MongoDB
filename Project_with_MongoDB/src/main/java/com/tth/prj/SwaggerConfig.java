package com.tth.prj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile("dev")
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
//				.securitySchemes(Arrays.asList(apiKey()))
//				.securityContexts(Arrays.asList(securityContext()))
				.apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("MBC Test API")
//				.description("MBC Test API reference for developers")
//				.termsOfServiceUrl("http://mbccentre.com")
//				.license("Management & Business Care Software Development License")
//				.licenseUrl("http://mbccentre.com")
				.version("v_1.0.0")
				.build();
	}
}