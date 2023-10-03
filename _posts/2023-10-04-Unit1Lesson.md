---
title: Unit 1 Lesson Hacks Blog
toc: True
description: Lesson 1 Hacks Complete
courses: {'csse': {'week': 5}, 'csp': {'week': 2, 'categories': ['3.A', '5.B']}, 'csa': {'week': 7}}
categories: ['C3.0', 'C3.1', 'C4.1']
type: hacks
---
```java
import java.util.*;
public class Game {
    int x = 0;
    int y = 0;
    boolean XgameWin = false;
    boolean YgameWin = false;
    public void gameWinChange(boolean X, boolean Y) {
        if (X) {
            x = updateScore(x, y);
            XgameWin = true;
        } else {
            y = updateScore(y, x);
            YgameWin = true;
        }
    }
    public int updateScore(int Wscore, int Lscore) {
        Wscore++;
        Lscore--;
        if (Wscore == 10 || Lscore == 10) {
            Wscore = 0;
            Lscore = 0;
        }
        return Wscore;
    }
}
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        boolean continuePlaying = true;
        while (continuePlaying) {
            System.out.println("Enter 'X' if X wins or 'Y' if Y wins (or 'q' to quit): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("x")) {
                game.gameWinChange(true, false);
            } else if (input.equalsIgnoreCase("y")) {
                game.gameWinChange(false, true);
            } else if (input.equalsIgnoreCase("q")) {
                continuePlaying = false;
            } else {
                System.out.println("Invalid input. Please enter 'X' or 'Y'.");
                continue;
            }
            System.out.println("X Score: " + game.x);
            System.out.println("Y Score: " + game.y);
            System.out.println("X Game Win: " + game.XgameWin);
            System.out.println("Y Game Win: " + game.YgameWin);
        }
        System.out.println("Game over!");
    }
}
Main.main(null);
```
    Enter 'X' if X wins or 'Y' if Y wins (or 'q' to quit): 
    X Score: 1
    Y Score: 0
    X Game Win: true
    Y Game Win: false
    Enter 'X' if X wins or 'Y' if Y wins (or 'q' to quit): 
    X Score: 2
    Y Score: 0
    X Game Win: true
    Y Game Win: false
    Enter 'X' if X wins or 'Y' if Y wins (or 'q' to quit): 
    X Score: 3
    Y Score: 0
    X Game Win: true
    Y Game Win: false
    Enter 'X' if X wins or 'Y' if Y wins (or 'q' to quit): 
    X Score: 4
    Y Score: 0
    X Game Win: true
    Y Game Win: false
    Enter 'X' if X wins or 'Y' if Y wins (or 'q' to quit): 
    X Score: 4
    Y Score: 1
    X Game Win: true
    Y Game Win: true
    Enter 'X' if X wins or 'Y' if Y wins (or 'q' to quit): 
    X Score: 4
    Y Score: 2
    X Game Win: true
    Y Game Win: true
    Enter 'X' if X wins or 'Y' if Y wins (or 'q' to quit): 
    X Score: 4
    Y Score: 3
    X Game Win: true
    Y Game Win: true
    Enter 'X' if X wins or 'Y' if Y wins (or 'q' to quit): 
    X Score: 5
    Y Score: 3
    X Game Win: true
    Y Game Win: true
    Enter 'X' if X wins or 'Y' if Y wins (or 'q' to quit): 
    X Score: 6
    Y Score: 3
    X Game Win: true
    Y Game Win: true
    Enter 'X' if X wins or 'Y' if Y wins (or 'q' to quit): 
    X Score: 6
    Y Score: 4

# Grading
## 1/1 Point for correctly changing the boolean in Part A
## 1/1 Point for using Compound Assigment Operators in Part B
## 1/1 Point for Values reseting when one hits 10 points
## 1/1 Point for Passing Arguments through Part A and B
