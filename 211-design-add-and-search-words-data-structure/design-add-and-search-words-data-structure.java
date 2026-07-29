class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    Node() {
    }

    boolean isContains(char c) {
        return links[c - 'a'] != null;
    }

    void put(char c, Node node) {
        links[c - 'a'] = node;
    }

    Node get(char c) {
        return links[c - 'a'];
    }

    void setEnd() {
        flag = true;
    }
    boolean isEnd()
    {
        return flag;
    }

}

class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                continue;
            }
            if (!node.isContains(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;
        return search(word,node,0,2);
    }
    private boolean search(String word,Node node,int index,int dots)
    {
        if(index == word.length())
        {
            return node.isEnd();
        }

        char c = word.charAt(index);
        if(c=='.')
        {
            if(dots<=0)
            {
                return false;
            }

            for(char ch ='a';ch<='z';ch++)
            {
                if(node.isContains(ch))
                {
                    if(search(word,node.get(ch),index+1,dots-1))
                    {
                        return true;
                    }
                }
            }
            return false;
        }
        else
        {
            if(!node.isContains(c))
            {
                return false;
            }
            return search(word,node.get(c),index+1,dots);
        }
    }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */