package com.example.companylibrary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import java.net.URI;

import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@SpringBootApplication
@Slf4j
@Import(JpaConfig.class)
public class CompanyLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyLibraryApplication.class, args);
	}

	@Bean
	RouterFunction<ServerResponse> routerFunction() {
		return route(GET("/api-docs"), req ->
				ServerResponse.temporaryRedirect(URI.create("swagger-ui/index.html")).build());
	}

}
