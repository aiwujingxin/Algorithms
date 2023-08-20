package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/27 14:10
 */
public class LeetCode295_BST_TEL {

    //https://leetcode.com/problems/find-median-from-data-stream/solutions/1267964/golang-bst-that-maintains-mid-value/

    //https://leetcode.com/problems/find-median-from-data-stream/solutions/1331670/java-binary-search-tree-solution/
    class MedianFinder {

        /**
         * initialize your data structure here.
         */
        int size = 0;
        Node root;

        public MedianFinder() {
            root = null;
            size = 0;
        }

        public void addNum(int num) {

            root = addNode(root, num);
            size++;

        }

        private Node addNode(Node node, int num) {

            if (node == null) {
                return new Node(num);
            }

            if (num < node.val) {
                node.leftTreeSize++;
                node.left = addNode(node.left, num);
            } else {
                node.right = addNode(node.right, num);
            }

            return node;

        }

        public double findMedian() {

            int mid = 0;

            mid += find(root, size / 2);

            if (size % 2 == 0) {
                mid += find(root, size / 2 - 1);
                return (double) mid / 2;
            }

            return mid;
        }


        private int find(Node node, int size) {

            if (node.leftTreeSize > size) {
                return find(node.left, size);
            }

            if (size == node.leftTreeSize) {
                return node.val;
            }

            size -= (node.leftTreeSize + 1);
            return find(node.right, size);

        }
    }

    class Node {

        int val;
        int leftTreeSize;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.leftTreeSize = 0;
        }

    }
}
