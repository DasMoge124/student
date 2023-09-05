---
toc: true
comments: true
title: Adventure Capitalist!
layout: tangibles
description: Its my pair showcase project 
tags: [javascript]
courses: { csse: {week: 0}, csp: {week: 0, categories: [4.A]}, csa: {week: 3} }
---
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: green;
    }
    .container {
        text-align: center;
        margin-top: 50px;
    }
    .money-container {
        margin: 20px 0;
    }
    .business {
        margin: 10px;
    }
</style>
<html lang="en">
<div class="timer-container">
    <p>Time Elapsed: <span id="timer">0</span> seconds</p>
</div>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Adventure Capitalist Clicker Game</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Adventure Capitalist Clicker</h1>
        <div class="money-container">
            <p>Money: <span id="money">0</span></p>
            <p>Highest Score: <span id="highestScore">0</span></p>
            <button id="click-button">Click!</button>
        </div>
        <div class="businesses">
            <button id="business1" class="business">Business 1 ($10)</button>
            <button id="business2" class="business">Business 2 ($50)</button>
            <button id="business3" class="business">Business 3 ($100)</button>
        </div>
    </div>
    <script src="script.js"></script>
</body>
</html>
<script>
// Helper function to set a cookie with a given name and value
function setCookie(cname, cvalue, exdays) {
  const d = new Date();
  d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
  let expires = "expires="+d.toUTCString();
  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}
// Helper function to get the value of a cookie by name
function getCookie(name) {
    const cookieName = `${name}=`;
    const cookies = document.cookie.split(';');
    for (let i = 0; i < cookies.length; i++) {
        let cookie = cookies[i].trim();
        if (cookie.indexOf(cookieName) === 0) {
            return cookie.substring(cookieName.length, cookie.length);
        }
    }
    return null;
}
let money = 0;
let business1Count = 0;
let business2Count = 0;
let business3Count = 0;
let startTime = null;
let endTime = null;
let isGamePaused = false;
let highestScore = parseInt(getCookie("highestScore"));
const moneyDisplay = document.getElementById("money");
const clickButton = document.getElementById("click-button");
const business1Button = document.getElementById("business1");
const business2Button = document.getElementById("business2");
const business3Button = document.getElementById("business3");
const timerDisplay = document.getElementById("timer");
const scoreDisplay = document.getElementById("score");
clickButton.addEventListener("click", () => {
    if (!isGamePaused) {
        money += 1;
        updateMoneyDisplay();
        startTimer();
    }
});
business1Button.addEventListener("click", () => {
    if (money >= 10) {
        money -= 10;
        business1Count += 1;
        updateMoneyDisplay();
    }
});
business2Button.addEventListener("click", () => {
    if (money >= 50) {
        money -= 50;
        business2Count += 1;
        updateMoneyDisplay();
    }
});
business3Button.addEventListener("click", () => {
    if (money >= 100) {
        money -= 100;
        business3Count += 1;
        updateMoneyDisplay();
    }
});
function updateMoneyDisplay() {
    moneyDisplay.textContent = money;
    business1Button.textContent = `Business 1 ($10) - ${business1Count}`;
    business2Button.textContent = `Business 2 ($50) - ${business2Count}`;
    business3Button.textContent = `Business 3 ($100) - ${business3Count}`;
}
function startTimer() {
    if (!startTime) {
        startTime = Date.now();
        endTime = startTime + 10000; // 3 minutes
        setInterval(updateTimer, 1000);
    }
}
function updateTimer() {
    if (startTime && !isGamePaused) {
        const currentTime = Date.now();
        const remainingTimeInSeconds = Math.max(0, Math.floor((endTime - currentTime) / 1000));
        timerDisplay.textContent = remainingTimeInSeconds;
        if (remainingTimeInSeconds <= 0) {
            gameOver();
        }
    }
}
function gameOver() {
    isGamePaused = true;
    const elapsedTimeInSeconds = Math.floor((endTime - startTime) / 1000);
    scoreDisplay.textContent = elapsedTimeInSeconds;
    // Update the highest score if the current score is higher
    if (elapsedTimeInSeconds > highestScore) {
        highestScore = money;
        setCookie("highestScore", money, 365);
        alert("Your highest score is: " + money);
    }
}
// Add an interval for passive income from businesses
setInterval(() => {
    if (!isGamePaused) {
        money += business1Count * 1 + business2Count * 5 + business3Count * 10;
        updateMoneyDisplay();
    }
}, 1000);
</script>