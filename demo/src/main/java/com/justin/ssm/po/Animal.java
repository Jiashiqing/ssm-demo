package com.justin.ssm.po;

public class Animal {
   
    private String name;  
       
    private int age;  
       
    public String speak(){  
    return "我的名字是："+this.name+"，年龄是："+this.age+"!\n";  
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}