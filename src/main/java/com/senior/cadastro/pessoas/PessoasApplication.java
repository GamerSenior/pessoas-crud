package com.senior.cadastro.pessoas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.FilterRegistration;
import java.util.Collections;

@SpringBootApplication
public class PessoasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PessoasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

//	@Bean
//	public FilterRegistrationBean simpleCorsFilter() {
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration config = new CorsConfiguration();
//
//		config.setAllowedOrigins(Collections.singletonList("http://localhost:8080"));
//		config.setAllowedMethods(Collections.singletonList("*"));
//		config.setAllowedHeaders(Collections.singletonList("*"));
//		source.registerCorsConfiguration("/**", config);
//		CorsFilter corsFilter = new CorsFilter(source);
//		FilterRegistrationBean bean = new FilterRegistrationBean(corsFilter);
//		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//		return bean;
//	}
}
