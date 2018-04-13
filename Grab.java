import java.io.*;
import java.util.ArrayList;

public class Grab {

    private String fileName;
    private ArrayList<String> list;
    
    public Grab (String fileName) {
        this.fileName = fileName;
        this.list = new ArrayList<String>();
        this.makeList(); //Making list of words
    }

    //Returns total number of messages
    public int getTotal() {
        return this.list.size();
    }

    //Return number of times desired word appears
    public int getWordCount (String desired) {
        int counter = 0;
        for (String possible : this.list) {
            if (possible.compareToIgnoreCase(desired) == 0) counter++;
        }
        return counter;
    }


    //Method when Grab is instantiated to
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
                        if (word.length() > 1) {    //only if word is more than 1 character
                            this.list.add(word);
                        }
                    }
                }
            }
            input.close();
        }
        catch (IOException e2) {System.out.println(e2.getMessage());}
    }
}