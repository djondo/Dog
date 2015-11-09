package com.company;

/**
 * Created by rudi on 11/9/2015.
 */
public class Dog {
    private String name;
    private boolean isPuppy;
    private int age;

    public Dog(String name, boolean isPuppy, int age) {
        this.name = name;
        this.age = age;
        this.isPuppy = isPuppy;
    }

    // The JList will use this to create a string to display in the GUI
    public String toString() {
        if (isPuppy) {
            return ("Puppy's name is" + name + ", puppy's age is " + age);
        } else {
            return ("Dog's name is" + name + ", dog's age is " + age);
        }
    }
}
