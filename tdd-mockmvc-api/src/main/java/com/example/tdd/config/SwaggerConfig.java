package com.example.tdd.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket swagger(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.tdd"))
				.paths(PathSelectors.any())
				.build()
				.globalResponses(HttpMethod.GET, getDefaultResponses())
				.apiInfo(metaInfo());
	}
	
	private List<Response> getDefaultResponses(){
		List<Response> responses = new ArrayList<>();
		responses.add(new Response(String.valueOf(HttpStatus.NO_CONTENT.value()), HttpStatus.NO_CONTENT.getReasonPhrase(), false, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList()));
		responses.add(new Response(String.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.getReasonPhrase(), false, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList()));
		responses.add(new Response(String.valueOf(HttpStatus.FORBIDDEN.value()), HttpStatus.FORBIDDEN.getReasonPhrase(), false, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList()));
		responses.add(new Response(String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND.getReasonPhrase(), false, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList()));
		responses.add(new Response(String.valueOf(HttpStatus.BAD_GATEWAY.value()), HttpStatus.BAD_GATEWAY.getReasonPhrase(), false, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList()));
		responses.add(new Response(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), false, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList()));
		
		return responses;
	}

	private ApiInfo metaInfo() {
		return new ApiInfo("tdd-mockmvc-api", 
						   "API para testes",
						   "1.0.1",  
						   "Termos de Serviço", 
						   new Contact("Neiton Junior Carneiro", "https://github.com/neitonjc/", "neitonjc@gmail.com"), null, null, new ArrayList<>()
			);
	}

}
