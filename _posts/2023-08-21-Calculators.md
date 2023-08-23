---
toc: true
comments: true
layout: post
title: Calculator
description: This is my first Calculator :)
type: hacks
courses: { csse: {week: 1}, csp: {week: 1, categories: [4.A]}, csa: {week: 0} }
---

<!-- 
Hack 0: Right justify result
Hack 1: Test conditions on small, big, and decimal numbers, report on findings. Fix issues.
Hack 2: Add the common math operation that is missing from calculator
Hack 3: Implement 1 number operation (ie SQRT) 
-->

<!-- 
HTML implementation of the calculator. 
-->

{% include nav_home.html %}

<!-- 
    Style and Action are aligned with HRML class definitions
    style.css contains majority of style definition (number, operation, clear, and equals)
    - The div calculator-container sets 4 elements to a row
    Background is credited to Vanta JS and is implemented at bottom of this page
-->
<style>
  .calculator-output {
    /* calulator output 
      top bar shows the results of the calculator;
      result to take up the entirety of the first row;
      span defines 4 columns and 1 row
    */
    grid-column: span 4;
    grid-row: span 1;
  
    border-radius: 10px;
    padding: 0.25em;
    font-size: 20px;
    border: 5px solid black;
  
    display: flex;
    align-items: center;
  }
  .calculator-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }

  .calculator-row {
    display: flex;
    justify-content: center;
    margin: 10px 0; /* Increase margin for more spacing */
  }

  .calculator-button {
    display: flex;
    align-items: center;
    justify-content: center;
    width: 180px; /* Slightly wider buttons */
    height: 60px; /* Slightly taller buttons */
    background-color: #f2f2f2;
    border-radius: 50%;
    font-size: 18px;
    cursor: pointer;
    margin: 0 8px; /* Increased horizontal margin */
  }
</style>

<!-- Add a container for the animation -->
<div id="animation">
  <div class="calculator-container">
    <div class="calculator-output" id="output">0</div>
    <!-- Row 1 -->
    <div class="calculator-row">
      <div>|</div>
      <div class="calculator-number">1</div>
      <div>| |</div>
      <div class="calculator-number">2</div>
      <div>| |</div>
      <div class="calculator-number">3</div>
      <div>| |</div>
      <div class="calculator-operation">+</div>
      <div>| |</div>
      <div class="calculator-operation">^</div>
      <div>|</div>
    </div>
    <!-- Row 2 -->
    <div class="calculator-row">
      <div>|</div>
      <div class="calculator-number">4</div>
      <div>| |</div>
      <div class="calculator-number">5</div>
      <div>| |</div>
      <div class="calculator-number">6</div>
      <div>| |</div>
      <div class="calculator-operation">-</div>
      <div>| |</div>
      <div class="calculator-operation">Log</div>
      <div>|</div>
    </div>
    <!-- Row 3 -->
    <div class="calculator-row">
      <div>|</div>
      <div class="calculator-number">7</div>
      <div>| |</div>
      <div class="calculator-number">8</div>
      <div>| |</div>
      <div class="calculator-number">9</div>
      <div>| |</div>
      <div class="calculator-operation">*</div>
      <div>| |</div>
      <div class="calculator-operation">/</div>
      <div>|</div>
    </div>
    <!-- Row 4 -->
    <div class="calculator-row">
      <div>|</div>
      <div class="calculator-clear">A/C</div>
      <div>| |</div>
      <div class="calculator-number">0</div>
      <div>| |</div>
      <div class="calculator-number">.</div>
      <div>| |</div>
      <div class="calculator-equals">=</div>
      <div>|</div>
    </div>
  </div>
</div>

<!-- JavaScript (JS) implementation of the calculator. -->
<script>
// initialize important variables to manage calculations
var firstNumber = null;
var operator = null;
var nextReady = true;
// build objects containing key elements
const output = document.getElementById("output");
const numbers = document.querySelectorAll(".calculator-number");
const operations = document.querySelectorAll(".calculator-operation");
const clear = document.querySelectorAll(".calculator-clear");
const equals = document.querySelectorAll(".calculator-equals");

// Number buttons listener
numbers.forEach(button => {
  button.addEventListener("click", function() {
    number(button.textContent);
  });
});

// Number action
function number (value) { // function to input numbers into the calculator
    if (value != ".") {
        if (nextReady == true) { // nextReady is used to tell the computer when the user is going to input a completely new number
            output.innerHTML = value;
            if (value != "0") { // if statement to ensure that there are no multiple leading zeroes
                nextReady = false;
            }
        } else {
            output.innerHTML = output.innerHTML + value; // concatenation is used to add the numbers to the end of the input
        }
    } else { // special case for adding a decimal; can't have two decimals
        if (output.innerHTML.indexOf(".") == -1) {
            output.innerHTML = output.innerHTML + value;
            nextReady = false;
        }
    }
}

// Operation buttons listener
operations.forEach(button => {
  button.addEventListener("click", function() {
    operation(button.textContent);
  });
});

// Operator action
function operation (choice) { // function to input operations into the calculator
    if (firstNumber == null) { // once the operation is chosen, the displayed number is stored into the variable firstNumber
        firstNumber = parseInt(output.innerHTML);
        nextReady = true;
        operator = choice;
        return; // exits function
    }
    // occurs if there is already a number stored in the calculator
    firstNumber = calculate(firstNumber, parseFloat(output.innerHTML)); 
    operator = choice;
    output.innerHTML = firstNumber.toString();
    nextReady = true;
}

// Calculator
function calculate (first, second) { // function to calculate the result of the equation
    let result = 0;
    switch (operator) {
        case "+":
            result = first + second;
            break;
        case "-":
            result = first - second;
            break;
        case "*":
            result = first * second;
            break;
        case "/":
            result = first / second;
            break;
        case "^":
            result = first ** second;
            break;
        case "Log":
            result = Math.log(first);
            break;
        default: 
            break;
    }
    return result;
}

// Equals button listener
equals.forEach(button => {
  button.addEventListener("click", function() {
    equal();
  });
});

// Equal action
function equal () { // function used when the equals button is clicked; calculates equation and displays it
    firstNumber = calculate(firstNumber, parseFloat(output.innerHTML));
    output.innerHTML = firstNumber.toString();
    nextReady = true;
}

// Clear button listener
clear.forEach(button => {
  button.addEventListener("click", function() {
    clearCalc();
  });
});

// A/C action
function clearCalc () { // clears calculator
    firstNumber = null;
    output.innerHTML = "0";
    nextReady = true;
}
</script>

<!-- 
Vanta animations just for fun, load JS onto the page
-->
<script src="/teacher/assets/js/three.r119.min.js"></script>
<script src="/teacher/assets/js/vanta.halo.min.js"></script>
<script src="/teacher/assets/js/vanta.birds.min.js"></script>
<script src="/teacher/assets/js/vanta.net.min.js"></script>
<script src="/teacher/assets/js/vanta.rings.min.js"></script>

<script>
// setup vanta scripts as functions
var vantaInstances = {
  halo: VANTA.HALO,
  birds: VANTA.BIRDS,
  net: VANTA.NET,
  rings: VANTA.RINGS
};

// obtain a random vanta function
var vantaInstance = vantaInstances[Object.keys(vantaInstances)[Math.floor(Math.random() * Object.keys(vantaInstances).length)]];

// run the animation
vantaInstance({
  el: "#animation",
  mouseControls: true,
  touchControls: true,
  gyroControls: false
});
</script>

