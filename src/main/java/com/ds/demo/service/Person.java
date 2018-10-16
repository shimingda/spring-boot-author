package com.ds.demo.service;

/**
 * @author Simon
 * @create 2018-10-15 16:12
 * @desc
 **/
public class Person {
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
