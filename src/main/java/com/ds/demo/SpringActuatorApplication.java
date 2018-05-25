package com.ds.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 
 * @author Simon
 * @version 2018年5月24日
 *
 * 程序入口
 */
@SpringBootApplication  
@ServletComponentScan
public class SpringActuatorApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringActuatorApplication.class, args);
	}
}
