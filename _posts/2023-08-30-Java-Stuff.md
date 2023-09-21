---
# this is YAML front matter
layout: post
title: Java Hello
description: A progressive journey through Java basics starting with the classic "Hello, World!" example.
courses: { csa: {week: 1}}
categories: [C4.0]
type: hacks
---
#### A Bunch of Java Stuff

## Hello, World!
This article shows the basic language structures and constructs of Java (aka anatomy).  In async order, it is critical to understand these examples and learn vocab for OOP and Creating Objects: 
- [Object Oriented Programming](https://youtu.be/Wok4Xw_5cyY) 
- [Creating Objects](https://youtu.be/C5Ks_u87Ltg)
- [Calling Methods](https://youtu.be/CPE_lYGCw3A)

### Static example
The class HelloStatic contains the classic "Hello, World!" message that is often used as an introduction to a programming language.  The "public static void main(String[] args)", or main method, is the default runtime method in Java and has a very specific and ordered definition (signature). 

The key terms in HelloStatic introduction:
- "class" is a blueprint for code, it is the code definition and must be called to run
- "method" or "static method" in this case, is the code to be run/executed, similar to a procedure
- "method definition" or "signature" are the keywords "public static void" in front of the name "main" and the parameters "String[] args" after the name.
- "method call" is the means in which we run the defined code

```java
// Define Static Method within a Class
public class HelloStatic {
    // Java standard runtime entry point
    public static void main(String[] args) {    
        System.out.println("Hello World!");
    }
}
// A method call allows us to execute code that is wrapped in Class
HelloStatic.main(null);   // Class prefix allows reference of Static Method
```
- Output: Hello World!

## Dynamic Example
```java
// Define Class
public class HelloDynamic { // name the first letter of class as capitalized, note camel case
    // instance variable have access modifier (private is most common), data type, and name
    private String hello;
    // constructor signature 1, public and zero arguments, constructors do not have return type
    public HelloDynamic() {  // 0 argument constructor
        this.setHello("Hello, World!");  // using setter with static string
    }
    // constructor signature, public and one argument
    public HelloDynamic(String hello) { // 1 argument constructor
        this.setHello(hello);   // using setter with local variable passed into constructor
    }
    // setter/mutator, setter have void return type and a parameter
    public void setHello(String hello) { // setter
        this.hello = hello;     // instance variable on the left, local variable on the right
    }
    // getter/accessor, getter used to return private instance variable (encapsulated), return type is String
    public String getHello() {  // getter
        return this.hello;
    }
    // public static void main(String[] args) is signature for main/drivers/tester method
    // a driver/tester method is singular or called a class method, it is never part of an object
    public static void main(String[] args) {  
        HelloDynamic hd1 = new HelloDynamic(); // no argument constructor
        HelloDynamic hd2 = new HelloDynamic("Hello, Nighthawk Coding Society!"); // one argument constructor
        System.out.println(hd1.getHello()); // accessing getter
        System.out.println(hd2.getHello()); 
    }
}
// IJava activation
HelloDynamic.main(null);
```

<h1>A basic Java shopping simulation</h1>

```java
import java.util.*;
public class shopping {
    String item;
    double cost;
    public shopping(String Item, double Cost){//To set up a structrue to define different objects
        item = Item;
        cost = Cost;
    }
    public static void main(String[] args){
        double current_salary = 500;
        shopping burger = new shopping("Burger", 5.5); //makes a burger instance of shopping
        shopping pizza = new shopping("Pizza", 10); //makes a pizza instance
        shopping churros = new shopping("Churro", 2); //makes a churro instance
        shopping beer = new shopping("Beer", 100); //makes a beer instance. OMG its so expensive
        ArrayList<String> purchasedItems = new ArrayList<String>();

        shopping[] food = {burger,pizza,churros,beer}; //Makes a list of food to purchase
        Scanner input = new Scanner(System.in);
        System.out.println("Hello kids! Welcome to In-Get-Out! Here are some of our starters you guys can try: ");
        for(int i = 0; i < food.length;i++){//displays each individual kind of food
            String s = Double.toString(food[i].cost);
            String num = Integer.toString(i+1);
            System.out.println("We got " + food[i].item + " [" + num + "] for a cost of $"+s);
        }
        System.out.println("Now tell us all the stuff you want to purchase by its numerical values. You have $500.");
        while (current_salary > 0){ //purchases any kind of food.
            Integer purchasingitem = input.nextInt();
            System.out.println("You bought " + food[purchasingitem-1].item);
            current_salary = current_salary - food[purchasingitem-1].cost;
            purchasedItems.add(food[purchasingitem-1].item);
            System.out.println("You have $"+Double.toString(current_salary)+" left");
        }
        System.out.println("Alright here's what you have bought so far " + purchasedItems);
        System.out.println("Welp, I guess you bought everything you can buy. NOW GET OUT!"); //Output statements after the buyer becomes broke.
    }
}
```
- Output:
Hello kids! Welcome to In-Get-Out! Here are some of our starters you guys can try: 

We got Burger [1] for a cost of $5.5

We got Pizza [2] for a cost of $10.0

We got Churro [3] for a cost of $2.0

We got Beer [4] for a cost of $100.0

Now tell us all the stuff you want to purchase by its numerical values. You have $500.

- Simple Console Game

```java
import java.util.Scanner; //library for user input
import java.lang.Math; //library for random numbers

public class ConsoleGame {
    public final String DEFAULT = "\u001B[0m";  // Default Terminal Color
    
    public ConsoleGame() {
        Scanner sc = new Scanner(System.in);  // using Java Scanner Object
        
        boolean quit = false;
        while (!quit) {
            this.menuString();  // print Menu
            try {
                int choice = sc.nextInt();  // using method from Java Scanner Object
                System.out.print("" + choice + ": ");
                quit = this.action(choice);  // take action
            } catch (Exception e) {
                sc.nextLine(); // error: clear buffer
                System.out.println(e + ": Not a number, try again.");
            }
            
        }
        sc.close();
    }

    public void menuString(){
        String menuText = ""
                + "\u001B[35m___________________________\n"  
                + "|~~~~~~~~~~~~~~~~~~~~~~~~~|\n"
                + "|\u001B[0m          Menu!          \u001B[35m|\n"
                + "|~~~~~~~~~~~~~~~~~~~~~~~~~|\n"
                + "| 0 - Exit                |\n"    
                + "| 1 - Rock Paper Scissors |\n"
                + "| 2 - Higher or Lower     |\n"
                + "| 3 - Tic Tac Toe         |\n"
                + "|_________________________|   \u001B[0m\n"
                + "\n"
                + "Choose an option.\n"
                ;
        System.out.println(menuText);
    }

    private boolean action(int selection) {
        boolean quit = false;
        switch (selection) {  // Switch or Switch/Case is Control Flow statement and is used to evaluate the user selection
            case 0:
                System.out.print("Goodbye, World!"); 
                quit = true; 
                break;
            case 1:
                rps();
                break;
            case 2:
                horl();
                break;
            case 3:
                ticTacToe();
                break;
                    
            default:
                //Prints error message from console
                System.out.print("Unexpected choice, try again.");
        }
        System.out.println(DEFAULT);  // make sure to reset color and provide new line
        return quit;
    }

    public void horl(){
        System.out.println("Higher or Lower");
        System.out.println("You have three guesses to guess the number I am thinking of between 1-8.");
        System.out.println("If you guess the number correctly, you win!");
        Scanner scHL = new Scanner(System.in);
        int randomG = (int) (Math.random() * 8) + 1;
        int guess = scHL.nextInt();
        for(int i = 3; i > 0; i--){
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
                                                     
    public void rps(){
        System.out.println("Rock Paper Scissors");
        System.out.println("Type r for rock, p for paper, or s for scissors");
        Scanner scRPS = new Scanner(System.in);
        String userChoice = scRPS.nextLine().toLowerCase();
        Boolean quit = false;
        int random = (int) (Math.random() * 3);
        while(quit == false){
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
        scTTT.close();
    }

    static public void main(String[] args)  {  
        new ConsoleGame(); // starting Menu object
    }


}
ConsoleGame.main(null);
```
