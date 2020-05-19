import java.io.*;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.LinkedList;

public class step_3
{
    public static void chunkFile(char start, char fin) {
    String fname;
    Scanner scan = new Scanner("eng_newscrawl-public_2018_1M-words.txt");

    /* enter filename with extension to open and read its content */

    // System.out.print("Enter File Name to Open (with extension like file.txt) : ");
    fname = scan.nextLine();


    /* this will reference only one line at a time */

    String line = null;
    Hashtable <String, LinkedList<String>> chunked ;
    chunked = new Hashtable<>() ;
    try
    {

        while(start <='d'){
            try{
                String a = Character.toString(start);
            chunked.put(a,new LinkedList<>()) ;
        }catch (NullPointerException e) {
            System.out.print("Caught the NullPointerException");
        }
            //do work on txt file
            start++;
            // System.out.println(start);
        }
        System.out.println(chunked);
        /* FileReader reads text files in the default encoding */
        FileReader fileReader = new FileReader(fname);

        /* always wrap the FileReader in BufferedReader */
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[] nline;
        while((line = bufferedReader.readLine()) != null)
        {
            nline = line.split("\\s+");
            List <String> cocktailsausage = new ArrayList <String> ();
            cocktailsausage = Arrays.asList(nline);
            if(cocktailsausage.size() > 1) {
               String c = cocktailsausage.get(1).substring(0,1);
               LinkedList<String> l = (chunked.get(c));
               l.add(line);
           }
            // System.out.println(cocktailsausage.get(0));
        }
        System.out.println(chunked);

        // System.out.println(start + " " + fin);
        /* always close the file after use */
        bufferedReader.close();
    }
    catch(IOException ex)
    {
        System.out.println("Error reading file named '" + fname + "'");
    }
    // return uniqueMap;

    }




public static void main(String[] args){
    // System.out.println(new step_3().get_meta().toString());

    // writing to txt file

    chunkFile('a', 'z');


    // try {
    //     writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("meta.txt"), "utf-8"));
    //     for(Map.Entry<String, Integer> entry: uniqueMap.entrySet()){
    //         writer.write(i + " " + entry.getKey() + " " + entry.getKey() + " " + entry.getValue() + System.lineSeparator());
    //         i+=1;
    //     }
    // } catch (IOException ex) {
    //     // Report
    // } finally {
    // try {writer.close();} catch (Exception ex) {/*ignore*/}
    // }


}
}
