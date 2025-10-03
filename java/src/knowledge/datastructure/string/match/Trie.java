package knowledge.datastructure.string.match;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 21:55
 */
public class Trie {

    public static class Node {
        public Node[] children = new Node[26];
        public boolean isEnd = false;
        public int cnt;
    }

    public Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Node();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
        node.cnt++;
    }

    public boolean search(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }

    public String findRoot(String word) {
        StringBuilder sb = new StringBuilder();
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node != null && !node.isEnd) {
                sb.append(word.charAt(i));
                node = node.children[word.charAt(i) - 'a'];
            }
        }
        return node == null ? word : sb.toString();
    }

    public boolean searchUpdate(String searchWord, Node node, int index, boolean modified) {
        if (index == searchWord.length()) {
            return modified && node.isEnd;
        }
        int idx = searchWord.charAt(index) - 'a';
        if (node.children[idx] != null) {
            if (searchUpdate(searchWord, node.children[idx], index + 1, modified)) {
                return true;
            }
        }
        if (modified) {
            return false;
        }
        for (int i = 0; i < 26; ++i) {
            if (i != idx && node.children[i] != null) {
                if (searchUpdate(searchWord, node.children[i], index + 1, true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int contains(String s, int left, int right) {
        Node cur = root;
        int index;
        for (index = left; index <= right; index++) {
            if (cur.children[s.charAt(index) - 'a'] == null) {
                return -1;
            }
            cur = cur.children[s.charAt(index) - 'a'];
            if (cur.isEnd) {
                return index;
            }
        }
        return -1;
    }

    int cnt;

    public int searchSubSeq(String word) {
        dfs(word, 0, root);
        return cnt;
    }

    public void dfs(String word, int index, Node node) {
        if (node.cnt > 0) {
            cnt += node.cnt;
        }
        for (int i = 0; i < node.children.length; i++) {
            Node next = node.children[i];
            if (next != null) {
                int indexOf = word.indexOf(i + 'a', index);
                if (indexOf != -1) {
                    dfs(word, indexOf + 1, next);
                }
            }
        }
    }
}
