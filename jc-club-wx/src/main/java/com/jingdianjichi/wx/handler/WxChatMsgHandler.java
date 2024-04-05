package com.jingdianjichi.wx.handler;

import java.util.Map;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:00 2024/4/5
 */
public interface WxChatMsgHandler {
    public WxChatMsgTypeEnum getTypeEnum();
    public String dealMsg(Map<String,String> messageMap);
}
