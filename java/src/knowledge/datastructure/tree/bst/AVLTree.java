package knowledge.datastructure.tree.bst;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/19 01:10
 *       from ChatGPT
 */
public class AVLTree {

    private Node root;

    // 构造函数
    public AVLTree() {
        root = null;
    }

    // 在AVL树中插入节点
    public void insert(int key) {
        root = insertNode(root, key);
    }

    // 在AVL树中删除节点
    public void delete(int key) {
        root = deleteNode(root, key);
    }

    // 查找AVL树中的最大节点
    private Node findMax(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // 中序遍历AVL树
    private void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.key + " ");
            inorderTraversal(node.right);
        }
    }

    // 获取节点的高度
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // 打印AVL树中的节点（中序遍历）
    public void printTree() {
        inorderTraversal(root);
    }

    // 获取两个节点中的较大高度
    private int max(int a, int b) {
        return Math.max(a, b);
    }

    // 对节点进行右旋操作
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // 执行旋转
        x.right = y;
        y.left = T2;

        // 更新节点的高度
        y.height = max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // 对节点进行左旋操作
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // 执行旋转
        y.left = x;
        x.right = T2;

        // 更新节点的高度
        x.height = max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    // 在AVL树中插入节点
    private Node insertNode(Node node, int key) {
        // 执行标准BST插入
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insertNode(node.left, key);
        } else if (key > node.key) {
            node.right = insertNode(node.right, key);
        } else {
            // 不允许插入重复的节点
            return node;
        }

        // 更新节点的高度
        node.height = max(getHeight(node.left), getHeight(node.right)) + 1;

        // 检查节点的平衡因子，进行相应的旋转操作
        int balance = getBalance(node);
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // 在AVL树中删除节点
    private Node deleteNode(Node root, int key) {
        // 执行标准BST删除
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } else {
            // 找到要删除的节点
            if (root.left == null || root.right == null) {
                Node temp;
                if (root.left != null) {
                    temp = root.left;
                } else {
                    temp = root.right;
                }

                // 无子节点的情况
                if (temp == null) {
                    temp = root;
                    root = null;
                } else { // 有一个子节点的情况
                    root = temp;
                }
            } else {
                // 找到左子树中的最大节点
                Node temp = findMax(root.left);
                root.key = temp.key;
                root.left = deleteNode(root.left, temp.key);
            }
        }

        // 如果树为空，则直接返回
        if (root == null) {
            return root;
        }

        // 更新节点的高度
        root.height = max(getHeight(root.left), getHeight(root.right)) + 1;

        // 检查节点的平衡因子，进行相应的旋转操作
        int balance = getBalance(root);
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // 获取节点的平衡因子
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    static class Node {
        int key; // 节点的键值
        int height; // 节点的高度
        Node left; // 左子节点的引用
        Node right; // 右子节点的引用

        public Node(int key) {
            this.key = key;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }
}
