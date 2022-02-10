import java.util.*;
import java.io.*;

/**
 * SubWordFinder searches a dictionary list file for entries that contain sub-words also
 * in the dictionary. It then outputs the root word and the subwords that make up the root word.
 * @version 02/10/2022
 * @author Nate Alexander
 * Help from Michael Yancy.
 */

public class SubWordFinder implements WordFinder {
    private ArrayList<ArrayList<String>> dictionary; //jaggedlist
    private String alpha = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Constructor for dictionary list
     */

    public SubWordFinder() {
        dictionary = new ArrayList<>();
        // 26 empty bucket
        for(int i = 0; i < 26; i++) {
            dictionary.add(new ArrayList<String>());
        }
        populateDictionary();
    }

    /**
     * Populates the dictionary from the text file contents
     * The dictionary object should contain 26 buckets, each
     * bucket filled with an ArrayList<String>
     * The String objects in the buckets are sorted A-Z because
     * of the nature of the text file words_all_os.txt
     */

    public void populateDictionary()    {
        try {
            Scanner in = new Scanner(new File("words_all_os.txt"));
            while(in.hasNext()) {
                String word = in.nextLine();
                dictionary.get(alpha.indexOf(word.charAt(0))).add(word);
            }
            in.close();
        }
        catch(Exception e)  {
            e.printStackTrace();
        }
    }

    /**
     * Binary search method searches through the sorted dictionary array list and
     * returns whether the target item is in the dictionary array list or not.
     * @param bucket ArrayList<String> that contains all words of one of the 26 letters
     * @param word The item to be searched for in the dictionary
     * @return
     */

    private int IndexOf(ArrayList<String> bucket, String word)   {
        int min = 0, max = bucket.size()-1, mid;
        while(min <= max)   {
            mid = (min + max) / 2;
            if(bucket.get(mid).compareTo(word) < 0)   {
                min = mid + 1;
            }
            else if(bucket.get(mid).compareTo(word) > 0)  {
                max = mid -1;
            }
            else    {
                return mid;
            }
        }
        return -1;
    }

    /**
     * Look through the entire dictionary object to see if
     * word exists in dictionary
     * @param word The item to be searched for in dictionary
     * @return true if word is in dictionary, false otherwise
     */

    public boolean inDictionary(String word)    {
        int index = alpha.indexOf(word.charAt(0));
        ArrayList<String> bucket = dictionary.get(index);
        return IndexOf(bucket, word) >= 0;
    }

    /**
     * Retrieve all SubWord objects from the dictionary.
     * @return An ArrayList containing the SubWord objects
     * Pull from the file words.txt
     */

    public ArrayList<SubWord> getSubWords() {
        ArrayList<SubWord> subWords = new ArrayList<>();
        String sub1 = "";
        String sub2 = "";

        for(ArrayList<String> bucket : dictionary) {
            for (String word : bucket) {
                if (word.length() > 5) {
                    for (int i = 2; i < word.length() - 2; i++) {
                        sub1 = word.substring(0, i);
                        sub2 = word.substring(i);
                        if (inDictionary(sub1) && inDictionary(sub2))
                            subWords.add(new SubWord(word, sub1, sub2));
                    }
                }
            }
        }
        return subWords;
    }


    /**
     * Prints full dictionary list if necessary.
     */

    public void printDictionary()   {
        for(ArrayList<String> bucket : dictionary)
            System.out.println(bucket);
    }

    /**
     * Main entry point.
     * @param args
     */

    public static void main(String[] args) {
        SubWordFinder app = new SubWordFinder();
        for(SubWord a : app.getSubWords()){
            System.out.println(a);
        }
        System.out.println(app.getSubWords().size());
    }
}