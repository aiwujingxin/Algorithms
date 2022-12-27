package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/27 14:01
 */

//https://leetcode.com/problems/find-median-from-data-stream/solutions/499243/java-2-methods-explained-avl-heap/
public class LeetCode295_avl_tree {
    class MedianFinder {

        AVL avl;

        public MedianFinder() {
            avl = new AVL();
        }

        public void addNum(int num) {
            avl.insert(num);
        }

        public double findMedian() {
            return avl.findMedian();
        }
    }

    static class Node {
        int key;
        int freq; //duplicates are allowed in stream
        int lcount; // number of items in left subtree
        int rcount; // number of items in right subtree
        int height; // height for avl operations
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
            height = 1;
            left = right = null;
            lcount = rcount = 0;
            freq = 1;
        }
    }

    //>>>>>>>>>>>AVL>>>>>>>>>>>>>>>
    static class AVL {
        Node root;
        int size;

        AVL() {
            size = 0;
            root = null;
        }

        void insert(int key) {
            root = insertHelper(root, key);
        }

        Node leftR(Node x) {
            Node y = x.right;
            Node T2 = y.left;

            // Perform rotation
            y.left = x;
            x.right = T2;

            // Update heights
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;

            // update count
            x.rcount = (T2 != null) ? T2.lcount + T2.rcount + T2.freq : 0;
            y.lcount = x.lcount + x.rcount + x.freq;

            // Return new root
            return y;
        }

        Node rightR(Node y) {
            Node x = y.left;
            Node T2 = x.right;

            // Perform rotation
            x.right = y;
            y.left = T2;

            // Update heights
            y.height = Math.max(height(y.left), height(y.right)) + 1;
            x.height = Math.max(height(x.left), height(x.right)) + 1;

            // update count
            y.lcount = (T2 != null) ? T2.lcount + T2.rcount + T2.freq : 0;
            x.rcount = y.lcount + y.rcount + y.freq;

            // Return new root
            return x;
        }

        int getBalance(Node root) {
            if (root == null)
                return 0;
            return height(root.left) - height(root.right);
        }

        int height(Node root) {
            if (root == null)
                return 0;
            return root.height;
        }

        Node insertHelper(Node root, int key) {
            // insert in tree
            // increment size
            if (root == null) {
                size++;
                return new Node(key);
            }

            if (key < root.key) {
                root.left = insertHelper(root.left, key);
                root.lcount++;
            } else if (key > root.key) {
                root.right = insertHelper(root.right, key);
                root.rcount++;
            } else {
                root.freq++;
                size++;
                return root;
            }

            // insertion is done, update height and check for balancing factor
            root.height = 1 + Math.max(height(root.left), height(root.right));

            int balance = getBalance(root);

            // If this node becomes unbalanced, then there
            // are 4 cases Left Left Case
            if (balance > 1 && key < root.left.key)
                return rightR(root);

            // Right Right Case
            if (balance < -1 && key > root.right.key)
                return leftR(root);

            // Left Right Case
            if (balance > 1 && key > root.left.key) {
                root.left = leftR(root.left);
                return rightR(root);
            }

            // Right Left Case
            if (balance < -1 && key < root.right.key) {
                root.right = rightR(root.right);
                return leftR(root);
            }

            /* return the (unchanged) node pointer */
            return root;

        }

        double findMedian() {
            // as per size find out element(s) to find
            // return median
            int idx = size / 2 + 1;
            int k1 = 0, k2 = 0;
            double median = 0;

            k1 = find(root, idx);
            median = k1 / 1.0;
            if (size % 2 == 0) {
                k2 = find(root, idx - 1);
                median = (k1 + k2) / 2.0;
            }
            return median;
        }

        int find(Node root, int idx) {
            if (idx >= root.lcount + 1 && idx < root.lcount + 1 + root.freq) {
                return root.key;
            } else if (idx <= root.lcount) {
                return find(root.left, idx);
            } else {
                return find(root.right, idx - root.lcount - root.freq);
            }
        }
    }
}
