package com.ds.demo.service;

import com.ds.demo.check.MemoryInfo;
import com.ds.demo.constant.WarningConstant;
import com.ds.demo.utils.SendMsg;
import com.ds.demo.utils.StringUtil;
import com.ds.demo.utils.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author Simon
 * @create 2018-10-17 10:43
 * @desc
 **/
public class MemoryService {
    private static final Logger logger=LoggerFactory.getLogger(MemoryService.class);
    public static void checkUseageRate() throws IOException {

        double useageRate= MemoryInfo.getUseageRate();

        /**
         * 未达到预警范围
         */
        if(useageRate<WarningConstant.MEMORY_ALARM_THRESHOLD_1){
            return ;
        }
        String content="内存使用率:"+StringUtil.getPercent(useageRate);
        String ipAddress=SystemUtil.getIpAddress();
        /**
         * 内存使用率过高，自动关机
         */
        if(useageRate>WarningConstant.MEMORY_ALARM_THRESHOLD_3){
            logger.error("服务器{}，{}，自动关机",ipAddress,content);
//            ExecUtil.execUtil(WarningConstant.SHELL_REBOOT_COMMAND);
            return ;
        }

        /**
         * 温度高于阈值，发送邮件
         */
        if(useageRate>WarningConstant.MEMORY_ALARM_THRESHOLD_2){
            logger.warn("服务器{}，{}，发送警报",ipAddress,content);
            SendMsg.warnByEmail(WarningConstant.LEVEL_DANGER,content,ipAddress);
            return ;
        }
        /**
         * 温度高于阈值，发送邮件
         */
        if (useageRate>WarningConstant.MEMORY_ALARM_THRESHOLD_1){
            logger.warn("服务器{}，{}，发送警报",ipAddress,content);
            SendMsg.warnByEmail(WarningConstant.LEVEL_WARN,content,ipAddress);
            return ;
        }
    }
}
