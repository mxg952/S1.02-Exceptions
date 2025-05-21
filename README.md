# S1.02- Exceptions
This repository contains a set of Java exercises focused on fundamental object-oriented programming concepts, exception handling, and user input validation. The content is organized into 
three levels:

## Level 1 – Product Sale and Custom Exceptions
### Exercise 1:
Implementation of two classes: Product and Sale. The Sale class contains a list of products and calculates the total price. It includes a custom exception EmptySaleException that is thrown 
when attempting to calculate the total of an empty product list.

## Level 2 – Input Handling with Scanner and Exceptions
### Exercise 1:
Creation of a utility class Entrada with static methods to read various types of input from the keyboard (byte, int, float, double, char, String, and yes/no boolean), using Java’s Scanner.
Built-in exceptions like InputMismatchException are handled to ensure correct data entry. Custom exceptions are used to validate specific inputs, ensuring robustness and user-friendly feedback.

## Level 3 – Cinema Seat Reservation System
### Exercise 1:
A complete console application simulating a cinema ticket booking system. The user can configure the number of rows and seats, view and manage seat reservations, and cancel bookings.
The program is structured into several classes (Cinema, Seat, SeatManager, CinemaManager) and uses multiple custom exceptions to validate user input.

## Technologies Used
* Java
* IntelliJ
* Git

## Requirements
* Java 17
* IntelliJ (optional)

## Installation

1. Clone the repository:
```
git clone https://github.com/mxg912/1.1_Herencia_Polimorfisme.git
```
2. Open the project with IntelliJ IDEA.

3. Run the class `nivell1.app.Main.java`.

## Execution

## Deployment

## Contributions
The project ignores `.idea/`, `.out/`, `.iml`.

1. Fork the repository
2. Create a new branch: `git checkout -b feature/NewFeature`
3. Make your changes and commit them: `git commit -m 'Add New Feature'`
4. Push the changes to your branch: `git push origin feature/NewFeature`
5. Open a pull request
