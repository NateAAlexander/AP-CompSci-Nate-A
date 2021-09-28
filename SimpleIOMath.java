/**
 *  SimpleIOMath prints a conversation the computer has with a user
 *  while asking the user to input numerical data.
 * @version 09/28/2021
 * @author 22alexander
 */
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class SimpleIOMath {
    private static String name;
    private static int age;
    private static int favNumber;

    private int smallestPrime(int num)  {
        for(int i = 2; i <= (int)(Math.sqrt(num))+1; i++)   {
            if(num % i == 0)
                return i;
        }
        return num;
    }

    /**
     * Ask the user questions and stores the answer
     */
    public void promptUser()    {
        Scanner input = new Scanner(System.in);
        System.out.println("Question 1: What is your name?");
        name = input.nextLine();
        System.out.println("Question 2: How old are you?");
        age = input.nextInt();
        System.out.println("Question 3: What is your favorite number?");
        favNumber = input.nextInt();
    }

    /**
     * Prints the necessary info
     */
    public void printInfo() {
        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + age);
        System.out.println("At your next birthday, you will turn " + (age + 1));
        System.out.println("The first prime factor of " + age + " is: " + smallestPrime(age));
        System.out.println("Your favorite number squared is: " + (favNumber * favNumber));
    }

    /**
     * Main entry point for class SimpleIOMath
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("* Sit yourself down, take a seat *");
        System.out.println("* All you gotta do is repeat after me *");
        SimpleIOMath obj = new SimpleIOMath();
        obj.promptUser();
        System.out.println("I'm gonna teach you how to sing it out");
        System.out.println("Come on, come on, come on");
        System.out.println("Let me tell you what it's all about");
        System.out.println("Reading, writing, arithmetic");
        System.out.println("Are the branches of the learning tree");
        obj.printInfo();
        System.out.println("* end of program *");
    }
}