package com.test.domain;

import javax.persistence.*;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer id;

    private String name;

    private Integer age;

    private Double score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Test{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", score=" + score + '}';
    }
}


