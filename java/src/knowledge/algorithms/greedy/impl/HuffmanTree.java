package knowledge.algorithms.greedy.impl;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 13:08
 * @description 哈夫曼树
 *       from gpt
 */
public class HuffmanTree {

    private Node root;

    public HuffmanTree() {
        this.root = null;
    }

    public static void main(String[] args) {
        char[] characters = { 'A', 'B', 'C', 'D', 'E' };
        int[] frequencies = { 5, 3, 8, 2, 6 };

        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.buildTree(characters, frequencies);
        huffmanTree.printCodes();
    }

    public void buildTree(char[] characters, int[] frequencies) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < characters.length; i++) {
            Node node = new Node(characters[i], frequencies[i]);
            pq.offer(node);
        }

        while (pq.size() > 1) {
            Node leftNode = pq.poll();
            Node rightNode = pq.poll();

            Node parentNode = new Node('\0', leftNode.frequency + rightNode.frequency);
            parentNode.left = leftNode;
            parentNode.right = rightNode;

            pq.offer(parentNode);
        }

        root = pq.poll();
    }

    public void printCodes() {
        printCodes(root, "");
    }

    private void printCodes(Node node, String code) {
        if (node == null) {
            return;
        }

        if (node.character != '\0') {
            System.out.println(node.character + ": " + code);
        }

        printCodes(node.left, code + "0");
        printCodes(node.right, code + "1");
    }

    static class Node implements Comparable<Node> {
        char character;
        int frequency;
        Node left;
        Node right;

        public Node(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node other) {
            return this.frequency - other.frequency;
        }
    }
}
