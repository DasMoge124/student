---
title: Project Notes
toc: True
description: Tri 1 review
courses: {'csse': {'week': 5}, 'csp': {'week': 2, 'categories': ['3.A', '5.B']}, 'csa': {'week': 9}}
categories: ['C3.0', 'C3.1', 'C4.1']
type: hacks
---
# 5.1 Anatomy of a Class

## KEY LEARNING OBJECTIVES:

1. Designate access and visibility constraints to classes, data, constructors, and methods.

2. Designate private visibility of instance variables to encapsulate the attributes of an object.

## What is a class?

A **class** is a template for creating objects in Java. 

## Private vs Public Designation

**Private**: A private access modifier means that the instance variables, constructors, and methods cannot be accessed outside of the class.

**Public**: This allows access from classes outside the original class of declaration.

## Data Encapsulation

This is one of the key components of object oriented programming. 

It ensures data protection by controlling which parts of a class are accessible to other classes.

In the following example, we look at encapsulation and demonstrate how to create a Student class with private instance variables for name and age, public methods for accessing and modifying these variables, and validation checks to ensure data integrity. 

```java
public class Student {
    // 1. Private variables to store student's name and age
    private String name; // Stores the student's name
    private int age;     // Stores the student's age

    // 2. Public Class: Student

    // 3. Constructor Methods
    // Constructor to create a Student object with a name and age
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        // Let's create a new Student!
        Student student = new Student("Vishnu", 17);

        // Displaying the student's information
        System.out.println("Meet our star student:");
        System.out.println("Name: " + student.name); // Accessing the name directly
        System.out.println("Age: " + student.age);   // Accessing the age directly
    }
}

Student.main(null);
```

Meet our star student:
Name: Vishnu
Age: 17

# 5.2 Constructors
## KEY LEARNING OBJECTIVES
Define instance variables for the attributes to be initialized through the constructors of a class.
Constructors are used to set the initial state of an object.
**Mutable Objects**: These are objects whose internal state can be changed after its creation. Lists are mutable objects, as are arrays.

**Constructor Parameters**: These are values passed to a class's constructor when creating an instance. This initializes the new object's state.

**Instance Variables**: These are object attributes that store the objects state. They are declared within the class and can be accessed by the object's methods.

**Alias**: Two variables point to the same object.

A good example of a Java alias:
```java
public class AliasExample {
    public static void main(String[] args) {
        // Create an array and two references (aliases) to it
        int[] array = new int[]{1, 2, 3};
        int[] alias1 = array;
        int[] alias2 = array;

        // Modify the array through one of the aliases
        alias1[0] = 100;

        // Access the modified array through the other alias
        System.out.println("Value at index 0 through alias2: " + alias2[0]);
    }
}

AliasExample.main(null);
```
Value at index 0 through alias2: 100
In the below example, we explore encapsulation and demonstrate how to create a Person class to represent individuals with private attributes for name, age, and hobbies. The code showcases how to initialize and manipulate a Person object's state, including adding hobbies to the person's list, while ensuring the original data remains unchanged.

## My Hacks:
- [Hacks 1](https://github.com/DasMoge124/student/blob/main/_notebooks/2023-10-14-unit5start.ipynb)
- [Hacks 2](https://github.com/DasMoge124/student/blob/main/_notebooks/2023-10-14-unit5secondpart.ipynb)
- [Hacks 3](https://github.com/DasMoge124/student/blob/main/_notebooks/2023-10-14-unit5lastpart.ipynb)