---
toc: true
comments: true
layout: post
title: Weather API
---
## Tested Weather API
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="weather-container">
        <h1>Current Weather</h1>
        <h3 id="location">Location: Waiting for geolocation...</h3>
        <p id="temperature">Temperature: </p>
        <p id="description">Description: </p>
    </div>
    <script src="script.js"></script>
</body>
</html>
<script>
// script.js
const locationElement = document.getElementById("location");
const temperatureElement = document.getElementById("temperature");
const descriptionElement = document.getElementById("description");
document.addEventListener("DOMContentLoaded", () => {
    if ("geolocation" in navigator) {
        navigator.geolocation.getCurrentPosition(
            function (position) {
                const lat = 32.715736;
                const lon = -117.1611;
                const apiKey = '777d2b06a33946bf47eba273e42a3b7e';
                const apiUrl = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${apiKey}&units=metric`;
                fetch(apiUrl)
                    .then((response) => {
                        if (!response.ok) {
                            throw new Error("Network response was not ok");
                        }
                        return response.json();
                    })
                    .then((data) => {
                        const location = data.name;
                        const temperature = (data.main.temp*9/5)+32;
                        const description = data.weather[0].description;
                        locationElement.textContent = `Location: ${location}`;
                        temperatureElement.textContent = `Temperature: ${temperature}°F`;
                        descriptionElement.textContent = `Description: ${description}`;
                    })
                    .catch((error) => {
                        console.error("Error fetching weather data: ", error);
                        locationElement.textContent = "Unable to fetch location data";
                        temperatureElement.textContent = "Unable to fetch temperature data";
                        descriptionElement.textContent = "Unable to fetch description data";
                    });
            },
            function (error) {
                console.error("Error getting geolocation: " + error.message);
                locationElement.textContent = "Geolocation error: " + error.message;
            }
        );
    } else {
        console.error("Geolocation is not available in this browser.");
        locationElement.textContent = "Geolocation not available";
    }
});
</script>
