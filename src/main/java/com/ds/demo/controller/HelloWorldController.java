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
		return "hello world";
	}
}
