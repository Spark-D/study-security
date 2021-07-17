package com.example.studysecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.beans.BeanProperty;

@SpringBootApplication
public class StudySecurityApplication {

	@Bean
	public PasswordEncoder passwordEncoder(){
//		return NoOpPasswordEncoder.getInstance();
		return PasswordEncoderFactories.createDelegatingPasswordEncoder(); //bcrypt 시큐리티 기본 인코딩 전략사용
	}

	//run : ctrl + shift + R
	public static void main(String[] args) {
		SpringApplication.run(StudySecurityApplication.class, args);
	}

}
