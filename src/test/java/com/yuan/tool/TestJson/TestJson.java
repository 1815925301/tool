package com.yuan.tool.TestJson;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.yuan.utils.JsonUtil;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;

/**
 * FileName: TestJson
 * Author:   yhl
 * Date:     2019/11/30 13:58
 * Description: ${DESCRIPTION}
 */
public class TestJson {

    @Test
    public void test1() throws IOException {
        CommonDto commonDto = new CommonDto();
        commonDto.setCode(1);
        Person p = new Person();
        p.setAge("11");
        p.setName("222");
        commonDto.setData(p);
        String comStr = JsonUtil.toJson(commonDto);
        System.out.println("comStr:"+comStr);
//        CommonDto commonDto1 = JsonUtil.fromJson(comStr, CommonDto.class);
        CommonDto commonDto1 = JsonUtil.fromJson(comStr, new TypeReference<CommonDto>(){});
        CommonDto commonDto11 = JsonUtil.fromJsonByGoogle(comStr, new TypeToken<CommonDto>(){});

        if(commonDto11.getCode()==1){
            Person person = (Person) commonDto1.getData();
            System.out.println(person.getAge());
        }
    }

    @Test
    public void test2() throws IOException {
        CommonDto commonDto = new CommonDto();
        commonDto.setCode(1);
        Person p = new Person();
        p.setAge("112");
        p.setName("2222");
        commonDto.setData(p);
        String comStr = JsonUtil.toJson(commonDto);
        System.out.println("comStr:"+comStr);
        Type listType = new TypeToken<CommonDto>(){}.getType();
        Gson gson = new Gson();
        CommonDto commonDto1 = gson.fromJson(comStr,listType);
        /*if(commonDto1.getCode()==1){
            LinkedTreeMap<String,String> tm = (LinkedTreeMap) commonDto1.getData();
            for(String key :tm.keySet()){
                System.out.println(key);
                System.out.println(tm.get(key));
            }
        }*/
    }

    @Test
    public void test3(){
        Gson gson = new Gson();
        Person p = new Person();
        p.setName("11");
        p.setAge("112");
        String s = gson.toJson(p);
        System.out.println(s);
        Person person = gson.fromJson(s, Person.class);
        System.out.println(p.getAge());
    }

}
class CommonDto{
    private int code;
    private Person data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Person getData() {
        return data;
    }

    public void setData(Person data) {
        this.data = data;
    }

    class pp{

    }

}
class Person{
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
