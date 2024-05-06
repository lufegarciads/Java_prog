package COMP5511_A04;
import java.io.*;
import java.net.URL;
import java.util.*;

public class ParseText {
    public static List<String> processDocument(String fileName) throws IOException {
        List<String> paragraphs = new ArrayList<>();
        URL documentUrl = ParseText.class.getClassLoader().getResource(fileName);
        if (documentUrl == null) {
            System.err.println("Document file not found: " + fileName);
            return paragraphs;
        }

        File documentFile = new File(documentUrl.getFile());

        try (BufferedReader reader = new BufferedReader(new FileReader(documentFile))) {
            String line;
            StringBuilder paragraph = new StringBuilder();
            int lineCount = 0;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                if (lineCount <= 10) continue; // Pula as primeiras 10 linhas

                if (!line.trim().isEmpty()) {
                    paragraph.append(line).append(" ");
                } else if (paragraph.length() > 0) {
                    paragraphs.add(paragraph.toString().trim());
                    paragraph = new StringBuilder();
                }
            }

            if (paragraph.length() > 0) {
                paragraphs.add(paragraph.toString().trim());
            }
        }

        return paragraphs;
    }

    public static Set<String> getStopWords() {
        Set<String> stopwords = new HashSet<>();
        String stopwordsFileName = "Some-noise-words.txt"; // Nome do arquivo de stopwords

        URL resourceUrl = ParseText.class.getClassLoader().getResource(stopwordsFileName);
        if (resourceUrl == null) {
            System.err.println("Stopwords file not found: " + stopwordsFileName);
            return stopwords;
        }

        File stopwordsFile = new File(resourceUrl.getFile());

        try (BufferedReader reader = new BufferedReader(new FileReader(stopwordsFile))) {
            String word;
            while ((word = reader.readLine()) != null) {
                stopwords.add(word.trim().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stopwords;
    }
}
