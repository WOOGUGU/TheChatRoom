package com.example.thechatroom.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * 聊天历史记录
 *
 * @TableName chat_history
 */
@Data
public class ChatHistory implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     * 发送者用户id
     */
    private BigInteger sendUserId;

    /**
     * 接收者用户id
     */
    private BigInteger receiveUserId;

    /**
     * 聊天室id
     */
    private String roomId;

    /**
     * 聊天记录
     */
    private String message;

    /**
     * 发送时间
     */
    private Date sendTime;

    /**
     * 接收时间
     */
    private Date receiveTime;

    /**
     * 是否已读
     */
    private Integer isRead;

    private static final long serialVersionUID = 1L;
}