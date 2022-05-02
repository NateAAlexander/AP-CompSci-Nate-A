import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.*;
import java.util.Collections;
import java.io.File;


/**
 * This class sorts data from file, populates database, and does input/output.
 * @author Nate ALexander
 * @version 05/02/2022
 * Help from Michael Yancy and Sean Donahue.
 */


public class TrailDatabase {
    private ArrayList<Waypoint> database;
    private int searchTerm;
    private boolean asc;


    /**
     * Constructor.
     */


    public TrailDatabase()  {
        database = new ArrayList<>();
        populateDatabase();
    }


    /**
     All data out of the apptrailDB.txt.
     */


    public void populateDatabase()  {
        try {
            Scanner in = new Scanner(new File("apptrailDB.txt"));
            while(in.hasNext())   {
                String[] line = in.nextLine().split("\t");
                database.add(new Waypoint(line[0], line[1], line[2], Double.parseDouble(line[5]),
                        Double.parseDouble(line[6]), Integer.parseInt(line[7])));
            }
            in.close();
        }
        catch(Exception e)  {
            e.printStackTrace();
        }
    }


    /**
     * Handles input to find searchTerm and order.
     */


    public void getSearchTerm() {
        System.out.println("+ Menu of search terms to use for sorting waypoints +\n" +
                "\tTY: by type\n" +
                "\tNA: by name\n" +
                "\tST: by state\n" +
                "\tDS: by distance to Springer\n" +
                "\tDK: by distance to Katahdin\n" +
                "\tEL: by elevation\n");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your preferred sort by term or 'Q' to quit: ");
        String term = in.nextLine();
        if(term.equalsIgnoreCase("TY"))
            searchTerm = 1;
        else if(term.equalsIgnoreCase("NA"))
            searchTerm = 2;
        else if(term.equalsIgnoreCase("ST"))
            searchTerm = 3;
        else if(term.equalsIgnoreCase("DS"))
            searchTerm = 4;
        else if(term.equalsIgnoreCase("DK"))
            searchTerm = 5;
        else if(term.equalsIgnoreCase("EL"))
            searchTerm = 6;
        else
            searchTerm = 0;
        if(searchTerm != 0) {
            System.out.println("Enter 'A' to sort in ascending order or 'D' to sort in descending order: ");
            term = in.nextLine();
            asc = (term.toLowerCase().equals("a")) ? true : false;
        }
    }


    /**
     * Prints.
     */


    public void printDatabase()   {
        for(Waypoint w : database)
            System.out.println(w);
    }


    /**
     * Sorts data by searchTerm and in ascending or descending order.
     */


    public void selectedSort()    {
        WaypointComparator wc = new WaypointComparator(searchTerm, asc);
        Waypoint toSwap;
        int index;
        for(int out = 0; out < database.size(); out++)  {
            index = out;
            toSwap = database.get(out);
            for(int in = out+1; in < database.size(); in++) {
                Waypoint temp = database.get(in);
                if(wc.compare(temp, toSwap) < 0)    {
                    toSwap = new Waypoint(temp);
                    index = in;
                }
            }
            database.set(index, database.get(out));
            database.set(out, toSwap);
        }
    }


    /**
     * Main.
     * @param args
     */


    public static void main(String[] args) {
        TrailDatabase db = new TrailDatabase();
        System.out.println("*** Welcome to the Appalachian Trail Database ***\n");
        while(true) {
            db.getSearchTerm();
            if(db.searchTerm == 0)
                break;
            db.selectedSort();
            db.printDatabase();
        }
        System.out.println("End of program");
    }
}
