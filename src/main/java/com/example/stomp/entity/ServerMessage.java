package com.example.stomp.entity;

/**
 *
 * @ClassName: ServerMessage
 * @Description: 服务端发送消息实体
 */
public class ServerMessage {
    private String responseMessage;

    public ServerMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
