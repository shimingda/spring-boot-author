package com.ds.demo.endpoint;

import com.ds.demo.oshi.ODiskInfo;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Simon
 * @create 2018-11-02 10:53
 * @desc
 **/
@Component
@Endpoint(id = "write-rate")
public class WriteRateEndpoint {
    private WriteRateEndpoint(){}

    private final Map<String,Object> message =(Map<String, Object>) new HashMap();

    @ReadOperation
    public  Map<String,Object> getAll() {

        String writeRate= ODiskInfo.writeRate();
        this.message.put("write-rate",writeRate);

        return message;
    }
}
