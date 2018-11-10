package com.yuan.cache.utils;

import com.yuan.cache.domain.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: AccountColl
 * Author:   yhl
 * Date:     2018/11/4 23:16
 * Description: ${DESCRIPTION}
 */
@Component("accountColl")
public class AccountColl {
    final static Map<Integer,Account> accountMaps = new HashMap<Integer,Account>();

    static {
        accountMaps.put(1,new Account(1,"1",1));
        accountMaps.put(2,new Account(2,"2",2));
        accountMaps.put(3,new Account(3,"3",3));
    }
    public Account getAccountById(int id){
        return accountMaps.get(id);
    }

    public void updateAccountById(Account account){
        accountMaps.put(account.getId(),account);
    }
}
