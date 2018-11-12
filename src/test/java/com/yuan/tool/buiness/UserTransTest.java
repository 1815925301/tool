package com.yuan.tool.buiness;

import com.yuan.business.domain.User;
import com.yuan.business.service.UserService;
import com.yuan.tool.CacheTest;
import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * FileName: UserTransTest
 * Author:   yhl
 * Date:     2018/11/12 21:49
 * Description: ${DESCRIPTION}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-main.xml")
public class UserTransTest {
    private final Logger logger = LoggerFactory.getLogger(UserTransTest.class);

    @Resource
    private UserService userService;
    @Test
    public void testTrans(){
        User user = new User(4,"11","22");
        userService.insertUser(user);
        logger.info("111");
    }
}
