package basic.algorithm.search.adv;

import java.util.ArrayList;
import java.util.List;

public class IDSSearch {

    public static boolean iterativeDeepeningSearch(Node root, int target) {
        for (int depth = 0; depth < Integer.MAX_VALUE; depth++) {
            if (depthLimitedSearch(root, target, depth)) {
                return true;  // Solution found
            }
        }
        return false;  // Solution not found
    }

    private static boolean depthLimitedSearch(Node node, int target, int depth) {
        if (node.value == target) {
            return true;  // Target found
        }

        if (depth == 0) {
            return false;  // Reached depth limit
        }

        for (Node child : node.children) {
            if (depthLimitedSearch(child, target, depth - 1)) {
                return true;  // Solution found in child subtree
            }
        }

        return false;  // Solution not found in this subtree
    }

    public static void main(String[] args) {
        // Create a sample tree
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        root.addChild(node2);
        root.addChild(node3);
        node2.addChild(node4);
        node3.addChild(node5);

        int target = 5;
        boolean found = iterativeDeepeningSearch(root, target);
        if (found) {
            System.out.println("Target " + target + " found!");
        } else {
            System.out.println("Target " + target + " not found!");
        }
    }

    private static class Node {
        int value;
        List<Node> children;

        Node(int value) {
            this.value = value;
            this.children = new ArrayList<>();
        }

        void addChild(Node child) {
            children.add(child);
        }
    }
}
