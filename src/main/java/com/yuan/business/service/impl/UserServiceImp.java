package com.yuan.business.service.impl;

import com.yuan.business.domain.User;
import com.yuan.business.manage.UserManage;
import com.yuan.business.manage.impl.UserManageImpl;
import com.yuan.business.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

    @Resource
    private UserManage userManage;
    @Override
    public void insertUser(User user) {
        try {
            userManage.insertUser(user);
        }catch (Exception e){
            logger.info("error111:"+e.getMessage());
        }
    }
    @Override
    public void queryUser(User user){
        userManage.queryUser(user);
    }
}
