package com.test;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * @author Simon
 * @create 2018-10-11 14:26
 * @desc
 **/
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class MainApplication {
    public static void main(String[] args) {

        SpringApplication.run(MainApplication.class, args);
    }
}
