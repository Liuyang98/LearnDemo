package com.liqudel.learndemo.bean;

public class ValueSendBean {
    private String name;
    private int age;

    public ValueSendBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name.toString() + " : " + age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
