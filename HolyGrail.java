/**
 * Holygrail is a program that is an interactive chat with a bridge keeper.
 * @version 09/15/2021
 * @author 22alexander
 */

import java.util.Scanner;

public class HolyGrail {
    /**
     * Main entry point for HolyGrail
     * @param args main line arguments if needed
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("* A chat with the bridge keeper *");
        System.out.println("Who would cross the bridge of death must answer me these questions three, ere the other side he see.");
        System.out.println("Question 1: What is your name?");
        String whatname = input.nextLine();
        System.out.println("Question 2: What is your quest?");
        String whatquest = input.nextLine();
        System.out.println("Question 3: What is your favorite color?");
        String whatcolor = input.nextLine();
        System.out.println("King Arthur says, \"You have to know these things when you're a\n" +
                "king, you know.\"");
        System.out.println("Your name is:" + whatname);
        System.out.println("Your quest is:" + whatquest);
        System.out.println("Your favorite color is:" + whatcolor);

    }

}