import java.util.HashMap;

public class Trie {
    TrieNode root = new TrieNode();

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode tmp = root;
        for (char ch : word.toCharArray()) {
            if (!tmp.children.containsKey(ch)) {
                tmp.children.put(ch, new TrieNode());
            }
            tmp = tmp.children.get(ch);
        }
        tmp.isStringEnd = true; // 标志有一个字符串，在这个节点结束。
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode tmp = root;
        for (char ch : word.toCharArray()) {
            if (!tmp.children.containsKey(ch)) return false;
            tmp = tmp.children.get(ch);
        }
        return tmp.isStringEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // 最后的节点不需要是叶子节点！
        TrieNode tmp = root;
        for (char ch : prefix.toCharArray()) {
            if (!tmp.children.containsKey(ch)) return false;
            tmp = tmp.children.get(ch);
        }
        return true;
    }
}


class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>(); // 边
    boolean isStringEnd = false;

    TrieNode() {

    }

    public boolean isEnd() {
        return isStringEnd;
    }

    public TrieNode get(char ch) {
        if (children.containsKey(ch)) return children.get(ch);
        return null;
    }
}

// 下面的Trie树，只适用于小写字符




/*
class TrieNode {

    // R links to node children
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

public class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    // search a prefix or whole key in trie and
    // returns the node where search ends
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
 */
