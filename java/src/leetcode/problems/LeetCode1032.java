package leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 23:51
 */
public class LeetCode1032 {

    class StreamChecker {
        TrieNode root;
        TrieNode temp;

        public StreamChecker(String[] words) {
            root = new TrieNode();
            root.insert(root, words);
            Queue<TrieNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TrieNode u = queue.poll();
                u.isEnd = (u.isEnd || u.fail.isEnd);
                for (int i = 0; i < 26; i++) {
                    if (u.children[i] != null) {
                        u.children[i].fail = u.fail == null ? root : u.fail.children[i];
                        queue.offer(u.children[i]);
                    } else {
                        u.children[i] = u.fail == null ? root : u.fail.children[i];
                    }
                }
            }
            temp = root;
        }

        public boolean query(char letter) {
            temp = temp.children[letter - 'a'];
            return temp.isEnd;
        }

        class TrieNode {
            TrieNode[] children;
            boolean isEnd;
            TrieNode fail;

            public TrieNode() {
                children = new TrieNode[26];
            }

            public void insert(TrieNode root, String[] words) {
                for (String word : words) {
                    TrieNode cur = root;
                    for (int i = 0; i < word.length(); i++) {
                        int index = word.charAt(i) - 'a';
                        if (cur.children[index] == null) {
                            cur.children[index] = new TrieNode();
                        }
                        cur = cur.children[index];
                    }
                    cur.isEnd = true;
                }
            }
        }
    }
}
