package com.ds.demo.endpoint.person;

import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Simon
 * @create 2018-10-15 13:51
 * @desc
 **/
@Configuration
public class MyEndpointConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint
    public PersonEndpoint myEndPoint(){
        return new PersonEndpoint();
    }
}
