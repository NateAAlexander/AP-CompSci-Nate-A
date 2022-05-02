/**
 * Waypoint is a class that contains the necessary information of each location
 * in the appalachian trail, and then can be implemented into an array list.
 * @author Nate Alexander
 * @version 05/02/2022
 * Help from Michael Yancy and Sean Donahue.
 */


public class Waypoint implements Comparable<Waypoint>   {
    private String type,name, state;
    private double toStringer,toKatahdin;
    private int elevation;


    /**
     * Constructor
     * @param t
     * @param n
     * @param s
     * @param ts
     * @param tk
     * @param e
     */


    public Waypoint(String t, String n, String s, double ts, double tk, int e){
        type = t;
        name = n;
        state = s;
        toStringer = ts;
        toKatahdin = tk;
        elevation = e;
    }


    /**
     * Constructor
     * @param other
     */


    public Waypoint(Waypoint other)  {
        this(other.type, other.name, other.state, other.toStringer, other.toKatahdin, other.elevation);
    }


    /**
     * getters
     * @return
     */


    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public double getToStringer() {
        return toStringer;
    }

    public double getToKatahdin() {
        return toKatahdin;
    }

    public int getElevation() {
        return elevation;
    }

    @Override


    /**
     * toString method (adds string to object/convertsobject to string)
     */


    public String toString() {
        return
                type + ", " + name + ", " + state +
                        ", Dist to Stringer: " + toStringer +
                        ", Dist to Katahdin: " + toKatahdin +
                        ", Elevation: " + elevation;
    }


    /**
     * Compares one toKatahdin instance to another
     * @param other
     * @return
     */


    public int compareTo(Waypoint other)    {
        Double d1 = this.toKatahdin;
        Double d2 = other.toKatahdin;
        return d1.compareTo(d2);
    }
}
