package com.example.springderbywebserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringDerbyWebserverApplication {

	@Bean
	public NamedParameterJdbcTemplate myJdbcTemplate(DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDerbyWebserverApplication.class, args);
	}

}
