package com.example.SpringDemo.TriangleBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    /*@Bean(name="equilateral")
    public Triangle triangle(){
        return new Triangle("int");
    }

    @Bean(name = "custom")
    public Triangle customTriangle(){
        return new Triangle("Equilateral", 20);
    }

    @Bean(name = "integer")
    public Triangle integer(){
        return new Triangle(20);
    }*/
    @Bean
    public Triangle triangle(){
        return new Triangle();
    }
    @Bean(name = "pointA")
    public Point pointA(){
        return new Point(0,0);
    }
    @Bean(name = "pointB")
    public Point pointB(){
        return new Point(-20,0);
    }
    @Bean(name = "pointC")
    public Point pointC(){
        return new Point(0,20);
    }
}
