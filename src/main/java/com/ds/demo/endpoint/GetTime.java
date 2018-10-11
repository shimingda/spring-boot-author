package com.ds.demo.endpoint;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Simon
 * @version 2018年5月25日
 * 自定义端点
 */
@Endpoint(id = "get-time")  
@Component 
public class GetTime {
	private final Map<String,Object> message =(Map<String, Object>) new HashMap();
    private GetTime(){
	 this.message.put("当前时间", new Date());
	 this.message.put("我是", "Simon");
	 this.message.put("111", "222");
    } 
    @ReadOperation  
    public  Map<String,Object> getAll() {  
        return message;  
    } 
    @ReadOperation  
    public  Map<String,Object> getOne(@Selector String name) {  
    	Object value=message.get(name);
    	Map<String,Object> message2=  new HashMap<String,Object>();
        return message2;  
    } 
    @WriteOperation  
    public void updatePerson(@Selector String name) {  
        this.message.put(name, name);  
    } 
}
