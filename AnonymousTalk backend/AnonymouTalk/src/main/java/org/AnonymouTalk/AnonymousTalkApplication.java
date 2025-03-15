package org.AnonymouTalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AnonymousTalkApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnonymousTalkApplication.class, args);
	}

}
