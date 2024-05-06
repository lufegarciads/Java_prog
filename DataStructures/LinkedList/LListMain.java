// Luis Felipe Garcia de Souza (Leader), Diana Afanasyev, Jessie Moszkowicz, Barry Penner
// COMP 5511 - Principles of Data Structures
// Fall 2023
// Assignment 1 Question 5

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LListMain {

    private static final String FNAME = "data.txt"; // expected file name
    private static final String PANNO = "annotate"; // pass an empty string to print with no annotation.
                                                    // pass string "annotate" to mark the head element of the output list.

    public static void main(String[] args) throws IOException {
        LList llist = new LList();
        run(llist);
        System.out.printf("End-of-run print call:\n");
        System.out.println(llist.toString(PANNO));
        // test(); // uncomment this method call to print a batch of test commands to stdout
    }

    public static void run(LList llist) throws IOException {
        /* iterates through a datafile line by line and pushes to / pops from a linked list 
        based on keyword commands in the datafile.
        If you're having path trouble, you can paste the datafile path below and comment out
        the getPath() method call.
        */
        // String fpath = "<PATH>"; // if needed, replace <PATH> with an absolute path as string
        int printCounter = 0;
        String fpath = getPath();   // if needed, comment out this line if hardcoding path as string
        FileReader freader = new FileReader(fpath);
        try {
            BufferedReader breader = new BufferedReader(freader);
            String line;
            String command = null;
            while ( (line = breader.readLine() ) != null) {
                // check for keywords INSERT and POP and handle appropriately
                if (line.contains("PUSH")) { // includes the INSERT with typo at line 63 of source datafile
                    command = "PUSH";
                    continue;
                } else if (line.contains("POP")) {
                    llist.pop();
                    continue;
                } else if (line.contains("PRINT")) {
                    printCounter++;
                    System.out.printf("print call %d:\n", printCounter);
                    System.out.println(llist.toString(PANNO));
                    continue;
                }
                // push names
                if (command.equals("PUSH")) {
                    llist.push(line);
                }
            }
        } catch (Exception e) {
            // generic and unhelpful, but necessary
            System.out.println("error reading file.");
        }
    }

    public static String getPath() {
        // get path to local data. Assumes data is in same folder as class, and
        // that the file is named "data.txt"
        String fname = FNAME;
        ClassLoader loader = LListMain.class.getClassLoader();
        String parent = String.format("%s", Paths.get(String.format("%s", loader.getResource("LListMain.class")).substring(5)).getParent());
        System.out.println(parent);
        String path = String.format("%s", Paths.get(parent, fname));
        return path;
    }

    public static void test() {
        // basic self-contained test method to test push/pop functionality
        LList llist = new LList();
        System.out.println("successfully instantiated llist.");
        System.out.println("length: " + llist.getLength());
        System.out.println(llist.toString(PANNO));
        System.out.println("pushing items...");
        llist.push("aaa");
        System.out.println("read after one push: ");
        System.out.println(llist.toString(PANNO));
        llist.push("bbb");
        llist.push("ccc");
        System.out.println("new length: " + llist.getLength());
        System.out.println("displaying list data: ");
        System.out.println(llist.toString(PANNO));
        System.out.println("one more push: ");
        llist.push("ddd");
        System.out.println("displaying list data: ");
        System.out.println(llist.toString(PANNO));
        System.out.println("two pops next: ");
        llist.pop();
        llist.pop();
        System.out.println("new length: " + llist.getLength());
        System.out.println(llist.toString(PANNO));
    }
}
