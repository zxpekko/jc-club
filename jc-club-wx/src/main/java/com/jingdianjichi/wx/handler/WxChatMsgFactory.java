package com.jingdianjichi.wx.handler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:03 2024/4/5
 */
@Component
public class WxChatMsgFactory implements InitializingBean {
    @Resource
    private List<WxChatMsgHandler> handlerList;
    private HashMap<WxChatMsgTypeEnum,WxChatMsgHandler> hashMap=new HashMap<>();

    public WxChatMsgHandler getByMsgType(String msgType){
        WxChatMsgTypeEnum byMsgType = WxChatMsgTypeEnum.getByMsgType(msgType);
        return hashMap.get(byMsgType);
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        for(WxChatMsgHandler wxChatMsgHandler:handlerList){
            hashMap.put(wxChatMsgHandler.getTypeEnum(),wxChatMsgHandler);
        }
    }
}