package basic.advstructure;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 23:02
 */
public class SplayTree {

    private Node root;

    // 右旋转
    private void rotateRight(Node node) {
        Node parent = node.parent;
        Node grandparent = parent.parent;

        if (grandparent != null) {
            if (parent == grandparent.left) {
                grandparent.left = node;
            } else {
                grandparent.right = node;
            }
        }

        if (node.right != null) {
            node.right.parent = parent;
        }

        parent.left = node.right;
        node.right = parent;
        parent.parent = node;
        node.parent = grandparent;

        if (root == parent) {
            root = node;
        }
    }

    // 左旋转
    private void rotateLeft(Node node) {
        Node parent = node.parent;
        Node grandparent = parent.parent;

        if (grandparent != null) {
            if (parent == grandparent.left) {
                grandparent.left = node;
            } else {
                grandparent.right = node;
            }
        }

        if (node.left != null) {
            node.left.parent = parent;
        }

        parent.right = node.left;
        node.left = parent;
        parent.parent = node;
        node.parent = grandparent;

        if (root == parent) {
            root = node;
        }
    }

    // 伸展操作
    private void splay(Node node) {
        while (node.parent != null) {
            Node parent = node.parent;
            Node grandparent = parent.parent;

            if (grandparent == null) {
                if (node == parent.left) {

                    rotateRight(node);
                } else {
                    rotateLeft(node);
                }
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

    // 插入节点
    public void insert(int key) {
        Node newNode = new Node(key);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;

            if (key < current.key) {

                current = current.left;
            } else if (key > current.key) {
                current = current.right;

            } else {
                return;
            }
        }

        if (key < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        newNode.parent = parent;
        splay(newNode);
    }

    // 搜索节点
    public Node search(int key) {
        Node current = root;

        while (current != null) {
            if (key < current.key) {
                current = current.left;
            } else if (key > current.key)
                current = current.right;
            else {
                splay(current);
                return current;
            }
        }

        return null;
    }

    // 删除节点
    public void delete(int key) {
        Node node = search(key);

        if (node == null) {

            return;
        }

        splay(node);

        if (node.left == null) {

            root = node.right;
        } else {
            Node rightSubtree = node.right;
            root = node.left;
            root.parent = null;
            splay(root);
            root.right = rightSubtree;

            if (rightSubtree != null) {

                rightSubtree.parent = root;
            }
        }
    }

    // 前序遍历
    public void preOrderTraversal() {
        preOrder(root);
    }

    // 中序遍历
    public void inOrderTraversal() {
        inOrder(root);
    }

    // 前序遍历
    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 中序遍历
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    static class Node {
        int key;
        Node left, right, parent;

        Node(int key) {
            this.key = key;
            left = right = parent = null;
        }
    }

    public static void main(String[] args) {
        SplayTree tree = new SplayTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("前序遍历：");
        tree.preOrderTraversal();

        System.out.println("\n中序遍历：");
        tree.inOrderTraversal();

        tree.search(40);
        System.out.println("\n前序遍历（搜索后）：");
        tree.preOrderTraversal();

        tree.delete(30);
        System.out.println("\n前序遍历（删除后）：");
        tree.preOrderTraversal();
    }
}
