---
title: Individual Review
toc: True
description: Tri 1 review
courses: {'csse': {'week': 5}, 'csp': {'week': 2, 'categories': ['3.A', '5.B']}, 'csa': {'week': 9}}
categories: ['C3.0', 'C3.1', 'C4.1']
type: hacks
---

## Backend
- Had to make a new Backend repository after our first one was broken. FINALLY WORKED!
- First time ever trying out backend. It was painful to work on it

Key commits:
Weather API Controller
```java
package com.nighthawk.spring_portfolio.mvc.weather;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/weather")
public class WeatherAPIController {

    @GetMapping("/current")
    public ResponseEntity<WeatherData> getCurrentWeather() {
        try {
            // Replace with the actual latitude, longitude, and OpenWeatherMap API key
            String lat = "32.715736";
            String lon = "-117.161087";
            String apiKey = "777d2b06a33946bf47eba273e42a3b7e";

            String apiUrl = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey + "&units=metric";
            RestTemplate restTemplate = new RestTemplate();
            WeatherData weatherData = restTemplate.getForObject(apiUrl, WeatherData.class);

            return new ResponseEntity<>(weatherData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
```
Weather Data
```java
package com.nighthawk.spring_portfolio.mvc.weather;

import java.util.List;

/**
 * 
 */

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherData {
    private String name; // Location name
    private Main main; // Weather details
    private List<WeatherDescription> weather; // Weather descriptions

    
    // Getters and setters for the above fields
}
class Main {
    private double temp; // Temperature

    // Getter and setter for the temperature field
}

class WeatherDescription {
    @JsonProperty("description")
    private String description; // Description

    // Getter and setter for the description field
}
```

## Frontend
<p>
  <img src="{{ site.baseurl }}/images/analysis.png" width=250px/>
</p>
<p>
  <img src="{{ site.baseurl }}/images/Schedule.png" width=250px/>
</p>
<p class="center1">
  <img src="{{ site.baseurl }}/images/Planner.png" width=250px/>
</p>

Some of my HTML Code:
```html
    <div style="display: flex; flex-direction: column; width: 100%; justify-content: center; align-items: center;">
        <h1 id="typewriter"></h1>
    </div>
    <div id="datetime">
        <div id="date"></div>
        <div id="time"></div>
    </div>
     <h2 style="color:white;">Enter Your School Schedule</h2>
    <div id="inputSchedule">
        <label for="classPeriod1">Period 1:</label>
        <input type="text" id="classPeriod1" style="color: blue;"><br>
        <label for="classPeriod2">Period 2:</label>
        <input type="text" id="classPeriod2" style="color: blue;"><br>
        <label for="classPeriod3">Period 3:</label>
        <input type="text" id="classPeriod3" style="color: blue;"><br>
        <label for="classPeriod4">Period 4:</label>
        <input type="text" id="classPeriod4" style="color: blue;"><br>
        <label for="classPeriod5">Period 5:</label>
        <input type="text" id="classPeriod5" style="color: blue;"><br>
        <button onclick="updateSchedule()">Update Schedule</button>
    </div>
    <div id="scheduleResults" style="color: blue;"></div>
```
Some Javascript:
```javascript
            const classPeriod2 = document.getElementById('classPeriod2').value;
            const classPeriod3 = document.getElementById('classPeriod3').value;
            const classPeriod4 = document.getElementById('classPeriod4').value;
            const classPeriod5 = document.getElementById('classPeriod5').value;
            // Create an object to store the schedule data
            const scheduleData = {
                classPeriod1,
                classPeriod2,
                classPeriod3,
                classPeriod4,
                classPeriod5
            };
```
<img src="{{ site.baseurl }}/images/Screenshot 2023-11-06 005404.png" width=250px/>
<img src="{{ site.baseurl }}/images/Screenshot 2023-11-06 005424.png" width=250px/>

## Analysis of commits
<p><img src="{{ site.baseurl }}/images/analysis.png" width=250px/></p>
<p><img src="{{ site.baseurl }}/images/Analysis2.png" width=250px/></p>

## Reflection:
- If the database doesn't work, make a new one and don't try to fix the old one as it makes matters worse.
- When making a schedule be cautious
Challenges:
- In the backend, there were so many errors my team and I cannot fix. I had no idea what to do and I had to ask for help from multiple people from days. One day, I decided to make a new repository and then the backend actually worked
- Frontend: it was mainly trying to save data, but after getting the backend working, we were able to save data within the frontend
- There were some times when the schedule doesn't save properly, and I had to spend a long time to fix it. But after some configuration, we were able to get it fixed.