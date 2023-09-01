---
# this is YAML front matter
layout: post
title: Java Console Games
description: A progressive journey through Java basics starting with the classic "Hello, World!" example.
courses: { csa: {week: 2}}
categories: [C4.0]
type: tangibles
---
## A simple console game I made
- Apparently I made this without knowing that its a copy of higher or lower
```java
import java.util.*;
import java.lang.Math;
public class NumberGuess{
    public static void main(String[] args){
        Random rand = new Random();
        Integer maximum = 100000;
        Integer number = rand.nextInt(maximum);
        Integer cracked = 10;
        Integer number_of_guesses = 0;
        Scanner input = new Scanner(System.in);
        boolean solved = false;
        System.out.println("Guess a random number from 0 to 100000");
        while(!solved){
            Integer userInput = input.nextInt();
            if (userInput < number){
                System.out.println("Smaller than the number");
                number_of_guesses++;
            } else if(userInput > number){
                System.out.println("Greater than the number");
                number_of_guesses++;
            }
            else{
                System.out.println("Congratulations you win!");
                solved = true;
            }
        }
        if (number_of_guesses > cracked){
            System.out.println("You're bad! You guessed more than ten times!");
        } else{
            System.out.println("You rock! Have a piece of java candy!");
        }

    }
}
```

## Analysis of AP CSA's console game code
- Higher or Lower Code
```java
    public void horl(){//First 3 lines print the rules
        System.out.println("Higher or Lower");
        System.out.println("You have three guesses to guess the number I am thinking of between 1-8.");
        System.out.println("If you guess the number correctly, you win!");
        Scanner scHL = new Scanner(System.in);//input code
        int randomG = (int) (Math.random() * 8) + 1;
        int guess = scHL.nextInt();
        for(int i = 3; i > 0; i--){//Apparently more attempt constraintive
            if(guess == randomG){
                System.out.println("You win!");
                break;
            }
            else if(guess > randomG){
                System.out.println("The number is lower");
            }
            else if(guess < randomG){
                System.out.println("The number is higher");
            }
            guess = scHL.nextInt();
        }
        System.out.println("Game over.");
        scHL.close();
    }
```
- Rock Paper Scissors
```java
public void rps(){
        System.out.println("Rock Paper Scissors");
        System.out.println("Type r for rock, p for paper, or s for scissors");//first two lines print instructions
        Scanner scRPS = new Scanner(System.in);
        String userChoice = scRPS.nextLine().toLowerCase(); //asks for user input
        Boolean quit = false;
        int random = (int) (Math.random() * 3); //Random numbers
        while(quit == false){//All of this code represents how the rock, paper, scissors simulation works
            if(userChoice.equals("r")){
                if(random == 1){
                    System.out.println("You chose rock \nThe computer chose paper \nYou lose!");
                }
                else if(random == 2){
                    System.out.println("You chose rock \nThe computer chose scissors \nYou win!");
                }
                else{
                    System.out.println("You chose rock \nThe computer chose rock \nIt's a tie!");
                }
                quit = true;
            }
            else if(userChoice.equals("p")){
                if(random == 1){
                    System.out.println("You chose paper \nThe computer chose paper \nIt's a tie!");
                }
                else if(random == 2){
                    System.out.println("You chose paper \nThe computer chose scissors \nYou lose!");
                }
                else{
                    System.out.println("You chose paper \nThe computer chose rock \nYou win!");
                }
                quit = true;

            }
            else if(userChoice.equals("s")){
                if(random == 1){
                    System.out.println("You chose scissors \nThe computer chose paper \nYou win!");
                }
                else if(random == 2){
                    System.out.println("You chose scissors \nThe computer chose scissors \nIt's a tie!");
                }
                else{
                    System.out.println("You chose scissors \nThe computer chose rock \nYou lose!");
                }
                quit = true;

            }
            else{
                System.out.println("Invalid input, try again");
                userChoice = scRPS.nextLine();
            }            
        }
        scRPS.close();
    }
```

- Tic Tac Toe Analysis!

```java
public void ticTacToe(){
        System.out.println("Tic Tac Toe");
        Scanner scTTT = new Scanner(System.in);
        String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String player = "X";
        String player2 = "O";
        int turn = 0;
        Boolean quit = false;
        System.out.println("Do you want to play against a friend or the computer?");
        System.out.println("Type 1 for friend, 2 for computer");
        int choice = scTTT.nextInt();
        //make tic tac toe using player1 and player2
        if(choice == 1){                
            System.out.println("Type the number of the square you want to place your piece in");
            while(quit == false){
                System.out.println("Player 1's turn (X)");
                System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
                System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
                System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
                int move = scTTT.nextInt();
                if(board[move - 1].equals("X") || board[move - 1].equals("O")){
                    System.out.println("That square is already taken, try again");
                }
                else{
                    board[move - 1] = player;
                    turn++;
                    if(board[0].equals("X") && board[1].equals("X") && board[2].equals("X")){
                        System.out.println("Player 1 wins!");
                        quit = true;
                    }
                    else if(board[3].equals("X") && board[4].equals("X") && board[5].equals("X")){
                        System.out.println("Player 1 wins!");
                        quit = true;
                    }
                    else if(board[6].equals("X") && board[7].equals("X") && board[8].equals("X")){
                        System.out.println("Player 1 wins!");
                        quit = true;
                    }
                    else if(board[0].equals("X") && board[3].equals("X") && board[6].equals("X")){
                        System.out.println("Player 1 wins!");
                        quit = true;
                    }
                    else if(board[1].equals("X") && board[4].equals("X") && board[7].equals("X")){
                        System.out.println("Player 1 wins!");
                        quit = true;
                    }
                    else if(board[2].equals("X") && board[5].equals("X") && board[8].equals("X")){
                        System.out.println("Player 1 wins!");
                        quit = true;
                    }
                    else if(board[0].equals("X") && board[4].equals("X") && board[8].equals("X")){
                        System.out.println("Player 1 wins!");
                        quit = true;
                    }
                    else if(board[2].equals("X") && board[4].equals("X") && board[6].equals("X")){
                        System.out.println("Player 1 wins!");
                        quit = true;
                    }
                    else if(turn == 9){
                        System.out.println("It's a tie!");
                        quit = true;
                    }
                    else{
                        System.out.println("Player 2's turn (O)");
                        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
                        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
                        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
                        int move2 = scTTT.nextInt();
                        if(board[move2 - 1].equals("X") || board[move2 - 1].equals("O")){
                            System.out.println("That square is already taken, try again");
                        }
                        else{
                            board[move2 - 1] = player2;
                            turn++;
                            if(board[0].equals("O") && board[1].equals("O") && board[2].equals("O")){
                                System.out.println("Player 2 wins!");
                                quit = true;
                            }
                            else if(board[3].equals("O") && board[4].equals("O") && board[5].equals("O")){
                                System.out.println("Player 2 wins!");
                                quit = true;
                            }
                            else if(board[6].equals("O") && board[7].equals("O") && board[8].equals("O")){
                                System.out.println("Player 2 wins!");
                                quit = true;
                            }
                            else if(board[0].equals("O") && board[3].equals("O") && board[6].equals("O")){
                                System.out.println("Player 2 wins!");
                                quit = true;
                            }
                            else if(board[1].equals("O") && board[4].equals("O") && board[7].equals("O")){
                                System.out.println("Player 2 wins!");
                                quit = true;
                            }
                            else if(board[2].equals("O") && board[5].equals("O") && board[8].equals("O")){
                                System.out.println("Player 2 wins!");
                                quit = true;
                            }
                        }
                    }
                }
            }
        }
        if(choice == 2){
            String computer = "O";
            System.out.println("Type the number of the square you want to place your piece in");
            while(quit == false){//Does all of the player moves
                System.out.println("Player 1's turn (X)");
                System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
                System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
                System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
                int move = scTTT.nextInt();
                if(board[move - 1].equals("X") || board[move - 1].equals("O")){
                    System.out.println("That square is already taken, try again");
                }
                else{//Mentions the moves for this
                    board[move - 1] = player;
                    turn++;
                    if(board[0].equals("X") && board[1].equals("X") && board[2].equals("X")){
                        System.out.println("Player 1 wins!");
                        quit = true;
                    }
                    else if(board[3].equals("X") && board[4].equals("X") && board[5].equals("X")){
                        System.out.println("Player 1 wins!");
                        quit = true;
                    }
                    else if(board[6].equals("X") && board[7].equals("X") && board[8].equals("X")){
                        System.out.println("Player 1 wins!");
                        quit = true;
                    }
                    else if(board[0].equals("X") && board[3].equals("X") && board[6].equals("X")){
                        System.out.println("Player 1 wins!");
                        quit = true;
                    }
                    else if(board[1].equals("X") && board[4].equals("X") && board[7].equals("X")){
                        System.out.println("Player 1 wins!");
                        quit = true;
                    }
                    else if(board[2].equals("X") && board[5].equals("X") && board[8].equals("X")){
                        System.out.println("Player 1 wins!");
                        quit = true;
                    }
                    else if(board[0].equals("X") && board[4].equals("X") && board[8].equals("X")){
                        System.out.println("Player 1 wins!");
                        quit = true;
                    }
                    else if(board[2].equals("X") && board[4].equals("X") && board[6].equals("X")){
                        System.out.println("Player 1 wins!");
                        quit = true;
                    }
                    else if(turn == 9){
                        System.out.println("It's a tie!");
                        quit = true;
                    }
                    else{
                        System.out.println("Computer's turn (O)");
                        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
                        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
                        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
                        int move2 = (int)(Math.random() * 9) + 1;
                        if(board[move2 - 1].equals("X") || board[move2 - 1].equals("O")){
                            System.out.println("That square is already taken, try again");
                        }
                        else{
                            board[move2 - 1] = computer;
                            turn++;
                            if(board[0].equals("O") && board[1].equals("O") && board[2].equals("O")){
                                System.out.println("Computer wins!");
                                quit = true;
                            }
                            else if(board[3].equals("O") && board[4].equals("O") && board[5].equals("O")){
                                System.out.println("Computer wins!");
                                quit = true;
                            }
                            else if(board[6].equals("O") && board[7].equals("O") && board[8].equals("O")){
                                System.out.println("Computer wins!");
                                quit = true;
                            }
                            else if(board[0].equals("O") && board[3].equals("O") && board[6].equals("O")){
                                System.out.println("Computer wins!");
                                quit = true;
                            }
                            else if(board[1].equals("O") && board[4].equals("O") && board[7].equals("O")){
                                System.out.println("Computer wins!");
                                quit = true;
                            }
                            else if(board[2].equals("O") && board[5].equals("O") && board[8].equals("O")){
                                System.out.println("Computer wins!");
                                quit = true;
                            }
                        }
                    }
                }
            }
          
    }
        scTTT.close();//Closes game
    }

```