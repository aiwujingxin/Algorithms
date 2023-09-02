package leetcode;

/**
 * @author jingxinwu
 * @date 2021-08-18 12:41 上午
 */
public class LeetCode208 {

    class Trie {

        final private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.childs[ch - 'a'] == null) {
                    curr.childs[ch - 'a'] = new Node();
                }
                curr = curr.childs[ch - 'a'];
            }

            curr.isEnd = true;
        }

        public boolean search(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.childs[ch - 'a'] == null) {
                    return false;
                }
                curr = curr.childs[ch - 'a'];
            }

            return curr.isEnd;
        }

        public boolean startsWith(String prefix) {
            Node curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                if (curr.childs[ch - 'a'] == null) {
                    return false;
                }
                curr = curr.childs[ch - 'a'];
            }

            return true;
        }

        static class Node {

            Node[] childs;
            boolean isEnd;

            Node() {
                childs = new Node[26];
                isEnd = false;
            }
        }
    }
}
