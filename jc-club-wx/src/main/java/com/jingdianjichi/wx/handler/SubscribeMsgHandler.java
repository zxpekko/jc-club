package com.jingdianjichi.wx.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:01 2024/4/5
 */
@Component
@Slf4j
public class SubscribeMsgHandler implements WxChatMsgHandler{
    @Override
    public WxChatMsgTypeEnum getTypeEnum() {
        return WxChatMsgTypeEnum.SUBSCRIBE;
    }

    @Override
    public String dealMsg(Map<String, String> messageMap) {
        log.info("触发用户关注事件！");
        String toUserName = messageMap.get("ToUserName");
        String fromUserName = messageMap.get("FromUserName");
        String msg="<xml>\n" +
                "  <ToUserName><![CDATA["+fromUserName+"]]></ToUserName>\n" +
                "  <FromUserName><![CDATA["+toUserName+"]]></FromUserName>\n" +
                "  <CreateTime>12345678</CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[您好,欢迎关注nnuclub^_^]]></Content>\n" +
                "</xml>";
        return msg;
    }
}
