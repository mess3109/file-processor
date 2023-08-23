package com.example.fileprocessor.models;

import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;

public class Student implements Serializable {


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @CsvBindByName(column="Name")
    String name;

    @CsvBindByName(column="Age")
    int age;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public String toString() {
        return String.format("Student(name=%s, age=%s)", name, age);
    }
}
