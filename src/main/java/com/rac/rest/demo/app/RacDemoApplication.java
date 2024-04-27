package com.rac.rest.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan({"com.rac.rest.demo.*"}) 
@EnableJpaRepositories(basePackages="com.rac.rest.demo.*")
@EnableTransactionManagement
@EntityScan(basePackages="com.rac.rest.demo.data")
public class RacDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RacDemoApplication.class, args);
	}

	@Bean
    public RestTemplate getRestTemplate(){return  new RestTemplate();}
}
