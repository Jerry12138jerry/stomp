package com.example.stomp.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Receiver {
        private static final Logger log = LoggerFactory.getLogger(Receiver.class);
        @RabbitListener(queues = "my-rabbitmq")
        public void receive (HashMap<String, Object> hm){
            System.out.println("我收到的消息是：" + hm);
            System.out.println("消费。。。");
            System.out.println(hm.get("name"));
        }
}
