package com.ds.demo.controller;

import com.ds.demo.check.CPUInfo;
import com.ds.demo.check.ThreadsInfo;
import com.ds.demo.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	ThreadsInfo threadsInfo;

	@RequestMapping("/test")
	public String test(){

		threadsInfo.getLive();

		double temp=CPUInfo.getTemp();
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
