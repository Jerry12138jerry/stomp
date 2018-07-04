package com.example.stomp.mq;

import com.example.stomp.entity.User;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import sun.misc.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeoutException;

public class Producer {
        public final static String QUEUE_NAME="rabbitMQ.test";

        public static void main(String[] args) throws IOException, TimeoutException {
            //创建连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            //设置RabbitMQ相关信息
            factory.setHost("localhost");
            //factory.setUsername("lp");
            //factory.setPassword("");
            // factory.setPort(2088);
            //创建一个新的连接
            Connection connection = factory.newConnection();
            //创建一个通道
            Channel channel = connection.createChannel();
            //  声明一个队列        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello RabbitMQ";
            //User user = new User();
            //user.setName("tim");
            //user.setAge(11);
            //System.out.println(user);
            //序列化
            //ObjectOutputStream oos = null;
            //oos = new ObjectOutputStream(new FileOutputStream(new File("E:\\WebPackage\\a.txt")));
            //oos.writeObject(user);
            //org.apache.tomcat.util.http.fileupload.IOUtils.closeQuietly(oos);
            //System.out.println("对象已经序列化");
            //发送消息到队列中
            //message.getBytes("UTF-8")
            channel.basicPublish("", QUEUE_NAME, null,message.getBytes("UTF-8"));
            System.out.println("Producer Send +'" + message + "'");
            //关闭通道和连接
            channel.close();
            connection.close();
        }
    }

