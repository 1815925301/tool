package com.yuan.tool.thread;

import com.yuan.business.domain.User;
import com.yuan.business.service.UserInfoTask;
import com.yuan.business.service.UserService;
import com.yuan.executor.ThreadPoolSingle;
import com.yuan.utils.JsonUtil;
import org.apache.ibatis.annotations.Case;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.json.Json;
import java.lang.annotation.Retention;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: UserInfoFutureTest
 * Author:   yhl
 * Date:     2018/12/2 15:30
 * Description: ${DESCRIPTION}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-main.xml")
public class UserInfoFutureTest {
    private static Logger logger = LogManager.getLogger(UserInfoFutureTest.class);
    @Resource(name = "userInfoTaskQuery")
    private UserInfoTask userInfoTaskQuery;
    @Resource(name = "userInfoTaskAdd")
    private UserInfoTask userInfoTaskAdd;

    @Resource
    private UserService userService;

    @Test
    public void aa(){
        LocalThread localThread = new LocalThread();
        Thread thread = new Thread(localThread);
        thread.start();
       // LocalThread1 localThread1 = new LocalThread1();
        //localThread1.start();
    }
    @Test
    public void testFuture() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        /*map.put("2", "2");
        map.put("3", "2");
        map.put("4", "2");
        map.put("5", "2");
        map.put("6", "2");
        map.put("7", "2");*/
        for (int i = 1; i < 7; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                    List<Map<String, String>> invoke = userInfoTaskQuery.invoke(map);
                    logger.error("userInfoTaskQuery-----invokeResult:{}",JsonUtil.toJson(invoke));
                    break;
                case 2:
                case 4:
                case 6:
                    List<Map<String, String>> invoke1 = userInfoTaskAdd.invoke(map);
                    logger.error("userInfoTaskAdd-----invokeResult:{}",JsonUtil.toJson(invoke1));
                    break;
                default:
                    System.out.println("default");break;
            }
        }
    }

    class LocalThread implements Runnable {
        @Override
        public void run() {
            Map<String, String> map = new HashMap<>();
            map.put("1", "1");
            map.put("2", "2");
            map.put("3", "2");
            map.put("4", "2");
            map.put("5", "2");
            map.put("6", "2");
            map.put("7", "2");
            User user = new User();
            user.setId(1);
            userService.queryUser(user);
//            List<Map<String, String>> invoke = userInfoTaskQuery.invoke(map);
//            logger.error("userInfoTaskQuery-----invokeResult:{}", JsonUtil.toJson(invoke));
            System.out.println(1111);
        }
    }

    class LocalThread1 extends Thread {
        @Override
        public void run() {
            Map<String, String> map = new HashMap<>();
            map.put("1", "1");
            map.put("2", "2");
            map.put("3", "2");
            map.put("4", "2");
            map.put("5", "2");
            map.put("6", "2");
            map.put("7", "2");
//            List<Map<String, String>> invoke1 = userInfoTaskAdd.invoke(map);
//            logger.error("userInfoTaskAdd-----invokeResult:{}", JsonUtil.toJson(invoke1));
            System.out.println(112211);

        }
    }
}
