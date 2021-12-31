import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * This program will calculate the user's BMI with given height and weight information.
 * @version 11/09/2021
 * @author Nate Alexander
 * Recieved help from Michael Yancy and Sean Donahue.
 */

public class BMICalculator {
    /** Convert English to metric units, perform the BMI calculation.
     * NOTE: the method must properly handle bad data */
    
    public static double computeBMI(int inches, int pounds) {
        //1 inch == 0.0254 meters
        //1 pound == 0.454 kg
        if(inches <= 0 || pounds < 0)
            return 0;
        return pounds*.454 / Math.pow(inches*.0254, 2);
        
    }

    /**
     * Converts feet'inches".
     * @param value
     * @return
     */
    
    public int extractInches(String value) {
        int qtPos = value.indexOf("'");
        int dblQtPos = value.indexOf("\"");
        if (qtPos == -1 || dblQtPos == -1) {
            return -1;
        }
        int feet = Integer.parseInt(value.substring(0, qtPos));
        int inches = Integer.parseInt(value.substring(qtPos + 1, dblQtPos));
        if (inches < 0 || inches > 11 || feet < 0)
            return -1;
        return feet * 12 + inches;
        
    }

    /**
     * Main entry point for BMICalculator: Uses a Scanner to prompt the user for info,
     * process the feet/inches conversion, calls the computeBMI method and prints the correct information.
     * @param args
     */

    public static void main (String[]args){
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        String height = " ";
        int weight = 0;
        while (true) {
            try {
                height = " ";
                while(extractInt(height)==-1)   {
                    System.out.print("Enter your height (ie 5'9\"):  ");
                    height = in.nextLine(); }
                System.out.print("Enter your weight (lbs): ");
                weight = in.nextInt();
                in.nextLine(); // IDK
                System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " + df.format(computeBMI(extractInt(height), weight)));
                System.out.print("Continue(Y/N): ");
                String cont = in.nextLine();
                if (!cont.toLowerCase().equals("y"))
                    break;
            } catch (Exception e) {
                height = " ";
                weight = 0;
                System.err.println("There was an error");
            }
            System.out.println("End of program");
    }
}
