package com.yuan.tool;

/**
 * FileName: StudentInit
 * Author:   yhl
 * Date:     2019/11/24 15:19
 * Description: ${DESCRIPTION}
 */
public class StudentInit {
    private String name;
    private int age;
    private Book book;
    private void study(){
        System.out.println("学生在学习"+book.bookName);
    }

    public static void main1(String[] args) {
        StudentInit studentInit = new StudentInit();
        studentInit.age=1;
        studentInit.name="yyy";
        Book book = new Book();
        book.bookName="语文";
        studentInit.book=book;
        studentInit.study();
        studentInit.equals(book);
        Integer a = 1;
        Integer b = 2;
        a.equals(b);
    }
}
class Book{
    String bookName;
}



















class Animal{
    public void say(){
        System.out.println("动物叫...");
    }
}

class Dog extends  Animal{
    @Override
    public void say() {
        System.out.println("汪汪汪...");
    }
    public void kanmen(){
        System.out.println("我可以看门。。。");
    }

    public static void main(String[] args) {
        Animal a = new Animal();
        a.say();
        Animal aa = new Dog();
        aa.say();

        Dog bb = (Dog)aa;
        bb.kanmen();

        Dog b = (Dog)a;
        b.kanmen();
    }
}

