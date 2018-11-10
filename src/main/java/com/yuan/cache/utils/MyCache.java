package com.yuan.cache.utils;

import com.yuan.cache.domain.Account;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * FileName: MyCache
 * Author:   yhl
 * Date:     2018/11/5 21:56
 * Description: 自定义缓存注解实现
 */
public class MyCache implements Cache {
    private String name;
    private Map<Integer,Account> store = new HashMap<Integer,Account>();
    public MyCache(String name) {
        this.name = name;
    }
    public MyCache(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object getNativeCache() {
        return store;
    }

    @Override
    public ValueWrapper get(Object key) {
        ValueWrapper result = null;
        Account thevalue = store.get(key);
        if(thevalue!=null) {
            result = new SimpleValueWrapper(thevalue);
        }
        return result;
    }

    @Override
    public <T> T get(Object o, Class<T> aClass) {
        return null;
    }

    @Override
    public <T> T get(Object o, Callable<T> callable) {
        return null;
    }

    @Override
    public void put(Object key, Object value) {
        Account thevalue = (Account)value;
        store.put((Integer)key, thevalue);
    }

    @Override
    public ValueWrapper putIfAbsent(Object o, Object o1) {
        return null;
    }

    @Override
    public void evict(Object key) {
        store.remove(key);
    }

    @Override
    public void clear() {
    }

}
