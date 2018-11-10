package com.yuan.cache.utils;

import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

import java.util.Collection;

/**
 * FileName: MyCacheManager
 * Author:   yhl
 * Date:     2018/11/5 21:54
 * Description: 自定义注解管理器，仅仅管理 MyCache 类的实例
 */
public class MyCacheManager extends AbstractCacheManager {
    private Collection<? extends MyCache> caches;

    /**
     * Specify the collection of Cache instances to use for this CacheManager.
     */
    public void setCaches(Collection<? extends MyCache> caches) {
        this.caches = caches;
    }
    @Override
    protected Collection<? extends Cache> loadCaches() {
        return this.caches;
    }
}
