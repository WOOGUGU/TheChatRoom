package com.example.thechatroom.service.impl;

import com.example.thechatroom.domain.ChatHistory;
import com.example.thechatroom.mapper.ChatHistoryMapper;
import com.example.thechatroom.service.ChatHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author WOOGUGU
 * @description 针对表【chat_history(聊天历史记录)】的数据库操作Service实现
 * @createDate 2022-06-06 20:05:54
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatHistoryServiceImpl implements ChatHistoryService {
    private final ChatHistoryMapper chatHistoryMapper;

    @Override
    public void addHistory(String roomId, BigInteger sendUserId, BigInteger receiveUserId, String message, Boolean isOnline) {
        if (isOnline) {
            ChatHistory chatHistory = new ChatHistory();
            chatHistory.setRoomId(roomId);
            chatHistory.setSendUserId(sendUserId);
            chatHistory.setReceiveUserId(receiveUserId);
            chatHistory.setMessage(message);
            chatHistory.setSendTime(new Date());
            chatHistory.setReceiveTime(new Date());
            chatHistoryMapper.addAllOnline(chatHistory);
        } else {
            ChatHistory chatHistory = new ChatHistory();
            chatHistory.setRoomId(roomId);
            chatHistory.setSendUserId(sendUserId);
            chatHistory.setReceiveUserId(receiveUserId);
            chatHistory.setMessage(message);
            chatHistory.setSendTime(new Date());
            chatHistoryMapper.addAllOffLine(chatHistory);
        }
    }

    @Override
    public List<ChatHistory> getUnreadByUserId(BigInteger receiveUserId) {
        List<ChatHistory> chatHistories = chatHistoryMapper.getUnreadByReceiveUserId(receiveUserId);
        return chatHistories;
    }

    @Override
    public List<ChatHistory> getUnreadByRoomId(String roomId, BigInteger receiveUserId) {
        List<ChatHistory> chatHistories = chatHistoryMapper.getUnreadByRoomId(roomId);
        // 将查找到的记录中的接收用户id更新为已读
        List<Integer> ids = new ArrayList<>();
        for (ChatHistory chatHistory : chatHistories) {
            if (chatHistory.getReceiveUserId().equals(receiveUserId)) {
                ids.add(chatHistory.getId());
            }
        }
        if (ids.size() > 0) {
            updateToRead(ids);
        }
        return chatHistories;
    }

    @Override
    public void updateToRead(List<Integer> ids) {
        for (int i : ids) {
            chatHistoryMapper.updateIsReadById(i);
        }
    }
}
