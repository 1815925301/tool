package com.yuan.business.service.impl;

import com.yuan.annotation.Executor;
import com.yuan.business.service.UserInfoTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * FileName: UserInfoTaskAddImpl
 * Author:   yhl
 * Date:     2018/12/2 15:41
 * Description: ${DESCRIPTION}
 */
@Component("userInfoTaskAdd")
public class UserInfoTaskAddImpl implements UserInfoTask {
    private static Logger logger = LogManager.getLogger(UserInfoTaskAddImpl.class);
    @Override
    @Executor(taskClassName ="com.yuan.business.service.impl.UserInfoAddCall",isSingle=false)
    public List<Map<String,String>> invoke(Map<String, String> map) {
        logger.error("UserInfoTaskAddImpl-----end------");
        List<Map<String,String>> resultMap = new LinkedList<>();
        return resultMap;
    }
}
