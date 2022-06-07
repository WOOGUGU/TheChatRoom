package com.example.thechatroom.service;

import com.example.thechatroom.domain.ChatRoomInfo;

import java.math.BigInteger;
import java.util.Date;
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

    /**
     * 创建聊天室
     *
     * @param roomId  聊天室id
     * @param userId1 用户1id
     * @param userId2 用户2id
     */
    void createChatRoom(String roomId, BigInteger userId1, BigInteger userId2);

    /**
     * 更新用户链接状态（上线）
     *
     * @param id         聊天室记录id
     * @param sessionId  用户链接sessionId
     * @param createTime 用户创建链接
     */
    void updateOnlineInformation(String id, String sessionId, Date createTime);

    /**
     * 更新用户状态（下线）
     *
     * @param id          聊天室记录id
     * @param destroyTime 用户链接离线时间
     */
    void updateOffLineInformation(String id, Date destroyTime);
}
