package com.example.thechatroom.service.impl;

import com.example.thechatroom.domain.ChatRoomInfo;
import com.example.thechatroom.mapper.ChatRoomInfoMapper;
import com.example.thechatroom.service.ChatRoomInfoService;
import com.example.thechatroom.util.DataUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * @author WOOGUGU
 * @description 针对表【chat_room_info(聊天室基本信息)】的数据库操作Service实现
 * @createDate 2022-06-06 20:05:54
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatRoomInfoServiceImpl implements ChatRoomInfoService {
    private final ChatRoomInfoMapper chatRoomInfoMapper;

    @Override
    public List<ChatRoomInfo> selectRoomInfoByUserId(BigInteger userId1, BigInteger userId2) {
        ChatRoomInfo chatRoomInfo = chatRoomInfoMapper.getRoomIdByUserId(userId1, userId2);
        String roomId;
        if (chatRoomInfo == null) {
            // 聊天室不存在，创建新聊天室
            roomId = DataUtils.get16uuid();
//            log.info("聊天室不存在，创建新聊天室，roomId={}", roomId);
            createChatRoom(roomId, userId1, userId2);
        } else {
            roomId = chatRoomInfo.getRoomId();
        }
        return chatRoomInfoMapper.getAllByRoomId(roomId);
    }

    @Override
    public void createChatRoom(String roomId, BigInteger userId1, BigInteger userId2) {
        // FIXME: 2020/6/6 创建聊天室时，需先判断roomId是否存在
        chatRoomInfoMapper.initChatRoomInfo(roomId, userId1);
        chatRoomInfoMapper.initChatRoomInfo(roomId, userId2);
    }

    @Override
    public void updateOnlineInformation(String id, String sessionId, Date createTime) {
        chatRoomInfoMapper.updateSessionIdAndCreateTime(id, sessionId, createTime);
    }

    @Override
    public void updateOffLineInformation(String id, Date destroyTime) {
        chatRoomInfoMapper.updateDestroyTime(id, destroyTime);
    }
}
