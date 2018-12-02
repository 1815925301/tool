package com.yuan.business.service.impl;

import com.yuan.annotation.Executor;
import com.yuan.business.service.UserInfoTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * FileName: UserInfoTaskImpl
 * Author:   yhl
 * Date:     2018/12/2 13:54
 * Description: ${DESCRIPTION}
 */
@Component("userInfoTaskQuery")
public class UserInfoTaskQueryImpl implements UserInfoTask {
    private static Logger logger = LogManager.getLogger(UserInfoTaskQueryImpl.class);
    @Override
    @Executor(taskClassName ="com.yuan.business.service.impl.UserInfoQueryCall",isSingle=false)
    public List<Map<String,String>> invoke(Map<String,String> map) {
        logger.error("UserInfoTaskQueryImpl...............end.........");
        List<Map<String,String>> resultMap = new LinkedList<>();
        //Map<String,String> map1= new HashMap<>();
       // map1.put("1","1");
       // resultMap.add(map1);
        //int i = 10/0;
        return resultMap;
    }
}




