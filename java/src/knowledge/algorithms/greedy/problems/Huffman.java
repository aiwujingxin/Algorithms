package knowledge.algorithms.greedy.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 4/20/25 23:31
 */
public class Huffman {

    // Build frequency map from input string
    private static Map<Character, Integer> buildFrequencyMap(String data) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : data.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }

    // Build Huffman Tree from frequency map
    private static HuffmanNode buildHuffmanTree(Map<Character, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();

        // Create a leaf node for each character and add to priority queue
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        // Combine nodes until there's only one node left (the root)
        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            // Create a new internal node with these two nodes as children
            HuffmanNode internalNode = new HuffmanNode('\0', left.frequency + right.frequency, left, right);
            priorityQueue.add(internalNode);
        }

        return priorityQueue.poll(); // The root of the Huffman tree
    }

    // Build code map (character to its Huffman code)
    private static Map<Character, String> buildCodeMap(HuffmanNode root) {
        Map<Character, String> codeMap = new HashMap<>();
        buildCodeMapHelper(root, "", codeMap);
        return codeMap;
    }

    private static void buildCodeMapHelper(HuffmanNode node, String code, Map<Character, String> codeMap) {
        if (node.isLeaf()) {
            codeMap.put(node.character, code);
            return;
        }

        buildCodeMapHelper(node.left, code + "0", codeMap);
        buildCodeMapHelper(node.right, code + "1", codeMap);
    }

    // Encode the input data using Huffman codes
    public static String encode(String data, Map<Character, String> codeMap) {
        StringBuilder encodedData = new StringBuilder();
        for (char c : data.toCharArray()) {
            encodedData.append(codeMap.get(c));
        }
        return encodedData.toString();
    }

    // Decode the encoded string using Huffman tree
    public static String decode(String encodedData, HuffmanNode root) {
        StringBuilder decodedData = new StringBuilder();
        HuffmanNode current = root;

        for (int i = 0; i < encodedData.length(); i++) {
            char bit = encodedData.charAt(i);
            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current.isLeaf()) {
                decodedData.append(current.character);
                current = root;
            }
        }

        return decodedData.toString();
    }

    // Node class for Huffman Tree
    static class HuffmanNode implements Comparable<HuffmanNode> {
        char character;
        int frequency;
        HuffmanNode left, right;

        public HuffmanNode(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }

        public HuffmanNode(char character, int frequency, HuffmanNode left, HuffmanNode right) {
            this.character = character;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        // For leaf nodes
        public boolean isLeaf() {
            return left == null && right == null;
        }

        @Override
        public int compareTo(HuffmanNode other) {
            return this.frequency - other.frequency;
        }
    }

    public static void main(String[] args) {
        String testData = "Huffman coding is a data compression algorithm.";

        // Step 1: Build frequency map
        Map<Character, Integer> frequencyMap = buildFrequencyMap(testData);
        System.out.println("Frequency Map: " + frequencyMap);

        // Step 2: Build Huffman tree
        HuffmanNode huffmanTree = buildHuffmanTree(frequencyMap);

        // Step 3: Build code map
        Map<Character, String> codeMap = buildCodeMap(huffmanTree);
        System.out.println("Huffman Codes: " + codeMap);

        // Step 4: Encode the data
        String encodedData = encode(testData, codeMap);
        System.out.println("Encoded data: " + encodedData);

        // Step 5: Decode the data
        String decodedData = decode(encodedData, huffmanTree);
        System.out.println("Decoded data: " + decodedData);

        // Verify
        System.out.println("Original and decoded data match: " + testData.equals(decodedData));
    }
}
