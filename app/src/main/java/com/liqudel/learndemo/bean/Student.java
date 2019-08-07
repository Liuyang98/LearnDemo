package com.liqudel.learndemo.bean;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;

        courses = new ArrayList<>();
        courses.add(new Course(this.name + "：科目一"));
        courses.add(new Course(this.name + "：科目二"));
        courses.add(new Course(this.name + "：科目三"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}

