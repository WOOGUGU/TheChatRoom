package com.example.thechatroom.mapper;

import com.example.thechatroom.domain.ChatHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

/**
 * @author WOOGUGU
 * @description 针对表【chat_history(聊天历史记录)】的数据库操作Mapper
 * @createDate 2022-06-06 20:05:54
 * @Entity com.example.thechatroom.domain.ChatHistory
 */

@Mapper
public interface ChatHistoryMapper {
    /**
     * 插入一条记录(已读）
     *
     * @param chatHistory 要插入的记录
     * @return 是否成功
     */
    int addAllOnline(ChatHistory chatHistory);

    /**
     * 插入一条记录(未读）
     *
     * @param chatHistory 要插入的记录
     * @return 是否成功
     */
    int addAllOffLine(ChatHistory chatHistory);

    /**
     * 查找某人全部未读消息
     *
     * @param userId 用户id
     * @return 查找到的记录
     */
    List<ChatHistory> getUnreadByUserId(@Param("userId") BigInteger userId);

    /**
     * 查找某聊天室未读消息
     *
     * @param roomId 聊天室id
     * @return 查找到的记录
     */
    List<ChatHistory> getUnreadByRoomId(@Param("romeId") String roomId);

    /**
     * 查找某聊天室全部消息记录
     *
     * @param roomId 聊天室id
     * @return 查找到的记录
     */
    List<ChatHistory> getAllByRoomId(@Param("roomId") String roomId);

    /**
     * 修改某条记录为已读
     *
     * @param id 记录id
     * @return 是否成功
     */
    int updateIsReadById(@Param("id") Integer id);
}
