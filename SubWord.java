import java.util.*;

/**
 * SubWord - the root word and the two interior words within it.
 * @author Nate Alexander
 * @version 02/10/2022
 */

public class SubWord implements Comparable<SubWord> {
    private String rootWord;
    private String sub1, sub2;

    /**
     * Constructor for a SubWord object.
     * @param root The rootWord value of this object.
     */

    public SubWord(String root, String firstSub, String secondSub)	{
        rootWord = root;
        sub1 = firstSub;
        sub2 = secondSub;
    }

    /**
     * Utility accessor method
     * @return The rootWord of this object
     */

    public String getRoot()	{
        return rootWord;
    }

    /**
     * Utility accessor method
     * @return The list of sub words
     */

    public String getSubWords()	{
        return sub1 + " + " + sub2;
    }

    /**
     * Compares two SubWord objects alphabetically A to Z based on rootWord
     * @return -int if this.rootWord is less than other.rootWord, 0 if both
     * are equal, +int if this.rootWord is greater than other.rootWord
     */

    public int compareTo(SubWord other)	{
        return this.rootWord.compareTo(other.rootWord);
    }

    /**
     * @return This SubWord in root = sub1 + sub2 format
     */
    
    public String toString()	{
        return rootWord + " = " + sub1 + " + " + sub2;
    }
}
