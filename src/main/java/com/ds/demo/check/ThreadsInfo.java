package com.ds.demo.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;

import java.util.Collections;
import java.util.List;

/**
 * 加工原生端点信息
 * @author Simon
 * @create 2018-10-31 14:20
 * @desc
 **/
public class ThreadsInfo {
    @Autowired
    MetricsEndpoint metricsEndpoint;

    public void getLive(){
        List<String> tag=Collections.emptyList();
        MetricsEndpoint.MetricResponse metricResponse=metricsEndpoint.metric("process.uptime",tag);
        List<MetricsEndpoint.Sample> samples=metricResponse.getMeasurements();
        samples.stream().forEach(x->System.out.println("========"+x.getValue()));
    }
}
