package com.example.thechatroom;

import com.example.thechatroom.mapper.ChatRoomInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.Date;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TheChatRoomApplicationTests {
    @Autowired
    private ChatRoomInfoMapper chatRoomInfoMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void initChatRoomInfo() {
        chatRoomInfoMapper.initChatRoomInfo("test", BigInteger.valueOf(1));
    }

    @Test
    void updateSessionIdAndCreateTime() {
        chatRoomInfoMapper.updateSessionIdAndCreateTime("session", new Date(), "2");
    }

    @Test
    void updateDestroyTime() {
        chatRoomInfoMapper.updateDestroyTime( new Date(), "2");
    }
}
