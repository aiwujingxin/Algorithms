package leetcode.problems;

import knowledge.datastructure.string.match.ACAutomaton;
import knowledge.datastructure.string.match.ACAutomaton.Node;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 23:51
 */
public class LeetCode1032 {

    class StreamChecker {
        private final ACAutomaton ac;
        private Node current;

        public StreamChecker(String[] words) {
            ac = new ACAutomaton();
            for (String word : words) {
                ac.insert(word);
            }
            ac.build();
            current = ac.root;
        }

        public boolean query(char letter) {
            int idx = letter - 'a';
            // 关键修正：确保 current.children[idx] 不为 null
            if (current.children[idx] == null) {
                current = ac.root; // 回退到根节点
                return false;
            }
            current = current.children[idx];
            // 检查当前节点是否是一个单词的结尾
            if (current.isEnd) {
                return true;
            }
            // 检查失败指针链上是否有单词结尾
            Node temp = current.fail;
            while (temp != null && temp != ac.root) {
                if (temp.isEnd) {
                    return true;
                }
                temp = temp.fail;
            }
            return false;
        }
    }
}
