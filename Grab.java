import java.io.*;
import java.util.*;

public class Grab {

    private String fileName;
    private HashMap <String, Integer> mesmap;
    
    public Grab (String fileName) {
        this.fileName = fileName;
        mesmap = new HashMap<String, Integer>();
        this.makeList(); //Making list of words
    }

    //Returns total number of messages
    public int getTotal() {
        int total = 0;
        for (int i : this.mesmap.values()) {
            total += i;
        }
        return total;
    }

    //Return number of desired word
    public int getWordCount (String desired) {
        return this.mesmap.get(desired);
    }

    public String getCommon () {
        int i = 0;
        String common = "";
        for (String current : this.mesmap.keySet()) {
            if (i < mesmap.get(current)) {
                i = mesmap.get(current);
                common = current;
            }
        }

        
        return common + " appeared the most at "+ i + " times.";
    }



    private void makeList () {
            String[] newLine;
            String line;
        try {
            //Opening file containing all texts and wrapping with buffered reader
            FileReader file = new FileReader (this.fileName);
            BufferedReader input = new BufferedReader(file);

            //Looping through each line in file
            while ( (line = input.readLine()) != null) {
                //Removing white space, puncts and all non digit/letter
                //Placing into temporary array
                newLine = line.split("\\s+|\\p{Punct}|\\W+");

                if (newLine.length > 0) {
                    for (String word : newLine) {
                        //placing each hashed out word into ArrayList
                        if (word.length() > 0) {    //word should not be a space
                            if (mesmap.containsKey(word.toLowerCase()) == false) {
                                this.mesmap.put(word.toLowerCase(), 1);
                            } else {
                                mesmap.replace(word.toLowerCase(), this.mesmap.get(word.toLowerCase()).intValue() + 1);
                            }
                        }
                    }
                }
            }
            input.close();
        }
        catch (IOException e2) {System.out.println(e2.getMessage());}
    }
}