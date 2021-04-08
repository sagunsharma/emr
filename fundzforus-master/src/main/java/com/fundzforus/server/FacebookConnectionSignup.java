package com.fundzforus.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    @Override
    public String execute(Connection<?> connection) {
        System.out.println("FacebookConnectionSignup invoked");
        return "";
    }
}
