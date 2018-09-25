public class WordDictionary {


    Trie trie = null;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        this.trie = new Trie();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        trie.insert(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        TrieNode root = trie.root;
        return search(word, root);
    }

    public boolean search(String str, TrieNode node) {
        if (str.length() == 0 && node.isEnd()) return true;
        if(str.length()==0) return false;
        if (str.charAt(0) == '.') {
            TrieNode tmp = node;
            for (char ch = 'a'; ch <= 'z'; ++ch) {
                tmp = node.get(ch);
                if (tmp != null && search(str.substring(1), tmp))
                    return true;
            }
            return false;
        } else {
            return node.get(str.charAt(0)) != null && search(str.substring(1), node.get(str.charAt(0)));
        }
    }
}