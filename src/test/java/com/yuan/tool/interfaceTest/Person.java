package com.yuan.tool.interfaceTest;

/**
 * FileName: PersonTest
 * Author:   yhl
 * Date:     2019/11/30 12:14
 * Description: ${DESCRIPTION}
 */
public class Person implements SingService,DanceService,SleepService{

    @Override
    public void dance() {
        System.out.println("我会唱歌！");
    }

    @Override
    public void sing() {
        int aa = SingService.NUM;
        System.out.println("我会跳舞！");
    }

    @Override
    public void sleep() {
        System.out.println("睡觉！");
    }
}
