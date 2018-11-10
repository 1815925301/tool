package com.yuan.tool;

/**
 * FileName: CacheTest
 * Author:   yhl
 * Date:     2018/11/4 21:22
 * Description: 缓存测试
 */

import com.yuan.cache.domain.Account;
import com.yuan.cache.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-main.xml")
public class CacheTest {
    private final Logger logger = LoggerFactory.getLogger(CacheTest.class);
    @Resource
    private AccountService accountService;
    /*@Before
    public void setUp() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-cache.xml");
        accountService = context.getBean("accountService", AccountService.class);
    }*/
    @Test
    public void testCacheable(){
        Account byId = accountService.getById(1);
        System.out.println(byId.toString());
        logger.info("aa:{}",1);
        Account byId1 = accountService.getById(1);
        System.out.println(byId1.toString());
        Account account = new Account(1,"yaun",333);
        accountService.updateAccountCacheEvict(account);
        Account byId2 = accountService.getById(1);
        System.out.println(byId2.toString());
    }

    @Test
    public void testExpection(){
        Account byId = accountService.getById(1);
        System.out.println(byId.toString());
        Account account = new Account(1,"yaun",333);
        accountService.updateAccountNoCache(account);
        Account byId1 = accountService.getById(1);
        System.out.println(byId1.toString());
        try{
            accountService.reload();
        }catch (Exception e){
            System.out.println("yichang");
        }
        Account byId2 = accountService.getById(1);
        System.out.println(byId2.toString());
    }
    @Test
    public void testCachePut(){
        Account byId = accountService.getById(1);
        //System.out.println(byId.toString());
        logger.info(byId.toString());
        Account account = new Account(1,"yuan",333);
        accountService.updateAccountCachePut(account);
        Account byId2 = accountService.getById(1);
        System.out.println(byId2.toString());
    }

    @Test
    public void aa(){

    }
}
