package com.example.thechatroom.service;

import com.example.thechatroom.domain.ChatHistory;

import java.math.BigInteger;
import java.util.List;

/**
 * @author WOOGUGU
 * @description 针对表【chat_history(聊天历史记录)】的数据库操作Service
 * @createDate 2022-06-06 20:05:54
 */
public interface ChatHistoryService {

    /**
     * 添加一条聊天记录
     *
     * @param roomId        聊天室id
     * @param sendUserId    发送用户id
     * @param receiveUserId 接收用户id
     * @param message       聊天内容
     * @param isOnline      是否为在线消息（是否已读）
     */
    void addHistory(String roomId, BigInteger sendUserId, BigInteger receiveUserId, String message, Boolean isOnline);

    /**
     * 查找某人全部未读消息
     *
     * @param receiveUserId 接收用户id
     * @return 查找到的记录
     */
    List<ChatHistory> getUnreadByUserId(BigInteger receiveUserId);
}
