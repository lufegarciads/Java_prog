import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Name of the document file
            String documentFileName = "The_State_of_Data_Final.txt";

            // Process the document
            List<String> paragraphs = ParseText.processDocument(documentFileName);
            System.out.println("Number of paragraphs processed: " + paragraphs.size());

            // Get stopwords
            Set<String> stopwords = ParseText.getStopWords();
            System.out.println("Number of stopwords loaded: " + stopwords.size());

            // Here, you can add more logic, such as building the Trie, performing searches, etc.

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
