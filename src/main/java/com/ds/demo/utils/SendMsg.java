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
       String subject= level+DateUtil.transform();
        mailInfo.setSubject(subject);

        StringBuilder builder=new StringBuilder();
//        警告等级
        builder.append("等级:").append(level).append("\n");
        builder.append("内容:").append(logContent).append("\n");
        builder.append("位置:").append(location).append("\n");
        mailInfo.setContent(String.valueOf(builder));

//        mailInfo.setContent("请您参加晚会"+String.valueOf(Math.random()));
//        JavaMail.sendHtmlMail(mailInfo,null); // 发送html格式
        JavaMail.sendTextMail(mailInfo);

    }
}
