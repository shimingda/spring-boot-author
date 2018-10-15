package com.ds.demo.dingtalk;

import com.alibaba.fastjson.JSONArray;
import com.dingtalk.chatbot.DingtalkChatbotClient;
import com.dingtalk.chatbot.SendResult;
import com.dingtalk.chatbot.message.TextMessage;

import java.io.IOException;

/**
 * @author Simon
 * @create 2018-10-12 15:12
 * @desc
 **/
public class TestDingTalk {

    public static void main(String[] args) throws IOException {
        String accessToken = "";
        TextMessage message = new TextMessage("我就是我, 是不一样的烟火");
        DingtalkChatbotClient client = new DingtalkChatbotClient();
        SendResult result = client.send("https://oapi.dingtalk.com/robot/send?access_token="+accessToken, message);
        System.out.println(result);
    }

}
