package knowledge.datastructure.tree.bst;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 23:02
 */
public class SplayTree {

    private Node root;

    // 插入节点
    public void insert(int key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root, parent = null;
            while (current != null) {
                parent = current;
                current = (key < current.key) ? current.left : current.right;
            }
            if (key < parent.key) parent.left = newNode;
            else parent.right = newNode;
            newNode.parent = parent;
        }
        splay(newNode);
    }

    // 搜索节点
    public Node search(int key) {
        Node cur = root;
        while (cur != null) {
            if (key == cur.key) {
                splay(cur);
                return cur;
            }
            cur = (key < cur.key) ? cur.left : cur.right;
        }
        return null;
    }

    // 删除节点
    public void delete(int key) {
        Node node = search(key);
        if (node == null) return;

        splay(node);
        if (node.left == null) root = node.right;
        else {
            Node rightSubtree = node.right;
            root = node.left;
            root.parent = null;
            splay(root);
            root.right = rightSubtree;
            if (rightSubtree != null) rightSubtree.parent = root;
        }
    }

    // 右旋转
    private void rotateRight(Node node) {
        Node parent = node.parent, grandparent = parent.parent;
        if (grandparent != null) {
            if (parent == grandparent.left) grandparent.left = node;
            else grandparent.right = node;
        }
        if (node.right != null) node.right.parent = parent;
        parent.left = node.right;
        node.right = parent;
        parent.parent = node;
        node.parent = grandparent;
        if (root == parent) root = node;
    }

    // 左旋转
    private void rotateLeft(Node node) {
        Node parent = node.parent, grandparent = parent.parent;
        if (grandparent != null) {
            if (parent == grandparent.left) grandparent.left = node;
            else grandparent.right = node;
        }
        if (node.left != null) node.left.parent = parent;
        parent.right = node.left;
        node.left = parent;
        parent.parent = node;
        node.parent = grandparent;
        if (root == parent) root = node;
    }

    // 伸展操作
    private void splay(Node node) {
        while (node.parent != null) {
            Node parent = node.parent, grandparent = parent.parent;
            if (grandparent == null) {
                if (node == parent.left) rotateRight(node);
                else rotateLeft(node);
            } else {
                if (node == parent.left) {
                    if (parent == grandparent.left) {
                        rotateRight(parent);
                        rotateRight(node);
                    } else {
                        rotateRight(node);
                        rotateLeft(node);
                    }
                } else {
                    if (parent == grandparent.left) {
                        rotateLeft(node);
                        rotateRight(node);
                    } else {
                        rotateLeft(parent);
                        rotateLeft(node);
                    }
                }
            }
        }
    }

    // 节点类
    static class Node {
        int key;
        Node left, right, parent;

        Node(int key) {
            this.key = key;
        }
    }
}
