package com.yuan.business.dao;

import com.yuan.business.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * FileName: UserDao
 * Author:   yhl
 * Date:     2018/11/12 21:29
 * Description: ${DESCRIPTION}
 */
public interface UserDao {
    int insertUser(User user);
    User queryUser(@Param("") User u);
}
