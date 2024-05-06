package COMP5511_A04;
import java.util.*;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word, int paragraphNumber) {
        TrieNode current = root;
        word = word.toLowerCase();
    
        for (char ch : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(ch, c -> new TrieNode());
        }
    
        current.setEndOfWord(true);
        current.addParagraphNumber(paragraphNumber);
    }
    
    public Set<Integer> search(String word) {
        TrieNode current = root;
        word = word.toLowerCase();
    
        for (char ch : word.toCharArray()) {
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return Collections.emptySet();
            }
            current = node;
        }
    
        if (current.isEndOfWord()) {
            return current.getParagraphNumbers();
        }
    
        return Collections.emptySet();
    }    
}
