package com.yuan.cache.service.impl;

import com.yuan.cache.domain.Account;
import com.yuan.cache.service.AccountService;
import com.yuan.cache.utils.AccountColl;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * FileName: AccountServiceImpl
 * Author:   yhl
 * Date:     2018/11/4 22:59
 * Description: ${DESCRIPTION}
 */
@Component("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountColl accountColl;

    @Override
    @Cacheable(value="accountCache",key="#id")
    public Account getById(int id) {
        System.out.println("开始cacheable...");
        return accountColl.getAccountById(id);
    }

    @Override
    public void insertAccount(Account account) {

    }

    @Override
    @CacheEvict(value="accountCache",key="#account.getId()",beforeInvocation = true)
    public void updateAccountCacheEvict(Account account) {
        System.out.println("开始cacheEvict...");
        accountColl.updateAccountById(account);
    }

    @Override
    @CachePut(value="accountCache",key="#account.getId()",unless = "#result.name eq 'yuan'")
    public Account updateAccountCachePut(Account account) {
        System.out.println("CachePut...");
        accountColl.updateAccountById(account);
        return account;
    }
    public void updateAccountNoCache(Account account) {
        System.out.println("updateAccountNoCache...");
        accountColl.updateAccountById(account);
    }
    // 清空 accountCache 缓存
    @CacheEvict(value="accountCache",allEntries=true,beforeInvocation = true)
    public void reload() {
        throw new RuntimeException();
    }
}
