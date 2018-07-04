package com.example.stomp;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;

@SpringBootApplication
public class StompApplication implements CommandLineRunner{

    @Autowired
    RabbitTemplate rabbitTemplate;//使用springboot配置好的队列RabbitTemplate

    /**
     * 定义目的地队列，命名为my-rabbitmq
     * 这里实际上是要往rabbitmq里注册队列名称
     * */
    @Bean
    public Queue myQueue(){
        return new Queue("my-rabbitmq");
    }

    public static void main(String[] args) {
		SpringApplication.run(StompApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        //ͨ使用RabbitTemplate的convertAndSend发送给队列my-rabbitmq消息
        HashMap<String, Object> hm=new HashMap<String, Object>();
        //String hm = "上海大世界";
                hm.put("name", "周子健");
                hm.put("age", 24);
                hm.put("address", "上海虹口");

        rabbitTemplate.convertAndSend("my-rabbitmq", hm);
        System.out.println("生产。。。。。");
    }
}
