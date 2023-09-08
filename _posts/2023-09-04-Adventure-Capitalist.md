---
toc: true
comments: true
title: The Adventure Capitalist
layout: hacks
description: A pretty advanced use of JavaScript building classic snake game using menu controls, key events, snake simulation and timers.  
courses: { csse: {week: 1}, csp: {week: 1, categories: [4.A]}, csa: {week: 3} }
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
        margin: 20px;
    }
    .business {
        margin: 10px;
    }
</style>
<html lang="en">
<div class="timer-container">
    <h3>Time Left: <span id="timer">0</span> seconds</h3>
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
        <h2>Make as much money as possible within 3 minutes!</h2>
        <div class="money-container">
            <p>Money: $<span id="money">0</span></p>
            <button id="click-button">Click!</button>
        </div>
        <div class="businesses">
            <button id="business1" class="business">Business 1 ($10)</button>
            <button id="business2" class="business">Business 2 ($50)</button>
            <button id="business3" class="business">Business 3 ($100)</button>
        </div>
            <!-- Business search input -->
    <label for="search-input">Search for businesses:</label>
    <input type="text" id="search-input">
    <button id="search-button">Search</button>
    <!-- Display search results -->
    <div id="results">
        <h2>Search Results:</h2>
        <table id="business-table">
            <thead>
                <tr>
                    <th>Company Name</th>
                    <th>Cost</th>
                    <th>Action</th>
                </tr>
            </thead>
        <tbody id="business-list"></tbody>
    </table>
    </div>
    <!-- Display the player's businesses -->
    <div id="player-businesses">
        <h2>Your Businesses:</h2>
        <ul id="player-business-list"></ul>
    </div>
    <div>
        <img id="image" src="{{ site.baseurl }}/images/images.jpg"/>
        </div>
        <img src="{{ site.baseurl }}/images/200w.gif"/>
    </div>
    <script src="script.js"></script>
    
</body>
</html>
<script>
// Helper function to set a cookie with a given name and value
let congrats = "Make as much money as you can";
let money = 0;
let playerBusinesses = [];
let business1Count = 0;
let business2Count = 0;
let business3Count = 0;
let startTime = null;
let endTime = null;
let isGamePaused = false;
let highestScore = parseInt(getCookie("highestScore")) || 0;
const moneyDisplay = document.getElementById("money");
const clickButton = document.getElementById("click-button");
const business1Button = document.getElementById("business1");
const business2Button = document.getElementById("business2");
const business3Button = document.getElementById("business3");
const timerDisplay = document.getElementById("timer");
const scoreDisplay = document.getElementById("score");
const businessDisplay = document.getElementById("player-business-list");
const searchInput = document.getElementById("search-input");
    const searchButton = document.getElementById("search-button");
    const businessList = document.getElementById("business-list");
    const businesses = [
        { name: "ABC Corporation", networth: 5000 },
        { name: "XYZ Industries", networth: 3000 },
        { name: "Alpha Inc.", networth: 1000 },
        { name: "Beta Corp.", networth: 8000 },
        { name: "Gamma Corp.", networth: 7000 },
        { name: "Delta Enterprises", networth: 6000 },
        { name: "Omega Ltd.", networth: 2000 },
        { name: "Sigma Co.", networth: 4000 },
        { name: "Zeta Holdings", networth: 9000 },
        { name: "Epsilon Ventures", networth: 2500 },
        { name: "Microsoft", networth: 10000},
        { name: "Apple", networth: 150000},
        { name: "Google", networth: 900000},
        { name: "Bob", networth: 99999999},
    ];
searchButton.addEventListener("click", function () {
    const searchTerm = searchInput.value.toLowerCase();
    // Clear previous results
    businessList.innerHTML = "";
    // Filter and sort businesses based on the search term
    const filteredBusinesses = businesses.filter(business => business.name.toLowerCase().includes(searchTerm));
    const sortedBusinesses = filteredBusinesses.sort((a, b) => b.networth - a.networth);
    // Display the top 10 businesses
    const top10Businesses = sortedBusinesses.slice(0, 10);
    top10Businesses.forEach(business => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${business.name}</td>
            <td>$${business.networth}</td>
            <td><button class="purchase-button" data-business-name="${business.name}" data-cost="${business.networth}">Purchase</button></td>
        `;
        businessList.appendChild(row);
    });
    // Add event listeners to the "Purchase" buttons
    const purchaseButtons = document.querySelectorAll(".purchase-button");
    purchaseButtons.forEach(button => {
        button.addEventListener("click", function () {
            const businessName = this.getAttribute("data-business-name");
            const cost = parseInt(this.getAttribute("data-cost"));
            purchaseBusiness(businessName, cost);
        });
    });
});
function updatePlayerBusinessesList() {
    const playerBusinessList = document.getElementById("player-business-list");
    playerBusinessList.innerHTML = ""; 
    playerBusinesses.forEach((business, index) => {
        const listItem = document.createElement("li");
        listItem.textContent = `Business ${index + 1}: ${business.name} (Revenue: $${business.revenue.toFixed(2)} per second)`;
        playerBusinessList.appendChild(listItem);
    });
}
    // Function to purchase a business
// Call the updatePlayerBusinessesList function whenever a business is purchased
function purchaseBusiness(businessName, cost) {
    if (money >= cost && !isGamePaused) {
        money -= cost;
        const revenue = cost / 10; // Each business generates 1/10 of its cost per second
        playerBusinesses.push({ name: businessName, revenue });
        updateMoneyDisplay();
        updatePlayerBusinessesList(); // Update the list when a business is purchased
    } else {
        alert("Not enough money to buy this business.");
    }
}
function setCookie(cname, cvalue, exdays) {
  const d = new Date();
  d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
  let expires = "expires="+d.toUTCString();
  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}
function getCookie(cname) {
  let name = cname + "=";
  let ca = document.cookie.split(';');
  for(let i = 0; i < ca.length; i++) {
    let c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}
function checkCookie() {
  let user = getCookie("username");
  if (user != "") {
    alert("Welcome back to Adventure Capitalist " + user);
  } else {
    user = prompt("Please enter your name:", "");
    if (user != "" && user != null) {
      setCookie("username", user, 365);
    }
  }
}
checkCookie();
clickButton.addEventListener("click", () => {
    if (!isGamePaused) {
        money += 1;
        updateMoneyDisplay();
        startTimer();
    }
});
business1Button.addEventListener("click", () => {
    if (money >= 10 && !isGamePaused) {
        money -= 10;
        business1Count += 1;
        updateMoneyDisplay();
    }
});
business2Button.addEventListener("click", () => {
    if (money >= 50 && !isGamePaused) {
        money -= 50;
        business2Count += 1;
        updateMoneyDisplay();
    }
});
business3Button.addEventListener("click", () => {
    if (money >= 100 && !isGamePaused) {
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
        endTime = startTime + 180000; // 3 minutes
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
    timerDisplay.textContent = "Time is up man! You have zero ";
}
// Add an interval for passive income from businesses
setInterval(() => {
    if (!isGamePaused) {
        money += business1Count * 1 + business2Count * 5 + business3Count * 10;
        updateMoneyDisplay();
    }
}, 1000);

</script>