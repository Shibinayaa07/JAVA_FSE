/*
Exercise 1: Implementing the Singleton Pattern
Scenario:
You need to ensure that a logging utility class in your application has only one instance throughout the application lifecycle to ensure consistent logging.
Steps:

Create a New Java Project:
o	Create a new Java project named SingletonPatternExample.

Define a Singleton Class:
o	Create a class named Logger that has a private static instance of itself.
o	Ensure the constructor of Logger is private.
o	Provide a public static method to get the instance of the Logger class.

Implement the Singleton Pattern:
o	Write code to ensure that the Logger class follows the Singleton design pattern.

Test the Singleton Implementation:
o	Create a test class to verify that only one instance of Logger is created and used across the application.
*/
package deepskilling.data_structures_and_principles;

class Logger{
    private static Logger instance;
    private Logger(){
        System.out.println("Objected created once");
    }
    public static Logger getInstance() {
        if(instance == null){
            instance = new Logger();
        }
        return instance;

    }
}


public class ex1 {
    public static void main(String[] args){
        Logger a1 = Logger.getInstance();
        Logger b1 = Logger.getInstance();

        System.out.println(a1 == b1);
    }    
}
