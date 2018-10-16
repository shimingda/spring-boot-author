package com.ds.demo.service;

import com.ds.demo.check.CPU;
import com.ds.demo.constant.WarningConstant;
import com.ds.demo.utils.ExecUtil;
import com.ds.demo.utils.SendMsg;
import com.ds.demo.utils.StringUtil;
import com.ds.demo.utils.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;


/**
 * @author Simon
 * @create 2018-10-16 13:46
 * @desc
 **/
public class CPUService {
    private static final Logger logger=LoggerFactory.getLogger(CPUService.class);
    public static void checkTemp() throws IOException {

//        double temp= CPU.getTemp();
        double temp= 86;
        /**
         * 未达到预警范围
         */
        if(temp<WarningConstant.CPU_TEMPERATURE_THRESHOLD_1){
            return ;
        }
        String content="cup温度"+StringUtil.getTempUnit(temp);
        String ipAddress=SystemUtil.getIpAddress();
        /**
         * 温度过高，自动关机
         */
        if(temp>WarningConstant.CPU_TEMPERATURE_THRESHOLD_3){
            logger.error("服务器{}，{}，自动关机",ipAddress,content);
            ExecUtil.execUtil(WarningConstant.SHELL_REBOOT_COMMAND);
            return ;
        }

        /**
         * 温度高于阈值，发送邮件
         */
        if(temp>WarningConstant.CPU_TEMPERATURE_THRESHOLD_2){
            logger.warn("服务器{}，{}，发送警报",ipAddress,content);
            SendMsg.warnByEmail(WarningConstant.LEVEL_DANGER,content,ipAddress);
            return ;
        }
        /**
         * 温度高于阈值，发送邮件
         */
        if (temp>WarningConstant.CPU_TEMPERATURE_THRESHOLD_1){
            logger.warn("服务器{}，{}，发送警报",ipAddress,content);
            SendMsg.warnByEmail(WarningConstant.LEVEL_WARN,content,ipAddress);
            return ;
        }
    }

    public static void main(String[] args) throws IOException {
        checkTemp();
    }

}
