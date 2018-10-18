package com.ds.demo.scheduled;

import com.ds.demo.service.CPUService;
import com.ds.demo.service.DiskService;
import com.ds.demo.service.MemoryService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Simon
 * @create 2018-10-17 17:30
 * @desc
 **/
@Component
public class CheckTask {

//    @Scheduled(fixedRate  = 1000 * 6)
    @Scheduled(fixedRate  = 1000 * 60 * 5)
    public void check() throws  Exception{


        CPUService.checkTemp();
        DiskService.checkUseageRate();
        MemoryService.checkUseageRate();

    }
}
