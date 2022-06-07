package com.example.thechatroom.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import lombok.Data;

/**
 * 聊天室基本信息
 * @TableName chat_room_info
 */
@Data
public class ChatRoomInfo implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 聊天室id
     */
    private String roomId;

    /**
     * 用户id
     */
    private BigInteger userId;

    /**
     * WsSession id
     */
    private String sessionId;

    /**
     * 是否过期
     */
    private Integer isExpired;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 销毁时间
     */
    private Date destroyTime;

    private static final long serialVersionUID = 1L;
}