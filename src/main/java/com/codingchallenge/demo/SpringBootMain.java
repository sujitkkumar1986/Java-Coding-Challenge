package com.codingchallenge.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootMain extends SpringBootServletInitializer {
    Logger logger = LoggerFactory.getLogger(SpringBootMain.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMain.class, args);
    }
}
