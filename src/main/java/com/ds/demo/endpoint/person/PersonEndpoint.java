package com.ds.demo.endpoint.person;

import java.util.*;

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
        this.people.put("Simon", new Person("Michael Simon"));
        this.people.put("Alan", new Person("Rowena Alan"));
        this.people.put("Bryant", new Person("Barry Bryant"));
    }

    @ReadOperation
    public Map<String, Person> getAll() {
        return people;
    }

    @ReadOperation
    public Person getPerson(@Selector String person) {
        return this.people.get(person);
    }

    @WriteOperation
    public void updatePerson(@Selector String name, String person) {
        this.people.put(name, new Person(person));
    }

}
