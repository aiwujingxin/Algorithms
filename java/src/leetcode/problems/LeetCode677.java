package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 22:37
 */
public class LeetCode677 {
    class MapSum {

        Trie trie;

        public MapSum() {
            trie = new Trie();
        }

        public void insert(String key, int val) {
            trie.insert(key, val);
        }

        public int sum(String prefix) {
            if (!trie.startsWith(prefix)) {
                return 0;
            }
            Trie.Node node = trie.root;
            for (int i = 0; i < prefix.length(); i++) {
                node = node.children[prefix.charAt(i) - 'a'];
            }
            return dfs(node);
        }

        public int dfs(Trie.Node root) {
            if (root == null) {
                return 0;
            }
            int res = root.val;
            for (int i = 0; i < root.children.length; i++) {
                res += dfs(root.children[i]);
            }
            return res;
        }

        static class Trie {
            Node root;

            public Trie() {
                root = new Node();
            }

            public void insert(String word, int val) {
                if (word == null || word.isEmpty()) {
                    return;
                }
                Node node = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (node.children[c - 'a'] == null) {
                        node.children[c - 'a'] = new Node();
                    }
                    node = node.children[c - 'a'];
                }
                node.isEnd = true;
                node.val = val;
            }

            public boolean search(String word) {
                Node node = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (node.children[c - 'a'] == null) {
                        return false;
                    }
                    node = node.children[c - 'a'];
                }
                return node.isEnd;
            }

            public boolean startsWith(String prefix) {
                Node node = root;
                for (int i = 0; i < prefix.length(); i++) {
                    char c = prefix.charAt(i);
                    if (node.children[c - 'a'] == null) {
                        return false;
                    }
                    node = node.children[c - 'a'];
                }
                return true;
            }

            static class Node {
                public Node[] children;
                public int val;
                public boolean isEnd;

                public Node() {
                    this.children = new Node[26];
                    this.isEnd = false;
                }
            }
        }
    }
}
