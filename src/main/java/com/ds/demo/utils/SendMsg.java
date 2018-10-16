package com.ds.demo.utils;

import com.ds.demo.email.JavaMail;
import com.ds.demo.email.MailSenderInfo;

import java.io.IOException;

/**
 * @author Simon
 * @create 2018-10-16 13:55
 * @desc
 **/
public class SendMsg {
    /**
     * 发送告警信息
     *
     * @param level      告警信息级别，有i,w,e三种.其中i为info(普通信息)，w为warn（警告信息），e为error（错误信息）
     * @param logContent 告警信息的内容
     * @param location   告警信息的触发代码位置
     * @throws IOException
     */
    public static void warnByEmail(String level, String logContent, String location) throws IOException {

        MailSenderInfo mailInfo = new MailSenderInfo();

        mailInfo.setToAddress("shimingda@deepsense.cn");       // 设置接受者邮箱地址

        mailInfo.setSubject(level);

        StringBuilder builder=new StringBuilder();
//        警告等级
        builder.append("<h1>警告日期:").append(DateUtil.transform()).append("</h1>");
        builder.append("<h1>警告等级:").append(level).append("</h1>");
        builder.append("<h1>警告内容:").append(logContent).append("</h1>");
        builder.append("<h1>警告位置:").append(location).append("</h1>");
        mailInfo.setContent(String.valueOf(builder));

        mailInfo.setContent(String.valueOf(Math.random()));
        JavaMail.sendHtmlMail(mailInfo,null); // 发送html格式

    }
}
