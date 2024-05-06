package COMP5511_A04;
import java.util.*;

public class TrieNode {
    private Map<Character, TrieNode> children = new HashMap<>();
    private boolean isEndOfWord;
    private Set<Integer> paragraphNumbers = new HashSet<>();

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void addParagraphNumber(int paragraphNumber) {
        paragraphNumbers.add(paragraphNumber);
    }

    public Set<Integer> getParagraphNumbers() {
        return paragraphNumbers;
    }
}