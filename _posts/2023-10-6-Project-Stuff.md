---
title: Project
toc: True
description: Hacks
courses: {'csse': {'week': 5}, 'csp': {'week': 2, 'categories': ['3.A', '5.B']}, 'csa': {'week': 7}}
categories: ['C3.0', 'C3.1', 'C4.1']
type: hacks
---
## This is what our draft is like.
```java
import javax.persistence.*;
import java.util.Date;
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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