package com.yuan.business.manage.impl;

import com.yuan.business.dao.UserDao;
import com.yuan.business.domain.User;
import com.yuan.business.manage.UserManage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * FileName: UserManageImpl
 * Author:   yhl
 * Date:     2018/11/12 21:40
 * Description: ${DESCRIPTION}
 */
@Component
public class UserManageImpl implements UserManage {
    @Resource
    private UserDao userDao;
    @Override
    public void insertUser(User user) {
       /* for(int i = 0; i<2;i++){
        }*/
        userDao.insertUser(user);
    }
}
