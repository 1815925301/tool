package com.yuan.business.service;

import java.util.List;
import java.util.Map;

/**
 * FileName: UserInfoTask
 * Author:   yhl
 * Date:     2018/12/2 13:52
 * Description: ${DESCRIPTION}
 */
public interface UserInfoTask {
    List<Map<String,String>> invoke(Map<String,String> map);
}
