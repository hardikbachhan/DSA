class Trie {
    public class TrieNode {
        private char ch;
        private TrieNode[] children;
        private boolean endOfWord;
        
        TrieNode(char ch) {
            this.ch = ch;
            this.children = new TrieNode[26];
            this.endOfWord = false;
        }
        
        public TrieNode getChild(char ch) {
            return this.children[ch - 'a'];
        }
        
        public boolean hasChild(char ch) {
            return this.children[ch - 'a'] != null;
        }
        
        public TrieNode addChild(char ch) {
            if (this.children[ch - 'a'] != null) {
                return getChild(ch);
            }
            this.children[ch - 'a'] = new TrieNode(ch);
            return this.children[ch - 'a'];
        }
        
        public boolean isEndOfWord() {
            return this.endOfWord;
        }
        
        public void markEndOfWord() {
            this.endOfWord = true;
        }
        
        public void unmarkEndOfWord() {
            this.endOfWord = false;
        }
    }
    
    private TrieNode root;
    
    public Trie() {
        this.root = new TrieNode('-');
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.hasChild(ch) == false) {
                curr = curr.addChild(ch);
            } else {
                curr = curr.getChild(ch);
            }
        }
        curr.markEndOfWord();
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.hasChild(ch) == false) {
                return false;
            } 
            curr = curr.getChild(ch);
        }
        return curr.isEndOfWord();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (curr.hasChild(ch) == false) {
                return false;
            }
            curr = curr.getChild(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */