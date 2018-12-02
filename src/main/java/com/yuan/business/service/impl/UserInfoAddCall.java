package com.yuan.business.service.impl;

import com.alibaba.fastjson.JSON;
import com.yuan.business.domain.User;
import com.yuan.business.manage.UserManage;
import com.yuan.task.AbstractTask;
import com.yuan.utils.JsonUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * FileName: UserInfoAddCall
 * Author:   yhl
 * Date:     2018/12/2 15:44
 * Description: ${DESCRIPTION}
 */
@Component("userInfoAddCall")
public class UserInfoAddCall extends AbstractTask {
    @Resource
    private UserManage userManage;

    private String id;
    @Override
    public Map<String, String> call() throws Exception {
        User user = new User();
        user.setId(Integer.valueOf(id));
        User query = userManage.queryUser(user);
        String s = JsonUtil.toJson(query);
        Map<String,String> map = new HashMap<>();
        map.put(id,s);
        return map;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
