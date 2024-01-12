---
title: Team Review
toc: True
description: Tri 1 review
courses: {'csse': {'week': 5}, 'csp': {'week': 2, 'categories': ['3.A', '5.B']}, 'csa': {'week': 18}}
categories: ['C3.0', 'C3.1', 'C4.1']
type: tangibles
---
![Alt text](image-3.png)
This project will involve trying to help find jobs.

![Alt text](image-4.png)
The above is a diagram demonstrating how everything works
The project itself issue: [Link](https://github.com/RIK-CSA/RIK-CSA-backend/issues/1)

Sample Java Complete Search Code:
```java
private static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i; // Element found, return its index
            }
        }
        return -1; // Element not found in the array
    }
```