package com.ds.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
 *
 *	自定义监视端点
 */
@Endpoint(id = "person")  
@Component  
public class PersonEndpoint {  
  
    private final Map<String, Person> people = new HashMap<>();  
   
    PersonEndpoint() {  
        this.people.put("我名字", new Person("Simon"));  
        this.people.put("树的名字", new Person("白杨"));  
        this.people.put("花的名字", new Person("绿萝"));  
        
    }  
  
    @ReadOperation  
    public List<Person> getAll() {  
        return new ArrayList<>(this.people.values());  
    }  
  
    @ReadOperation  
    public Person getPerson(@Selector String person) {  
        return this.people.get(person);  
    }  
  
    @WriteOperation  
    public void updatePerson(@Selector String name, String person) {  
        this.people.put(name, new Person(person));  
    }  
  
    public static class Person {  
        private String name;  
  
        Person(String name) {  
            this.name = name;  
        }  
  
        public String getName() {  
            return this.name;  
        }  
  
        public void setName(String name) {  
            this.name = name;  
        }  
    }  
}  
