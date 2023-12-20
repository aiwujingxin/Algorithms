package basic.datastructure.string.impl;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 23:48
 * @description  AC自动机
 * @link <a href="https://www.youtube.com/watch?v=D2jwopA4-P0"></a>
 */
/*
 * AC自动机（Aho-Corasick
 * Automaton）是一种多模式字符串匹配算法，用于在一个主文本中同时查找多个模式字符串的出现位置。它是由Alfred
 * V. Aho和Margaret J. Corasick在1975年提出的。
 *
 * AC自动机的基本思想是构建一个有限状态机，其中每个状态代表着模式字符串的匹配状态。这个有限状态机通常使用字典树（Trie）的数据结构来实现。
 *
 * 构建AC自动机的过程分为两个主要步骤：
 *
 * 1. 构建Trie树：将所有模式字符串构建成一个字典树，每个节点代表一个字符，从根节点到叶子节点表示一个完整的模式字符串。
 *
 * 2. 添加失败指针（Failure
 * Link）：在Trie树上为每个节点添加一个指向失败节点的指针。失败节点表示在当前节点无法匹配字符时应该转移到的下一个匹配位置。
 *
 * 构建完成后，AC自动机可以在主文本上进行匹配操作：
 *
 * 1. 初始化状态为根节点。
 *
 * 2. 从主文本的第一个字符开始，依次遍历字符。
 *
 * 3. 对于每个字符，根据当前状态和字符，按照Trie树的转移规则，将状态转移到下一个匹配位置。
 *
 * 4. 如果无法进行转移，则根据失败指针，将状态转移到对应的失败节点。
 *
 * 5. 检查当前状态是否为一个模式字符串的终止状态，如果是，则找到了一个匹配。
 *
 * AC自动机的优点是可以在线性时间内完成多模式字符串的匹配，而不受模式串数量的影响。它可以在O(n+m)
 * 的时间复杂度内，在主文本长度为n，模式字符串总长度为m的情况下，完成所有模式字符串的匹配。
 *
 * AC自动机在字符串匹配领域有广泛的应用，例如敏感词过滤、关键词匹配、DNA序列分析等。
 */
class ACAutomaton {
    private final Node root;

    public ACAutomaton() {
        root = new Node('\0'); // 根节点
    }

    public void addPattern(String pattern) {
        Node current = root;

        for (char ch : pattern.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                Node newNode = new Node(ch);
                newNode.parent = current;
                current.children.put(ch, newNode);
            }

            current = current.children.get(ch);
        }

        current.isEndOfWord = true;
    }

    public void buildFailureLinks() {
        Queue<Node> queue = new LinkedList<>();
        root.failLink = null;
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Node child : current.children.values()) {
                queue.offer(child);

                Node failLink = current.failLink;
                while (failLink != null && !failLink.children.containsKey(child.ch)) {
                    failLink = failLink.failLink;
                }

                child.failLink = failLink != null ? failLink.children.get(child.ch) : root;
            }
        }
    }

    public List<String> searchPatterns(String text) {
        List<String> matches = new ArrayList<>();
        Node current = root;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            while (current != null && !current.children.containsKey(ch)) {
                current = current.failLink;
            }

            if (current == null) {
                current = root;
                continue;
            }

            current = current.children.get(ch);

            if (current.isEndOfWord) {
                matches.add(getMatchedString(current));
            }

            Node temp = current;
            while (temp.failLink != null) {
                temp = temp.failLink;

                if (temp.isEndOfWord) {
                    matches.add(getMatchedString(temp));
                }
            }
        }

        return matches;
    }

    private String getMatchedString(Node node) {
        StringBuilder sb = new StringBuilder();
        Node temp = node;

        while (temp != root) {
            sb.insert(0, temp.ch);
            temp = temp.parent;
        }

        return sb.toString();
    }

    static class Node {
        char ch;
        boolean isEndOfWord;
        Node parent;
        Node failLink;
        Map<Character, Node> children;

        Node(char ch) {
            this.ch = ch;
            this.isEndOfWord = false;
            this.parent = null;
            this.failLink = null;
            this.children = new HashMap<>();
        }
    }

    public static class Main {
        public static void main(String[] args) {
            ACAutomaton acAutomaton = new ACAutomaton();

            // 添加模式字符串
            acAutomaton.addPattern("he");
            acAutomaton.addPattern("she");
            acAutomaton.addPattern("his");
            acAutomaton.addPattern("hers");

            // 构建失败指针
            acAutomaton.buildFailureLinks();

            // 搜索模式字符串
            String text = "ushers";
            List<String> matches = acAutomaton.searchPatterns(text);

            System.out.println("在文本 '" + text + "' 中找到的匹配:");
            for (String match : matches) {
                System.out.println(match);
            }
        }
    }
}
