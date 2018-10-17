package com.ds.demo.constant;

/**
 * @author Simon
 * @create 2018-10-16 12:52
 * @desc
 **/
public class WarningConstant {
    /**
     * CPU温度告警阀值一，现为85摄氏度
     */
    public static final int CPU_TEMPERATURE_THRESHOLD_1 = 85;
    /**
     * CPU温度告警阀值二，现为95摄氏度
     */
    public static final int CPU_TEMPERATURE_THRESHOLD_2 = 90;
    /**
     * CPU温度告警阀值二，现为95摄氏度
     */
    public static final int CPU_TEMPERATURE_THRESHOLD_3 = 95;

    /**
     * 内存警报阈值一，当内存使用超过90%时，发出报警
     */
    public static final double Memory_ALARM_THRESHOLD_1=0.90;
    /**
     * 内存警报阈值二，当内存使用超过95%时，发出报警
     */
    public static final double Memory_ALARM_THRESHOLD_2=0.95;
    /**
     * 内存警报阈值三，当内存使用超过96%时，发出报警
     */
    public static final double Memory_ALARM_THRESHOLD_3=0.98;

    /**
     * 存储空间告警，当存储使用空间超过90%时，发出告警信息
     */
    public static final double STORE_ALARM_THRESHOLD = 0.90;

    /**
     * 重启系统的Shell命令
     */
    public static final String SHELL_REBOOT_COMMAND = "reboot";
    /**
     * 查看CPU温度Shell指令
     */
    public static final String SHELL_CAT_CPU="cat /sys/class/thermal/thermal_zone0/temp";
    /**
     * 评估等级正常
     */
    public static final String LEVEL_INFO="正常";
    /**
     * 评估等级警告
     */
    public static final String LEVEL_WARN="警告";
    /**
     * 评估等级危险
     */
    public static final String LEVEL_DANGER="危险";

    /**
     * 定时自检时间
     */
    public static final int LOOP_TIME = 300;

}
