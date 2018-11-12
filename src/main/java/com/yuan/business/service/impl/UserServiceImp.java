package com.yuan.business.service.impl;

import com.yuan.business.domain.User;
import com.yuan.business.manage.UserManage;
import com.yuan.business.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * FileName: UserServiceImp
 * Author:   yhl
 * Date:     2018/11/12 21:35
 * Description: ${DESCRIPTION}
 */
@Component
public class UserServiceImp implements UserService {
    @Resource
    private UserManage userManage;
    @Override
    public void insertUser(User user) {
        userManage.insertUser(user);
    }
}
