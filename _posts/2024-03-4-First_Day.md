---
title: Individual Seed
toc: True
description: Hacks
courses: {'csse': {'week': 5}, 'csp': {'week': 2, 'categories': ['3.A', '5.B']}, 'csa': {'week': 7}}
categories: ['C3.0', 'C3.1', 'C4.1']
type: hacks
---
## My Contributions to Project

For the backend, I essentially made some KNN features for searching for most relevant student. Raymond technically suggested this to me so I implemented somehting similar to that:

*Student Controller*
```java
package com.nighthawk.spring_portfolio.mvc.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "https://rik-csa.github.io/")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    public StudentController() {
        // Initialize your student list
        students.add(new Student("John Kim", Arrays.asList("Math", "Physics"), "Chicago", true));
        // Add more sample students here...
    }

    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody Student newStudent) {
        students.add(newStudent);
        return ResponseEntity.ok("Student added successfully");
    }

    @PostMapping("/findMostRelevant")
    public ResponseEntity<Student> findMostRelevantStudent(@RequestBody Student newStudent,
            @RequestParam int k) {
        Student mostRelevantStudent = KNNStudentSelection.findMostRelevantStudent(students, newStudent, k);
        return ResponseEntity.ok(mostRelevantStudent);
    }

    @GetMapping("/allStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(students);
    }
}

// Student Class
package com.nighthawk.spring_portfolio.mvc.search;

import java.util.List;

public class Student {
    private String name;
    private List<String> subjectsKnown;
    private String preferredLocation;
    private boolean internshipPreferred;

    // Constructors (including a no-arg constructor)

    public Student() {
    }

    public Student(String name, List<String> subjectsKnown, String preferredLocation,
            boolean internshipPreferred) {
        this.name = name;
        this.subjectsKnown = subjectsKnown;
        this.preferredLocation = preferredLocation;
        this.internshipPreferred = internshipPreferred;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSubjectsKnown() {
        return subjectsKnown;
    }

    public void setSubjectsKnown(List<String> subjectsKnown) {
        this.subjectsKnown = subjectsKnown;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    public boolean isInternshipPreferred() {
        return internshipPreferred;
    }

    public void setInternshipPreferred(boolean internshipPreferred) {
        this.internshipPreferred = internshipPreferred;
    }
}

// KNN Finder
package com.nighthawk.spring_portfolio.mvc.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KNNStudentSelection {

    // KNN algorithm for student selection
    public static Student findMostRelevantStudent(List<Student> students, Student newStudent, int k) {
        Map<Double, Student> distanceMap = new HashMap<>();

        // Calculate Euclidean distance for each student
        for (Student student : students) {
            double distance = calculateDistance(student, newStudent);
            distanceMap.put(distance, student);
        }

        // Sort distances and get the top k neighbors
        List<Double> distances = new ArrayList<>(distanceMap.keySet());
        Collections.sort(distances);

        // Return the most relevant student
        return distanceMap.get(distances.get(0));
    }

    private static double calculateDistance(Student student1, Student student2) {
        // Simple distance calculation based on preferences
        double subjectDistance = calculateSubjectDistance(student1.getSubjectsKnown(), student2.getSubjectsKnown());
        double locationDistance = student1.getPreferredLocation().equals(student2.getPreferredLocation()) ? 0 : 1;

        // Euclidean distance
        return Math.sqrt(Math.pow(subjectDistance, 2) + Math.pow(locationDistance, 2));
    }

    private static double calculateSubjectDistance(List<String> subjects1, List<String> subjects2) {
        // Jaccard similarity for subject distance
        List<String> union = new ArrayList<>(subjects1);
        union.addAll(subjects2);

        List<String> intersection = new ArrayList<>(subjects1);
        intersection.retainAll(subjects2);

        return 1 - ((double) intersection.size() / union.size());
    }
}

```

#### Frontend:
```html
<style>
body {
    font-family: Arial, sans-serif;
    margin: 20px;
}

h1, h2 {
    margin-bottom: 10px;
}

form {
    margin-bottom: 20px;
}

label {
    display: inline-block;
    width: 150px;
    margin-bottom: 5px;
}

input[type="text"], input[type="number"] {
    width: 300px;
    padding: 5px;
}

button {
    padding: 8px 15px;
    cursor: pointer;
}
</style>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Selection</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Student Selection</h1>
    <h2>Add New Student</h2>
    <form id="addStudentForm">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        <label for="subjects">Subjects Known (comma-separated):</label>
        <input type="text" id="subjects" name="subjects" required><br><br>
        <label for="location">Preferred Location:</label>
        <input type="text" id="location" name="location" required><br><br>
        <label for="internship">Internship Preferred:</label>
        <input type="checkbox" id="internship" name="internship"><br><br>
        <button type="submit">Add Student</button>
    </form>
    <h2>Find Most Relevant Student</h2>
    <form id="findStudentForm">
        <label for="newStudent">New Student Information:</label><br>
        <input type="text" id="newStudent" name="newStudent" placeholder="Enter name, subjects, location, internship preference"><br><br>
        <label for="k">Number of Neighbors (k):</label>
        <input type="number" id="k" name="k" min="1" value="1"><br><br>
        <button type="submit">Find Most Relevant Student</button>
    </form>
    <div id="result"></div>
</body>
</html>
<script>
    document.getElementById('addStudentForm').addEventListener('submit', addStudent);
document.getElementById('findStudentForm').addEventListener('submit', findMostRelevantStudent);
function addStudent(event) {
    event.preventDefault();
    const formData = new FormData(event.target);
    const studentData = {
        name: formData.get('name'),
        subjectsKnown: formData.get('subjects').split(',').map(subject => subject.trim()),
        preferredLocation: formData.get('location'),
        internshipPreferred: formData.get('internship') === 'on'
    };
    fetch('http://localhost:4100/api/student/add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(studentData),
    })
    .then(response => response.text())
    .then(message => alert(message))
    .catch(error => console.error('Error:', error));
}
function findMostRelevantStudent(event) {
    event.preventDefault();
    const formData = new FormData(event.target);
    const newStudentInfo = formData.get('newStudent').split(',').map(info => info.trim());
    const newStudent = {
        name: newStudentInfo[0],
        subjectsKnown: newStudentInfo[1].split(',').map(subject => subject.trim()),
        preferredLocation: newStudentInfo[2],
        internshipPreferred: newStudentInfo[3] === 'true' || newStudentInfo[3] === '1' || newStudentInfo[3] === 'on'
    };
    const k = formData.get('k');
    fetch(`http://localhost:4100/api/student/findMostRelevant?k=${k}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newStudent),
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById('result').innerText = `Most relevant student: ${data.name}`;
    })
    .catch(error => console.error('Error:', error));
}
</script>
```

## FRQ Contributions
[FRQ 1](https://dasmoge124.github.io/student/2024/02/19/Final_FRQ_1_IPYNB_2_.html)
[FRQ 2](https://dasmoge124.github.io/student/2024/02/19/Final_FRQ_2_IPYNB_2_.html)
[FRQ 3](https://dasmoge124.github.io/student/2024/02/19/Final_FRQ_3_IPYNB_2_.html)

## Github Analysis:
[Link](https://github.com/DasMoge124)