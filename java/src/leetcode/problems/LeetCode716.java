package leetcode.problems;


import common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/7 21:30
 */
public class LeetCode716 {

    class MaxStack {
        private final LinkedList<Node> list;
        private final TreeMap<Integer, List<Node>> treeMap;

        public MaxStack() {
            this.list = new LinkedList<>();
            this.treeMap = new TreeMap<>();
        }

        public void push(int x) {
            Node node = new Node(x);
            list.add(node);
            treeMap.computeIfAbsent(x, k -> new ArrayList<>()).add(node);
        }

        public int pop() {
            Node node = list.removeLast();
            List<Node> nodes = treeMap.get(node.val);
            int x = nodes.remove(nodes.size() - 1).val;
            if (nodes.isEmpty()) {
                treeMap.remove(node.val);
            }
            return x;
        }

        public int top() {
            return list.getLast().val;
        }

        public int peekMax() {
            return treeMap.lastKey();
        }

        public int popMax() {
            int x = peekMax();
            List<Node> nodes = treeMap.get(x);
            Node node = nodes.remove(nodes.size() - 1);
            if (nodes.isEmpty()) {
                treeMap.remove(x);
            }
            list.remove(node);
            return x;
        }
    }
}
