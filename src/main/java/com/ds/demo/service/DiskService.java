package com.ds.demo.service;

import com.ds.demo.check.DiskInfo;
import com.ds.demo.constant.WarningConstant;
import com.ds.demo.utils.ExecUtil;
import com.ds.demo.utils.SendMsg;
import com.ds.demo.utils.StringUtil;
import com.ds.demo.utils.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * @author Simon
 * @create 2018-10-17 12:00
 * @desc
 **/
public class DiskService {
    private static final Logger logger=LoggerFactory.getLogger(DiskService.class);
    private DiskService(){

    }

    /**
     * 检查每个磁盘使用情况
     * @throws IOException
     */
    public static void checkUseageRate() throws IOException {

        Map<Double,String> useageRates= DiskInfo.getUseageRate();

        for (Map.Entry<Double,String> entry:useageRates.entrySet()) {
            Double useageRate=entry.getKey();

        /**
         * 未达到预警范围
         */
            if(useageRate<WarningConstant.DISK_ALARM_THRESHOLD_1){
                continue;
            }

            String content=entry.getValue()+"磁盘使用率:"+StringUtil.getPercent(useageRate);
            String ipAddress=SystemUtil.getIpAddress();

        /**
         * 内存使用率过高，自动关机
         */
        if(useageRate>WarningConstant.DISK_ALARM_THRESHOLD_3){
            logger.error("服务器{}，{}，自动关机",ipAddress,content);
            ExecUtil.execUtil(WarningConstant.SHELL_REBOOT_COMMAND);
            continue ;
        }

        /**
         * 温度高于阈值，发送邮件
         */
        if(useageRate>WarningConstant.DISK_ALARM_THRESHOLD_2){
            logger.warn("服务器{}，{}，发送警报",ipAddress,content);
            SendMsg.warnByEmail(WarningConstant.LEVEL_DANGER,content,ipAddress);
            continue ;
        }
        /**
         * 温度高于阈值，发送邮件
         */
        if (useageRate>WarningConstant.DISK_ALARM_THRESHOLD_1){
            logger.warn("服务器{}，{}，发送警报",ipAddress,content);
            SendMsg.warnByEmail(WarningConstant.LEVEL_WARN,content,ipAddress);
            continue ;
            }
        }
    }
}
