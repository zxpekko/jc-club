package com.jingdianjichi.wx.handler;

import com.jingdianjichi.wx.utils.RandomUtils;
import com.jingdianjichi.wx.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:02 2024/4/5
 */
@Component
@Slf4j
public class ReceiveTextMsgHandler implements WxChatMsgHandler{
    private static final String KEY_WORD = "验证码";

    private static final String LOGIN_PREFIX = "loginCode";

    @Resource
    private RedisUtil redisUtil;

    @Override
    public WxChatMsgTypeEnum getTypeEnum() {
        return WxChatMsgTypeEnum.TEXT_MSG;
    }

    @Override
    public String dealMsg(Map<String, String> messageMap) {
        log.info("接收到文本消息事件");
        String content = messageMap.get("Content");
        if (!KEY_WORD.equals(content)) {
            return "";
        }
        String toUserName = messageMap.get("ToUserName");
        String fromUserName = messageMap.get("FromUserName");

        String random= RandomUtils.getSixBitRandom();
        String numKey = redisUtil.buildKey(LOGIN_PREFIX, random);
        redisUtil.setNx(numKey,fromUserName, 5L, TimeUnit.MINUTES);
        String numContent = "您当前的验证码是：" + random + "！ 5分钟内有效";
        String msg="<xml>\n" +
                "  <ToUserName><![CDATA["+fromUserName+"]]></ToUserName>\n" +
                "  <FromUserName><![CDATA["+toUserName+"]]></FromUserName>\n" +
                "  <CreateTime>12345678</CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA["+numContent+"]]></Content>\n" +
                "</xml>";
        return msg;
    }
}
