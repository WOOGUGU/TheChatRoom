package com.example.thechatroom.service;

import com.example.thechatroom.domain.ChatRoomInfo;

import java.math.BigInteger;
import java.util.List;

/**
 * @author WOOGUGU
 * @description 针对表【chat_room_info(聊天室基本信息)】的数据库操作Service
 * @createDate 2022-06-06 20:05:54
 */
public interface ChatRoomInfoService {

    /**
     * 根据聊天室成员查找聊天室基本信息，若不存在则创建聊天室
     *
     * @param userId1 用户1id
     * @param userId2 用户2id
     * @return 聊天室基本信息列表（两组信息）
     */
    List<ChatRoomInfo> selectRoomInfoByUserId(BigInteger userId1, BigInteger userId2);
}
