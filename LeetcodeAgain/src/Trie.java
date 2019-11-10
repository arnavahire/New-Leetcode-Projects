public class Trie {
    class TrieNode {
        char val;
        boolean isWord = false;
        TrieNode[] alphabets = new TrieNode[26];
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        root.val = '-';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] wordArray = word.toCharArray();
        TrieNode current = root;
        for(int i=0;i<wordArray.length;i++)
        {
            if(current.alphabets[wordArray[i]-'a']==null)
            {
                TrieNode newNode = new TrieNode();
                newNode.val =  wordArray[i];
                current.alphabets[wordArray[i]-'a'] = newNode;
                if(i==wordArray.length-1)
                    newNode.isWord = true;
                current = newNode;
            }
            else
            {
                if(i==wordArray.length-1)
                    current.alphabets[wordArray[i]-'a'].isWord = true;
                else
                    current = current.alphabets[wordArray[i]-'a'];
            }
        }

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] wordArray = word.toCharArray();
        TrieNode current = root;

        for(int i=0;i<wordArray.length;i++)
        {
            if(current.alphabets[wordArray[i]-'a']==null)
                return false;
            else
            {
                if(current.alphabets[wordArray[i]-'a']!=null && (i==wordArray.length-1) && (current.alphabets[wordArray[i]-'a'].isWord==true))
                    return true;
                else
                    current = current.alphabets[wordArray[i]-'a'];
            }
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] prefixArray = prefix.toCharArray();
        TrieNode current = root;

        for(int i=0;i<prefixArray.length;i++)
        {
            if(current.alphabets[prefixArray[i]-'a']==null)
                return false;
            else
            {
                if(current.alphabets[prefixArray[i]-'a']!=null && (i==prefixArray.length-1))
                    return true;
                current = current.alphabets[prefixArray[i]-'a'];
            }
        }
        return false;
    }
}
