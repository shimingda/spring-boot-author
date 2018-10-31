package com.ds.demo.check;

/**
 * @author Simon
 * @create 2018-10-31 12:15
 * @desc
 **/

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.actuate.autoconfigure.metrics.CompositeMeterRegistryAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
@ConditionalOnClass(Timed.class)
@AutoConfigureAfter({ MetricsAutoConfiguration.class,
        CompositeMeterRegistryAutoConfiguration.class })
public class Config {

    @Bean
    @ConditionalOnBean(MeterRegistry.class)
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint
    public MetricsEndpoint metricsEndpoint(MeterRegistry registry) {
        return new MetricsEndpoint(registry);
    }

    @Bean
    public ThreadsInfo getThreadsInfo(){
        return new ThreadsInfo();
    }

    @Autowired
    MetricsEndpoint metricsEndpoint;
    public void getNames(){
        MetricsEndpoint.ListNamesResponse listNamesResponse= metricsEndpoint.listNames();
        Set<String> names=listNamesResponse.getNames();
        names.stream().forEach(x-> System.out.println(x));
    }

}