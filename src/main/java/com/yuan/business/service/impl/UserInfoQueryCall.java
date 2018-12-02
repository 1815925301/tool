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
 * FileName: UserInfoCall
 * Author:   yhl
 * Date:     2018/12/2 14:02
 * Description: ${DESCRIPTION}
 */
@Component("userInfoQueryCall")
public class UserInfoQueryCall extends AbstractTask {

    private String id;
    private String username;
    @Resource
    private UserManage userManage;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
