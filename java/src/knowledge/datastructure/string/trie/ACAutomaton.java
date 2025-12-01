package knowledge.datastructure.string.trie;

import leetcode.problems.LeetCode1032;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 23:48
 * @description AC自动机 多模式字符串匹配算法. Trie树与KMP思想的结合。用于在一个文本串中同时查找多个模式串。是多模式匹配的标准解决方案。
 * 原理 在Trie树上构建两类边 回跳边和转移边. 扫描主串匹配
 * @link <a href="https://www.youtube.com/watch?v=D2jwopA4-P0"></a>
 * 时间复杂度 O(n+m)
 * @see LeetCode1032
 */
public class ACAutomaton {

    public Node root;

    public ACAutomaton() {
        root = new Node('\0');
    }

    public void build() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node u = q.poll();
            for (int i = 0; i < 26; i++) {
                if (u.children[i] != null) {
                    u.children[i].fail = u.fail == null ? root : u.fail.children[i];
                    q.add(u.children[i]);
                } else {
                    u.children[i] = u.fail == null ? root : u.fail.children[i];
                }
            }
        }
    }

    public void insert(String pattern) {
        Node cur = root;
        for (char ch : pattern.toCharArray()) {
            int index = ch - 'a';
            if (cur.children[index] == null) {
                Node child = new Node(ch);
                child.pa = cur;
                cur.children[index] = child;
            }
            cur = cur.children[index];
        }
        cur.isEnd = true;
    }

    public List<String> query(String text) {
        List<String> matches = new ArrayList<>();
        Node node = root;
        for (int i = 0; i < text.length(); i++) {
            int index = text.charAt(i) - 'a';
            if (node != null && node.children[index] == null) {
                node = node.fail;
            }
            if (node == null) {
                node = root;
                continue;
            }
            node = node.children[index];
            if (node.isEnd) {
                matches.add(get(node));
            }
            Node temp = node;
            while (temp.fail != null) {
                temp = temp.fail;
                if (temp.isEnd) {
                    matches.add(get(temp));
                }
            }
        }
        return matches;
    }

    private String get(Node node) {
        StringBuilder sb = new StringBuilder();
        Node t = node;
        while (t != root) {
            sb.insert(0, t.ch);
            t = t.pa;
        }
        return sb.toString();
    }

    public static class Node {
        public char ch;
        public Node pa;
        public Node fail;
        public Node[] children;
        public boolean isEnd;

        Node(char ch) {
            this.ch = ch;
            this.children = new Node[26];
        }
    }
}