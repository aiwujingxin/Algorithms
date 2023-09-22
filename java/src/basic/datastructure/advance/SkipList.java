package basic.datastructure.advance;


import leetcode.problems.LeetCode1206;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/23 11:47
 * @see LeetCode1206
 */

public class SkipList {

    private static final int DEFAULT_MAX_LEVEL = 32;
    Node head = new Node(null, DEFAULT_MAX_LEVEL);
    int curLevel = 1;

    public boolean search(int target) {
        Node searchNode = head;
        for (int i = curLevel - 1; i >= 0; i--) {
            searchNode = findClosest(searchNode, i, target);
            if (searchNode.next[i] != null && searchNode.next[i].value == target) {
                return true;
            }
        }
        return false;
    }

    public void add(int num) {
        int level = randomLevel();
        Node updateNode = head;
        Node newNode = new Node(num, level);
        for (int i = curLevel - 1; i >= 0; i--) {
            updateNode = findClosest(updateNode, i, num);
            if (i < level) {
                if (updateNode.next[i] == null) {
                    updateNode.next[i] = newNode;
                } else {
                    Node temp = updateNode.next[i];
                    updateNode.next[i] = newNode;
                    newNode.next[i] = temp;
                }
            }
        }
        if (level > curLevel) {
            for (int i = curLevel; i < level; i++) {
                head.next[i] = newNode;
            }
            curLevel = level;
        }
    }

    public boolean erase(int num) {
        boolean flag = false;
        Node searchNode = head;
        for (int i = curLevel - 1; i >= 0; i--) {
            searchNode = findClosest(searchNode, i, num);
            if (searchNode.next[i] != null && searchNode.next[i].value == num) {
                searchNode.next[i] = searchNode.next[i].next[i];
                flag = true;
            }
        }
        return flag;
    }

    private Node findClosest(Node node, int levelIndex, int value) {
        while ((node.next[levelIndex]) != null && value > node.next[levelIndex].value) {
            node = node.next[levelIndex];
        }
        return node;
    }

    private static int randomLevel() {
        int level = 1;
        double DEFAULT_P_FACTORY = 0.25;
        while (Math.random() < DEFAULT_P_FACTORY && level < DEFAULT_MAX_LEVEL) {
            level++;
        }
        return level;
    }

    static class Node {
        Integer value;
        Node[] next;

        public Node(Integer value, int size) {
            this.value = value;
            this.next = new Node[size];
        }
    }
}
