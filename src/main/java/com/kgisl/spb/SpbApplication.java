package com.kgisl.spb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpbApplication {

	public static void main(String[] args) {
		System.out.println("Welcom to Spring-Boot");
		SpringApplication.run(SpbApplication.class, args);
	}

}
