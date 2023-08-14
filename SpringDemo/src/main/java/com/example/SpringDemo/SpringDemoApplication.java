package com.example.SpringDemo;

import com.example.SpringDemo.e_commerce.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example.SpringDemo")*/
@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);

		//Ebders
		/*ApplicationContext context = */
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
