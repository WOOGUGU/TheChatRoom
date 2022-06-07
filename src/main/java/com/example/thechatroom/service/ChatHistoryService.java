package com.example.thechatroom.service;

import java.math.BigInteger;

/**
 * @author WOOGUGU
 * @description 针对表【chat_history(聊天历史记录)】的数据库操作Service
 * @createDate 2022-06-06 20:05:54
 */
public interface ChatHistoryService {

    /**
     * 添加一条聊天记录
     *
     * @param roomId   聊天室id
     * @param userId   用户id
     * @param message  聊天内容
     * @param isOnline 是否为在线消息（是否已读）
     */
    void addHistory(String roomId, BigInteger userId, String message, Boolean isOnline);
}
