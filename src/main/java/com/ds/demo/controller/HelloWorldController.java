package com.ds.demo.controller;

import com.ds.demo.check.CPU;
import com.ds.demo.utils.StringUtil;
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
		double temp=CPU.getTemp();
		String tempStr=String.format("%.1f", temp / 1000);
		return StringUtil.getTempUnit(tempStr);
	}
	@RequestMapping("/exception")
	public String exception(){
		String s="";
		s.substring(2);
		return "hello world";
	}
}
