package com.yuan.cache.service;

import com.yuan.cache.domain.Account;

/**
 * FileName: AccountService
 * Author:   yhl
 * Date:     2018/11/4 22:58
 * Description: ${DESCRIPTION}
 */
public interface AccountService {

    public Account getById(int id);

    public void insertAccount(Account account);

    public void updateAccountCacheEvict(Account account);

    public Account updateAccountCachePut(Account account);
    public void updateAccountNoCache(Account account);

    public void reload();

}
