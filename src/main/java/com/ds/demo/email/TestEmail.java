package com.ds.demo.email;


import com.ds.demo.email.JavaMail;
import com.ds.demo.email.MailSenderInfo;
import com.ds.demo.exception.ExceptionInfo;

public class TestEmail {
    public static void main(String[] args) {
        JavaMail javaMail=new JavaMail();
        //测试1：发送邮件以文本格式
//        try {
//            String s="";
//            s.substring(2);
//        } catch (Exception e) {
//            e.printStackTrace();
//            javaMail.sendExceptionMail(new ExceptionInfo( null,"get()", "123",e));
//        }

        //测试2：发送邮件以html格式
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setToAddress("shimingda@deepsense.cn");       // 设置接受者邮箱地址
        mailInfo.setSubject("异常通知");
        String content="内容<h1>代码出现异常</h1>";
        mailInfo.setContent(content);
        String[] files = {"D:/ftp/image/3.png"};
        JavaMail.sendHtmlMail(mailInfo,files); // 发送html格式

        System.out.println("发送成功");


    }

}
