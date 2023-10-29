---
toc: true
comments: true
layout: post
title: All Hacks - Check the very bottom for the links to all of the hacks
---

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="weather-container">
        <h1>Current Weather</h1>
        <p id="location"></p>
        <p id="temperature"></p>
        <p id="description"></p>
    </div>    <script src="script.js"></script>
</body>
</html>
<script>
// script.js
document.addEventListener("DOMContentLoaded", () => {
    if ("geolocation" in navigator) {
        navigator.geolocation.getCurrentPosition(function (position) {
            const lat = 33.01479454987898;//position.coords.latitude;
            const lon = -117.12140255005595;//position.coords.longitude;
            // Replace 'YOUR_API_KEY' with your OpenWeatherMap API key
            const apiKey = 'e04a331282msh3e1b2def5842403p13c761jsnf3a321372e50';
            const apiUrl = "https://api.weather.gov/points/" + latitude + "," + longitude;
            fetch(apiUrl)
                .then((response) => response.json())
                .then((data) => {
                    const location = data.name;
                    const temperature = data.main.temp;
                    const description = data.weather[0].description;
                    document.getElementById("location").textContent = `Location: ${location}`;
                    document.getElementById("temperature").textContent = `Temperature: ${temperature}°C`;
                    document.getElementById("description").textContent = `Description: ${description}`;
                })
                .catch((error) => {
                    console.error("Error fetching weather data: ", error);
                });
        });
    } else {
        console.error("Geolocation is not available in this browser.");
    }
});
</script>