package com.rbs;

import com.rbs.support.Container;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootRBSDemo {

	private static final Logger log = LoggerFactory.getLogger(SpringBootRBSDemo.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRBSDemo.class,args);
	}

	@Bean
	Container container(){
		Container container=new Container();
		return container;
	}
}
