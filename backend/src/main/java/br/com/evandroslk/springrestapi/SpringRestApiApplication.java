package br.com.evandroslk.springrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringRestApiApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApiApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("12345"));
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/usuario**/")
				.allowedOrigins("*")
				.allowedOrigins("*");
	}

}
