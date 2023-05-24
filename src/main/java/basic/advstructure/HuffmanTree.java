package basic.advstructure;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 13:08
 * from gpt
 */
public class HuffmanTree {

    public static void main(String[] args) {
        char[] characters = {'A', 'B', 'C', 'D', 'E'};
        int[] frequencies = {5, 3, 8, 2, 6};

        HuffmanTree huffmanTree = new HuffmanTree();
        huffmanTree.buildTree(characters, frequencies);
        huffmanTree.printCodes();
    }

    private HuffmanNode root;

    public HuffmanTree() {
        this.root = null;
    }

    public void buildTree(char[] characters, int[] frequencies) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();

        for (int i = 0; i < characters.length; i++) {
            HuffmanNode node = new HuffmanNode(characters[i], frequencies[i]);
            pq.offer(node);
        }

        while (pq.size() > 1) {
            HuffmanNode leftNode = pq.poll();
            HuffmanNode rightNode = pq.poll();

            HuffmanNode parentNode = new HuffmanNode('\0', leftNode.frequency + rightNode.frequency);
            parentNode.left = leftNode;
            parentNode.right = rightNode;

            pq.offer(parentNode);
        }

        root = pq.poll();
    }

    public void printCodes() {
        printCodes(root, "");
    }

    private void printCodes(HuffmanNode node, String code) {
        if (node == null) {
            return;
        }

        if (node.character != '\0') {
            System.out.println(node.character + ": " + code);
        }

        printCodes(node.left, code + "0");
        printCodes(node.right, code + "1");
    }

    static class HuffmanNode implements Comparable<HuffmanNode> {
        char character;
        int frequency;
        HuffmanNode left;
        HuffmanNode right;

        public HuffmanNode(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(HuffmanNode other) {
            return this.frequency - other.frequency;
        }
    }
}
