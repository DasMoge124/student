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
        <h3 id="location">Location: </h3>
        <p id="temperature">Temperature: </p>
        <p id="description"> Description: </p>
    </div>    <script src="script.js"></script>
</body>
</html>
<script>
// script.js
const place = document.getElementById("location");
document.addEventListener("DOMContentLoaded", () => {
    if ("geolocation" in navigator) {
        navigator.geolocation.getCurrentPosition(function (position) {
            const lat = position.coords.latitude;
            const lon = position.coords.longitude;
            const apiKey = '777d2b06a33946bf47eba273e42a3b7e';
            const apiUrl = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${apiKey}&units=metric`;
            fetch(apiUrl)
                .then((response) => response.json())
                .then((data) => {
                    const location = data.name;
                    const temperature = data.main.temp;
                    const description = data.weather[0].description;
                    place.textContent = `Location: ${location}`;
                    document.getElementById("temperature").textContent = `Temperature: ${temperature}°C`;
                    document.getElementById("description").textContent = `Description: ${description}`;
                })
                .catch((error) => {
                    console.error("Error fetching weather data: ", error);
                    document.getElementById("description").textContent = "Cant get no info";
                });
        });
    } else {
        console.error("Geolocation is not available in this browser.");
    }
});
</script>