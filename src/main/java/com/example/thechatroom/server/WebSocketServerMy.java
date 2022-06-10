package com.example.thechatroom.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author WOOGUGU
 */

@Component
@Slf4j
@Service
@ServerEndpoint("/api/websocket-my")
public class WebSocketServerMy {
    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static Integer onlineCount = 0;

    /**
     * 建立链接调用的方法
     *
     * @param session 当前连接的会话
     * @PathParam("sid") String sid
     */
    @OnOpen
    public void onOpen(Session session) {
    /*
    * 基本信息入库（登入）
    * param：id（聊天室记录表id）
    *
     */
    }

    /**
     * 连接关闭调用的方法
     *
     * @param session 关闭的Session
     */
    @OnClose
    public void onClose(Session session) {
        /*
        * 基本信息入库（登出）
        * param：id（聊天室记录表id）
         */
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnMessage
    public void onMessage(String message) {
        log.info("来自客户端的消息:" + message);
        // 根据传入的聊天室记录id找到发送对象，发出消息
    }

    /**
     * 发生错误时调用
     *
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     * @param error   发生的错误
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误：{}，sessionId：{}", error.getMessage(), session.getId());
        error.printStackTrace();
    }

    private static Integer getOnlineCount() {
        return onlineCount;
    }
}
