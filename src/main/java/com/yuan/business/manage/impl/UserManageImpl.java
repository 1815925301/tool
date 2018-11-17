package com.yuan.business.manage.impl;

import com.yuan.business.dao.UserDao;
import com.yuan.business.domain.User;
import com.yuan.business.manage.UserManage;
import com.yuan.business.service.impl.UserServiceImp;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * FileName: UserManageImpl
 * Author:   yhl
 * Date:     2018/11/12 21:40
 * Description: ${DESCRIPTION}
 */
@Component
public class UserManageImpl implements UserManage {
    private final Logger logger = LoggerFactory.getLogger(UserManageImpl.class);
    @Resource
    private UserDao userDao;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void insertUser(User user) {
        /*for(int i = 0; i<2;i++){

        }*/
        try {
            userDao.insertUser(user);
            testInsert(user);
            int i = 5;
            int j = i/0;
        }catch (RuntimeException e){
            logger.info("-----------------------");
            //e.printStackTrace();
            throw new RuntimeException();
        }

    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testInsert(User user){
        int i = 5;
        //user.setId(5);
        User u = new User(6,"11","22");
        userDao.insertUser(u);
        //insertUser(user);
        //int j = i/0;
    }
}
