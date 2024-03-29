package com.example.thechatroom.mapper;

import com.example.thechatroom.domain.ChatRoomInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * @author WOOGUGU
 * @description 针对表【chat_room_info(聊天室基本信息)】的数据库操作Mapper
 * @createDate 2022-06-06 20:05:54
 * @Entity com.example.thechatroom.domain.ChatRoomInfo
 */

@Mapper
public interface ChatRoomInfoMapper {
    /**
     * 初始化聊天室
     *
     * @param roomId 聊天室id
     * @param userId 用户id
     * @return 是否初始化成功
     */
    int initChatRoomInfo(@Param("roomId") String roomId, @Param("userId") BigInteger userId);

    /**
     * 根据聊天室id查询聊天室成员信息
     *
     * @param roomId 聊天室id
     * @return 聊天室成员信息
     */
    List<ChatRoomInfo> getAllByRoomId(@Param("roomId") String roomId);

    /**
     * 根据聊天室成员查找聊天室id
     *
     * @param userId1 用户1id
     * @param userId2 用户2id
     * @return roomId
     */
    ChatRoomInfo getRoomIdByUserId(@Param("userId1") BigInteger userId1, @Param("userId2") BigInteger userId2);

    /**
     * 更新用户在线状态
     *
     * @param sessionId  用户sessionId
     * @param createTime 用户创建时间
     * @param id         用户id
     * @return 是否更新成功
     */
    int updateSessionIdAndCreateTime(@Param("id") String id, @Param("sessionId") String sessionId, @Param("createTime") Date createTime);

    /**
     * 更新用户离线时间
     *
     * @param destroyTime 用户离线时间
     * @param id          用户id
     * @return 是否更新成功
     */
    int updateDestroyTime(@Param("id") String id, @Param("destroyTime") Date destroyTime);
}
