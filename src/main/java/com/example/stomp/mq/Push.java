package com.example.stomp.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class Push {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
        //客户端只要订阅了/topic/subscribeTest主题，调用这个方法即可
            //messagingTemplate.convertAndSend("/topic/subscribeTest", new ServerMessage("服务器主动推的数据"));

    }
