package com.fundzforus.server.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Data
public class Message {
    private int id;
    private String messageTitle;
    private String messageDescription;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime messageDateTime;
    private String messageDateTimeField;
    private String messageDateTimeStr;
    private String messageDayOfMonth;
    private String messageMonth;
    private String messageTime;

    private String tenantId;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime createDateTime;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime updateDateTime;
    private String createdBy;
    private String updatedBy;

    public String getMessageDayOfMonth() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        messageDayOfMonth = messageDateTime.format(formatter);
        return messageDayOfMonth;
    }

    public String getMessageMonth() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM");
        messageMonth = messageDateTime.format(formatter);
        return messageMonth;
    }

    public String getMessageTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        messageTime = messageDateTime.format(formatter);
        return messageTime;
    }

    public String getMessageDateTimeStr() {
        if (messageDateTime != null) {
            ZonedDateTime zdt = ZonedDateTime.of(messageDateTime, ZoneId.of("UTC"));
            messageDateTimeStr = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).format(zdt);
        }

        return messageDateTimeStr;
    }

    public String getMessageDateTimeField() {
        if (StringUtils.isBlank(messageDateTimeField) && messageDateTime != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy HH:mm");
            messageDateTimeField = messageDateTime.format(formatter);
            return messageDateTimeField;
        } else {
            return messageDateTimeField;
        }
    }
}