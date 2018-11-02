package com.ds.demo.endpoint;

import com.ds.demo.oshi.ODiskInfo;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Simon
 * @create 2018-11-02 11:31
 * @desc
 **/
@Component
@Endpoint(id = "read-rate")
public class ReadRateEndpoint {
    private ReadRateEndpoint(){}
    private final Map<String,Object> message =(Map<String, Object>) new HashMap();

    @ReadOperation
    public  Map<String,Object> getAll() {

        String readRate= ODiskInfo.readRate();
        this.message.put("read-rate",readRate);

        return message;
    }
}
