package com.tony.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void showDate(String date) {
        System.out.println("数据是：" + date);
    }
}
