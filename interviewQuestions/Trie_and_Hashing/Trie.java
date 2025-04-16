package interviewQuestions.Trie_and_Hashing;

// ⚡ Problem  Name: Implement Trie (Prefix Tree)



// 🧾 Problem Statement:
// Implement a trie with methods:
//      insert(String word)
//      search(String word)
//      startsWith(String prefix)



// 🧠 Approach:
// Use a TrieNode class where each node holds a map/array 
// of children and a boolean isEndOfWord.





// ✅ Visual Example:
// Inserting: "apple", then "app"
//      root
//      |
//      a
//      |
//      p
//      |
//      p
//      |
//      l
//      |
//      e (isEnd)

// After inserting "app":
//        root
//        |
//        a
//        |
//        p
//        |
//        p (isEnd)
//        |
//        l
//        |
//        e (isEnd)




class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (node.children[i] == null)
                node.children[i] = new TrieNode();
            node = node.children[i];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (node.children[i] == null) return null;
            node = node.children[i];
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println(trie.search("app"));     // true
    }
}

// 🖨️ Output:
// true   // search("apple")
// false  // search("app")
// true   // startsWith("app")
// true   // search("app") after insert


// ⏱️ Complexity:
// Time: O(m) per operation (m = length of word)

// Space: O(26 * m * n) (n = words inserted)