package com.yuan.tool.interfaceTest;

import com.yuan.tool.AppTest;

/**
 * Description: 接口实现多继承和子类实现多个接口，效果是一样的，都要重写接口所有的方法，
 * 类的继承，如果不是抽象方法的时候，可以不用重写，但是接口的继承里边都是抽象方法，所以都需要重写！
 * 里边各自定义的变量，因为是静态常量，所以可以直接调用；名称相同的情况下，接口.NUM获取
 */
public interface SingService extends DanceService,SleepService {
     int NUM =1;
     void sing();
}
