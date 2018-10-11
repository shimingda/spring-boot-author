package com.ds.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author Simon
 * @version 2018年5月24日
 *
 *	测试项目调通
 */
@RestController
public class HelloWorldController {
	@RequestMapping("/test")
	public String test(){
		double random=Math.random();
		return  String.valueOf(random);
	}
	@RequestMapping("/exception")
	public String exception(){
		String s="";
		s.substring(2);
		return "hello world";
	}
}
