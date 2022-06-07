package com.example.thechatroom;

import com.example.thechatroom.domain.ChatRoomInfo;
import com.example.thechatroom.mapper.ChatRoomInfoMapper;
import com.example.thechatroom.service.ChatRoomInfoService;
import com.example.thechatroom.util.DataUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TheChatRoomApplicationTests {
    @Autowired
    private ChatRoomInfoMapper chatRoomInfoMapper;
    @Autowired
    private ChatRoomInfoService chatRoomInfoService;

    @Test
    void contextLoads() {
        for (int i = 0; i < 10; i++) {
            log.info(DataUtils.get16uuid());
        }
    }

    @Test
    void initChatRoomInfo() {
        chatRoomInfoMapper.initChatRoomInfo("test", BigInteger.valueOf(1));
    }

    @Test
    void getRoomIdByUserId() {
        BigInteger userId1 = BigInteger.valueOf(2);
        BigInteger userId2 = BigInteger.valueOf(3);
        ChatRoomInfo res = chatRoomInfoMapper.getRoomIdByUserId(userId1, userId2);
        if (res == null) {
            log.info("res is null");
        } else {
            log.info("res = {}", res);
        }
    }

    @Test
    void updateSessionIdAndCreateTime() {
        chatRoomInfoMapper.updateSessionIdAndCreateTime("2", "session", new Date());
    }

    @Test
    void updateDestroyTime() {
        chatRoomInfoMapper.updateDestroyTime("2", new Date());
    }

    @Test
    void selectRoomInfoByUserId() {
        BigInteger userId1 = BigInteger.valueOf(2);
        BigInteger userId2 = BigInteger.valueOf(3);
        List<ChatRoomInfo> res = chatRoomInfoService.selectRoomInfoByUserId(userId1, userId2);
        if (res == null) {
            log.info("res is null");
        } else {
            for (Object o : res) {
                log.info("res = {}", o.toString());
            }
        }
    }

    @Test
    void userOnlineAndOffLine() {
        chatRoomInfoService.updateOnlineInformation("16", "sessionN", new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chatRoomInfoService.updateOffLineInformation("16", new Date());
    }
}
