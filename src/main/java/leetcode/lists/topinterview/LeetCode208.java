package leetcode.lists.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/27 22:51
 */
public class LeetCode208 {

    //copy
    class Trie {

        class Node {
            Node[] childs;
            boolean isEnd;

            Node() {
                childs = new Node[26];
                isEnd = false;
            }
        }

        final Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
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
            if (word == null || word.length() == 0) {
                return true;
            }
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.childs[ch - 'a'] == null) {
                    return false;
                }
                curr = curr.childs[ch - 'a'];
            }
            //important
            return curr.isEnd;
        }

        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0) {
                return true;
            }
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
    }
}
