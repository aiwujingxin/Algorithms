package knowledge.datastructure.other.impl;

import java.util.Random;

/**
 * Skip List (跳表)
 * A probabilistic data structure that allows O(log N) average time for search, insert, and delete operations.
 */
public class SkipList {
    private static final int MAX_LEVEL = 16;
    private static final double P = 0.5;

    private class Node {
        int val;
        Node[] forward;

        Node(int val, int level) {
            this.val = val;
            this.forward = new Node[level];
        }
    }

    private Node head;
    private int currentLevel;
    private Random random;

    /**
     * Initializes an empty Skip List.
     */
    public SkipList() {
        head = new Node(-1, MAX_LEVEL);
        currentLevel = 1;
        random = new Random();
    }

    private int randomLevel() {
        int level = 1;
        while (random.nextDouble() < P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    /**
     * Searches for a value in the Skip List.
     *
     * @param target The value to search for
     * @return true if the value exists, false otherwise
     */
    public boolean search(int target) {
        Node curr = head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < target) {
                curr = curr.forward[i];
            }
        }
        curr = curr.forward[0];
        return curr != null && curr.val == target;
    }

    /**
     * Inserts a value into the Skip List.
     *
     * @param num The value to insert
     */
    public void add(int num) {
        Node[] update = new Node[MAX_LEVEL];
        Node curr = head;

        for (int i = currentLevel - 1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }

        int level = randomLevel();
        if (level > currentLevel) {
            for (int i = currentLevel; i < level; i++) {
                update[i] = head;
            }
            currentLevel = level;
        }

        Node newNode = new Node(num, level);
        for (int i = 0; i < level; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    /**
     * Erases a value from the Skip List if it exists.
     *
     * @param num The value to remove
     * @return true if removed successfully, false if not found
     */
    public boolean erase(int num) {
        Node[] update = new Node[MAX_LEVEL];
        Node curr = head;

        for (int i = currentLevel - 1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }

        curr = curr.forward[0];

        if (curr != null && curr.val == num) {
            for (int i = 0; i < currentLevel; i++) {
                if (update[i].forward[i] != curr) {
                    break;
                }
                update[i].forward[i] = curr.forward[i];
            }

            while (currentLevel > 1 && head.forward[currentLevel - 1] == null) {
                currentLevel--;
            }
            return true;
        }
        return false;
    }
}
