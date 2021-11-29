import java.util.Scanner;
import java.io.*;
import javax.swing.JFileChooser;

/**
 * BaseConverter opens a data file, reads, converts numbers, prints
 * @version Tuesday 11/23/2021
 * @author 22alexander
 * Help from Michael Yancy and https://www.codejava.net/java-se/swing/show-simple-open-file-dialog-using-jfilechooser .
 */

public class BaseConverter {// Constructor for class.
    public BaseConverter(){

    }
    // Convert a String num in fromBase to base-10 int.
    public int strToInt(String num, String fromBase){
        int base = Integer.parseInt(fromBase);
        String alpha ="0123456789ABCDEF";
        int sum = 0, exp = 0;
        for(int i = num.length()-1; i >= 0; i--) {
            sum += alpha.indexOf("" + num.charAt(i)) * Math.pow(base, exp);
            exp++;
        }
        return sum;
    }
    // Convert a base-10 int to a String number of base toBase.
    public String intToStr(int num, int toBase){
        String alpha = "0123456789ABCDEF";
        String toNum = "";
        while(num > 0) {
            toNum = alpha.charAt(num % toBase) + toNum;
            num /= toBase;
        }
        if(toNum.equals(""))
            return "0";
        return toNum;
    }

    /** Opens the file stream, inputs data one line at a time, converts, prints
     *the result to the console window and writes data to the output stream.
     * Also includes extra: JFileChooser lets the user choose the file to be converted
     * Help from https://www.codejava.net/java-se/swing/show-simple-open-file-dialog-using-jfilechooser
     * */
    public void inputConvertPrintWrite() {
        Scanner sc = null;
        PrintWriter pw = null;
        try {
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("./datafiles"));
            int result = fc.showOpenDialog(fc.getParent());
            File selectedFile = null;
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = fc.getSelectedFile();
            }
            sc = new Scanner(new File(selectedFile.getAbsolutePath()));
            pw = new PrintWriter(new File("datafiles/converted.dat"));
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split("\t");
                int fromBase = Integer.parseInt(line[1]);
                int toBase = Integer.parseInt(line[2]);
                if (fromBase < 2 || fromBase > 16) {
                    System.out.println("Invalid input base " + fromBase);
                } else if (toBase < 2 || toBase > 16) {
                    System.out.println("Invalid output base " + toBase);
                } else {
                    // print statement to the console
                    System.out.println(line[0] + " base " + line[1] + " = " + intToStr(strToInt(line[0], line[1]), toBase) + " base " + toBase);
                    pw.println(line[0] + "\t" + line[1] + "\t" + intToStr(strToInt(line[0], line[1]), toBase) + "\t" + toBase);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(sc != null)
            sc.close();
        if(pw != null)
            pw.close();
    }

    /**
     * Main method for class BaseConverter.
     */
    public static void main(String[] args) {
        BaseConverter app = new BaseConverter();
        app.inputConvertPrintWrite();
    }
}