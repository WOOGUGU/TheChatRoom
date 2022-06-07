package com.example.thechatroom.controller;

import com.example.thechatroom.service.ChatHistoryService;
import com.example.thechatroom.service.ChatRoomInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;

/**
 * 聊天室控制器
 *
 * @author WOOGUGU
 */

@Controller
@RequiredArgsConstructor
public class ChatRoomController {
    private final ChatHistoryService chatHistoryService;
    private final ChatRoomInfoService chatRoomInfoService;


}
