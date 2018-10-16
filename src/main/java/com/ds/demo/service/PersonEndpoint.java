package com.ds.demo.service;

import java.util.*;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.EndpointMapping;
import org.springframework.boot.actuate.endpoint.web.EndpointMediaTypes;
import org.springframework.boot.actuate.endpoint.web.ExposableWebEndpoint;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.boot.actuate.web.mappings.MappingDescriptionProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;

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
