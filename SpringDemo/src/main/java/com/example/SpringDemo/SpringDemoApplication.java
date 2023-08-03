package com.example.SpringDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/*@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example.SpringDemo")*/
@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {

		/*ApplicationContext context = */SpringApplication.run(SpringDemoApplication.class, args);
		/*Triangle triangle = (Triangle) context.getBean("pointA");
		Triangle triangle2 = (Triangle) context.getBean("pointB");
		Triangle triangle3 = (Triangle) context.getBean("pointC");
		*//*Triangle triangle = context.getBean(Triangle.class);*//*
		triangle.draw();
		triangle2.draw();
		triangle3.draw();*/


/*
		Triangle triangle = context.getBean(Triangle.class);
		triangle.draw();*/
	}

}
