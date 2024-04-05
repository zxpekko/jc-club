package com.jingdianjichi.wx.controller;

import com.jingdianjichi.wx.handler.WxChatMsgFactory;
import com.jingdianjichi.wx.handler.WxChatMsgHandler;
import com.jingdianjichi.wx.utils.MessageUtil;
import com.jingdianjichi.wx.utils.SHA1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:22 2024/4/5
 */
@RestController
@RequestMapping("/wx")
@Slf4j
public class CallBackController {
    private static final String token = "adwidhaidwoaid";
    @Resource
    private WxChatMsgFactory wxChatMsgFactory;
    @RequestMapping("/test")
    public String test(){
        return "hello world";
    }
    /**
     * 回调消息校验
     */
    @GetMapping("/callback")
    public String callback(@RequestParam("signature") String signature,
                           @RequestParam("timestamp") String timestamp,
                           @RequestParam("nonce") String nonce,
                           @RequestParam("echostr") String echostr) {
        log.info("get验签请求参数：signature:{}，timestamp:{}，nonce:{}，echostr:{}",
                signature, timestamp, nonce, echostr);
        String shaStr = SHA1.getSHA1(token, timestamp, nonce, "");
        if (signature.equals(shaStr)) {
            return echostr;
        }
        return "unknown";
    }
    @PostMapping(value = "/callback", produces = "application/xml;charset=UTF-8")
    public String callback(
            @RequestBody String requestBody,
            @RequestParam("signature") String signature,
            @RequestParam("timestamp") String timestamp,
            @RequestParam("nonce") String nonce,
            @RequestParam(value = "msg_signature", required = false) String msgSignature) {
        log.info("接收到微信消息：requestBody：{}", requestBody);
        Map<String, String> messageMap = MessageUtil.parseXml(requestBody);
//        String toUserName = messageMap.get("ToUserName");
//        String fromUserName = messageMap.get("FromUserName");
//        String msg="<xml>\n" +
//                "  <ToUserName><![CDATA["+fromUserName+"]]></ToUserName>\n" +
//                "  <FromUserName><![CDATA["+toUserName+"]]></FromUserName>\n" +
//                "  <CreateTime>12345678</CreateTime>\n" +
//                "  <MsgType><![CDATA[text]]></MsgType>\n" +
//                "  <Content><![CDATA[您好,欢迎关注nnuclub^_^]]></Content>\n" +
//                "</xml>";
        String msgType = messageMap.get("MsgType");
        String event = messageMap.get("Event") == null ? "" : messageMap.get("Event");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(msgType);
        if(!StringUtils.isEmpty(event)){
            stringBuilder.append(".");
            stringBuilder.append(event);
        }
        String msg = stringBuilder.toString();
        WxChatMsgHandler byMsgType = wxChatMsgFactory.getByMsgType(msg);
        if(Objects.isNull(byMsgType)){
            return "unknow";
        }
        String replyContent = byMsgType.dealMsg(messageMap);
        log.info("replyContent:{}", replyContent);
        return replyContent;
    }
}
//<FromUserName><![CDATA[oijoY6VEAR32q0beHmzRFP9cdDl4]]></FromUserName>
//<CreateTime>1712303498</CreateTime>
//<MsgType><![CDATA[event]]></MsgType>
//<Event><![CDATA[subscribe]]></Event>
//<EventKey><![CDATA[]]></EventKey>
//</xml>

//<FromUserName><![CDATA[oijoY6VEAR32q0beHmzRFP9cdDl4]]></FromUserName>
//<CreateTime>1712303504</CreateTime>
//<MsgType><![CDATA[text]]></MsgType>
//<Content><![CDATA[hello]]></Content>
//<MsgId>24514293746652706</MsgId>
//</xml>