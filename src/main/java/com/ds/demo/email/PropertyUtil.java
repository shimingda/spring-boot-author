package com.ds.demo.email;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
    /**
     * @descript:加载资源文件
     * @param resources 资源文件
     * @return
     * @throws FileNotFoundException
     */
    private Properties loadProperties(String resources) {
        InputStream inputstream = null;
        Properties properties = new Properties();
        // 使用InputStream得到一个资源文件
        try {
            inputstream = new FileInputStream(resources);
            // 加载配置文件
            properties.load(inputstream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(inputstream!=null){
                try {
                    inputstream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }

    /**
     * @descript:读属性文件
     * @return
     * @throws FileNotFoundException
     */
    public Properties readProperties(){
        String resources = PropertyUtil.class.getClassLoader().getResource("prop.properties").getPath();
        Properties properties = loadProperties(resources);
        return properties;
    }

    /**
     * @descript：测试
     * @param args
     */
    public static void main(String[] args) {
        PropertyUtil p=new PropertyUtil();
        Properties pro=p.readProperties();
        String mailSenderUsername=(String) pro.get("mail.sender.username");
        System.out.println("邮件发送者用户名："+mailSenderUsername);//neo_lifes@163.com
        String path = PropertyUtil.class.getClassLoader().getResource("prop.properties").getPath();
        System.out.println(path);// /G:/Workspaces4.4/test/bin/prop.properties
    }

}
