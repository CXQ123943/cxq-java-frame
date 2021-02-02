package com.steven.springboot2.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author CXQ
 * @version 1.0
 */
@ServerEndpoint("/websocket-server/{id}")
@Component
public class WebSocketServer {

    /**
     * 用于存储每个BS用户的WebSocketServer实例
     * ConcurrentHashMap保证线程安全，static保证实例唯一
     */
    private static Map<String, WebSocketServer> servers = new ConcurrentHashMap<>();
    private Session session;

    @OnOpen
    public void onOpen(@PathParam("id") String id, Session session) {
        this.session = session;

        servers.put(id, this);
        System.out.println("客户端：用户" + id + "上线...");
        System.out.println("客户端：当前上线人数：" + servers.size());
        sendToAll("用户 " + id + " 上线...");
    }

    @OnClose
    public void onClose(@PathParam("id") String id, Session session) {
        servers.remove(id);
        System.out.println("客户端：用户" + id + "下线...");
        System.out.println("客户端：当前上线人数：" + servers.size());
        sendToAll("用户 " + id + " 下线...");
    }

    @OnMessage
    public void onMessage(@PathParam("id") String id, String message, Session session) {
        sendToAll("客户端：用户 " + id + "发送： " + message);
    }

    @OnError
    public void onError(@PathParam("id") String id, Throwable e, Session session) {
        sendToAll("客户端：用户 " + id + " 发生错误...");
        e.printStackTrace();
    }

    private void sendToAll(String message){
        for (String key : servers.keySet()) {
            servers.get(key).session.getAsyncRemote().sendText(message);
        }
    }
}