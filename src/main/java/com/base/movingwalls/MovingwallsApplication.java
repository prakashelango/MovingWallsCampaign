package com.base.movingwalls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class MovingwallsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovingwallsApplication.class, args);
	}

}
