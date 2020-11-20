package com.biz.bbs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class InitData {

	@Bean
	public CommandLineRunner initDataMethod() {
		
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {

				System.out.println("여기는 초기화 method");
				
				
			}
		};
	}
	
	
}
