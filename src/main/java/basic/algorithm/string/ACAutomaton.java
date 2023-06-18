package basic.algorithm.string;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 23:48
 * <a href="https://www.youtube.com/watch?v=D2jwopA4-P0"></a>
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

    static class Main {
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

