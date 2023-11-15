---
title: Project Notes
toc: True
description: Hacks
courses: {'csse': {'week': 5}, 'csp': {'week': 2, 'categories': ['3.A', '5.B']}, 'csa': {'week': 9}}
categories: ['C3.0', 'C3.1', 'C4.1']
type: hacks
---
## Notes
- Java Code for API
- Javascript timer --> Bell schedule and daily planner as well
- sprite sheet for clothes customization and make a human and no naked stuff; if naked, blur this stuff out orlando
- Need to make a JSON for class list
- Update scrumboard
- Below is some java code for the database
- I have also fixed the javascript code so that the period classes would all work perfectly fine.
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Display Local Time</title>
</head>
<body>
    <div id="time"></div>
    <script>
        // Get the current date and time
            const now = new Date();
        // Get the hours, minutes, and seconds
        const hours = now.getHours();
        const minutes = now.getMinutes();
        const seconds = now.getSeconds();
        // Display the time in a 12-hour format with AM/PM
        const ampm = hours >= 12 ? 'PM' : 'AM';
        const formattedHours = hours % 12 || 12; // Convert 0 to 12 for 12 AM
        const timeString = `${formattedHours}:${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')} ${ampm}`;
        // Display the time on the webpage
        const timeElement = document.getElementById('time'); // Change 'time' to the ID of your HTML element
        timeElement.textContent = timeString;
        function updateClock() {
            // Get the current date and time
            const now = new Date();
            // Get the hours, minutes, and seconds
            const hours = now.getHours();
            const minutes = now.getMinutes();
            const seconds = now.getSeconds();
            // Display the time in a 12-hour format with AM/PM
            const ampm = hours >= 12 ? 'PM' : 'AM';
            const formattedHours = hours % 12 || 12; // Convert 0 to 12 for 12 AM
            const timeString = `${formattedHours}:${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')} ${ampm}`;
            // Display the time on the webpage
            const timeElement = document.getElementById('time'); // Change 'time' to the ID of your HTML element
            timeElement.textContent = timeString;
        }
        // Call updateClock initially to set the time
        updateClock();
        // Update the clock every second
        setInterval(updateClock, 1000);
    </script>
</body>
</html>

```java
import javax.persistence.*;
import java.util.Date;
@Entity
public class Event {
c    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Date date;
    private String location;
    // getters and setters
}
@Entity
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private double temperature;
    private String weatherCondition;
    // getters and setters
}
import org.springframework.data.jpa.repository.JpaRepository;
public interface EventRepository extends JpaRepository<Event, Long> {
    // Define custom queries if needed
}
public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
    WeatherData findByCity(String city);
}
import org.springframework.data.jpa.repository.JpaRepository;
public interface EventRepository extends JpaRepository<Event, Long> {
    // Define custom queries if needed
}
public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
    WeatherData findByCity(String city);
}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class WeatherService {
    @Autowired
    private WeatherDataRepository weatherDataRepository;
    private final String API_KEY = "YOUR_API_KEY";
    private final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    public void fetchAndUpdateWeatherData(String city) {
        String apiUrl = BASE_URL + "?q=" + city + "&appid=" + API_KEY;
        RestTemplate restTemplate = new RestTemplate();
        WeatherData weatherData = restTemplate.getForObject(apiUrl, WeatherData.class);
        if (weatherData != null) {
            weatherDataRepository.save(weatherData);
        }
    }
}
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
@Service
public class EventNotificationService {
    @Scheduled(fixedRate = 60000) // Run every minute
    public void checkEventsAndNotify() {
        // Implement logic to check for upcoming events
        // Send notifications as needed (e.g., email, SMS, etc.)
    }
}
```