package com.ds.demo.exception;

import com.ds.demo.email.JavaMail;
import com.ds.demo.email.MailSenderInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常处理
 *
 * @author Simon
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    JavaMail javaMail=new JavaMail();
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleException(Exception ex) {
//        javaMail.sendExceptionMail(new ExceptionInfo( null,"get()", "123",ex));
    //测试2：发送邮件以html格式
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setToAddress("shimingda@deepsense.cn");       // 设置接受者邮箱地址
        mailInfo.setSubject("异常通知");
        String content =ex.getMessage();
        mailInfo.setContent(content);
        String[] files = {"D:/ftp/image/3.png"};
        JavaMail.sendHtmlMail(mailInfo,files); // 发送html格式

        System.out.println("发送成功");

    }
}