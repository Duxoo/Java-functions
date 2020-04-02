package com.company;

//helper, just for example
public class Person {
    private String lastName;
    private String firstName;
    private int age;

    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public void displayPerson() {
        System.out.println("last firstName = " + lastName + " ; first firstName = " + firstName + " ; age = " + age);
    }

    public String getLast() {
        return this.lastName;
    }
}
