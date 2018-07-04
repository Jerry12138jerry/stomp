package com.example.stomp.controller;

import com.example.stomp.entity.User;
import com.example.stomp.mq.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import com.example.stomp.entity.ClientMessage;
import com.example.stomp.entity.ServerMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName: WebSocketAction
 * @Description: websocket控制层
 */
@Controller
public class WebSocketAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @MessageMapping("/sendTest")
    @SendTo("/topic/subscribeTest")
    public ServerMessage sendDemo(ClientMessage message) throws IOException, TimeoutException {
        logger.info("接收到了信息" + message.getName());
        return new ServerMessage("你发送的消息为:");
    }

    @SubscribeMapping("/subscribeTest")
    public ServerMessage sub() throws IOException, TimeoutException {
        logger.info("XXX用户订阅了我。。。");
        String username = "周子健";
        System.out.println("推送。。。");
        //Receiver receiver = new Receiver();
        //User user = receiver.receive(hashMap);
        return new ServerMessage("感谢你订阅了我。。。"+username);
    }
}
