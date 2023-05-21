package com.example.demoq.model;

import org.springframework.stereotype.Component;


public class FormQuery {
    private String firstName,lastName, valueOne, valueTwo,valueThree;

    private Long id,count,index;

    public FormQuery() {
    }

    public FormQuery(String firstName, String lastName, String valueOne, String valueTwo, String valueThree, Long id, Long count, Long index) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
        this.valueThree = valueThree;
        this.id = id;
        this.count = count;
        this.index = index;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getValueOne() {
        return valueOne;
    }

    public void setValueOne(String valueOne) {
        this.valueOne = valueOne;
    }

    public String getValueTwo() {
        return valueTwo;
    }

    public void setValueTwo(String valueTwo) {
        this.valueTwo = valueTwo;
    }

    public String getValueThree() {
        return valueThree;
    }

    public void setValueThree(String valueThree) {
        this.valueThree = valueThree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "FormQuery{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", valueOne='" + valueOne + '\'' +
                ", valueTwo='" + valueTwo + '\'' +
                ", valueThree='" + valueThree + '\'' +
                ", id=" + id +
                ", count=" + count +
                ", index=" + index +
                '}';
    }
}
