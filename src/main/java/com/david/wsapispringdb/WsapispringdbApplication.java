package com.david.wsapispringdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WsapispringdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsapispringdbApplication.class, args);
	}

}
