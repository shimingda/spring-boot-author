package com.ds.demo.sms;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
/**
 * @author Simon
 * @create 2018-10-17 14:07
 * @desc
 **/
public class SendMsg {

    /**
     * 建网短息发送
     * 收费
     * @throws Exception
     */
    public void sendByWebChinese()throws  Exception{
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn"); //该第三方短信服务地址
        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
        NameValuePair[] data ={ new NameValuePair("Uid", "本站用户名"),new NameValuePair("Key", "接口安全秘钥"),new NameValuePair("smsMob","手机号码"),new NameValuePair("smsText","验证码：8888")};
        post.setRequestBody(data);

        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:"+statusCode);
        for(Header h : headers)
        {
            System.out.println(h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
        System.out.println(result); //打印返回消息状态


        post.releaseConnection();

    }

}
