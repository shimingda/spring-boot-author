package com.ds.demo.endpoint;

import com.ds.demo.oshi.OSensorsInfo;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Simon
 * @create 2018-11-02 10:06
 * @desc
 **/
@Endpoint(id = "cpu-temperature")
@Component
public class CPUTemperatureEndpoint {
    private CPUTemperatureEndpoint(){
    }

    private final Map<String,Object> message =(Map<String, Object>) new HashMap();



    @ReadOperation
    public  Map<String,Object> getAll() {
        OSensorsInfo sensorsInfo=new OSensorsInfo();
        String temp=sensorsInfo.getCpuTemp();
        this.message.put("cpu-temperature",temp);
        return message;
    }

}
