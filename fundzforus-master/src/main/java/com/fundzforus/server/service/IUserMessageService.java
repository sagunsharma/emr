package com.fundzforus.server.service;

import com.fundzforus.server.domain.Message;

import java.util.List;

public interface IUserMessageService {
    List<Message> findAllMessagesByTenantId(int tenantId);

    List<Message> findTodayMessagesByTenantId(int tenantId);

    List<Message> findTomorrowMessagesByTenantId(int tenantId);

    List<Message> findOneWeekMessagesByTenantId(int tenantId);

    Message getMessageById(int id);

    int createMessage(Message message);

    int updateMessage(Message message);

    int deleteMessage(int messageId);
}