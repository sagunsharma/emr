package com.fundzforus.server.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserVideo {
    private int id;
    private String videoName;
    private String videoDescription;
    private String videoURL;
    private String tenantId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDateTime;
    private String createdBy;
    private String updatedBy;
}