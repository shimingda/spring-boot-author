package com.ds.demo.email;


import com.ds.demo.exception.ExceptionInfo;
import org.springframework.beans.factory.annotation.Value;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/**
 * @class:JavaMail
 *@descript:发送信息邮箱
 *所需jar包：
 *fastjson-1.1.24.jar
 *javax.mail-1.5.6.jar
 *@date:2016年10月26日 下午8:13:05
 *@author sanghaiqin
 *@version:V1.0
 */
public class JavaMail {

    @Value("${email.address}")
    private String a;

    private List<String> mail= Arrays.asList("shimingda@deepsense.cn");

    public void sendExceptionMail(ExceptionInfo info){
        System.out.println(a);
        try {
            //通过发送者获得发送者邮箱

            System.out.println(mail);
            if(mail!=null){
                for (String e:mail) {
                    MailSenderInfo mailInfo = new MailSenderInfo();
                    //设置邮件的文本内容
                    mailInfo.setContent("负责人 : "+info.getDeveloper()+"==>服务器 ip:"+InetAddress.getLocalHost().getHostAddress()+"==>方法名: "+info.getMethod()+"==>地址："+info.getUrl()+"==>异常信息: "+getEmessage(info.getE()));
                    //设置邮件接收者的地址
                    mailInfo.setToAddress(e);
                    //邮件主题
                    mailInfo.setSubject("异常通知");
                    //发送邮件
                    sendTextMail(mailInfo);
                }

            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * @descript:以文本格式发送邮件
     * @param: mailInfo 待发送的邮件的信息
     * @return: 发送成功返回true；失败返回false
     */
    public static boolean sendTextMail(MailSenderInfo mailInfo) {
        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        try {
            if ("true".trim().equals(pro.getProperty("mail.smtp.auth"))) {
                // 如果需要身份认证，则创建一个密码验证器
                authenticator = new MyAuthenticator(pro.getProperty("mail.sender.username"),pro.getProperty("mail.sender.password"));
            }
            // 根据邮件会话属性和密码验证器构造一个发送邮件的session
            Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(pro.getProperty("mail.sender.address"));
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(mailInfo.getToAddress());
            // Message.RecipientType.TO属性表示接收者的类型为TO
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            // 设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // 设置邮件消息的主要内容
            mailMessage.setText(mailInfo.getContent());
            // 发送邮件
            Transport.send(mailMessage);
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * @descript:以HTML格式发送邮件
     * @param mailInfo: 待发送的邮件的信息
     * @param attachment:附件内容
     * @return：发送成功返回true；失败返回false
     */
    public static boolean sendHtmlMail(MailSenderInfo mailInfo, String[] attachment) {
        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        try {
            // 如果需要身份认证，则创建一个密码验证器
            if ("true".trim().equals(pro.getProperty("mail.smtp.auth"))) {
                // 如果需要身份认证，则创建一个密码验证器
                authenticator = new MyAuthenticator(pro.getProperty("mail.sender.username"),pro.getProperty("mail.sender.password"));
            }
            // 根据邮件会话属性和密码验证器构造一个发送邮件的session
            Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(pro.getProperty("mail.sender.address"));
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(mailInfo.getToAddress());
            // Message.RecipientType.TO属性表示接收者的类型为TO
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            // 设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
            Multipart mainPart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            // 设置HTML内容
            html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
            //添加HTML内容的MimeBodyPart
            mainPart.addBodyPart(html);
            // 添加附件的内容
            if (attachment != null) {
                for (String filePath : attachment) {
                    MimeBodyPart filePart = new MimeBodyPart();
                    DataSource source = new FileDataSource(filePath);
                    filePart.setDataHandler(new DataHandler(source));
                    try {
                        // 网上流传的解决文件名乱码的方法，其实用MimeUtility.encodeWord就可以很方便的搞定
                        filePart.setFileName(MimeUtility.encodeWord(source.getName()));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    mainPart.addBodyPart(filePart);
                }
            }
            // 将MiniMultipart对象设置为邮件内容
            mailMessage.setContent(mainPart);
            //保持内容
            mailMessage.saveChanges();
            // 发送邮件
            Transport.send(mailMessage);
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return false;
    }


    public  static String getEmessage(Exception e){
        //StringWriter输出异常信息
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        e.printStackTrace(pw);
        pw.flush();
        sw.flush();
        return sw.toString();
    }
}