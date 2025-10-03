package knowledge.datastructure.tree.bst;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/25 00:14
 * @description 红黑树 红黑树的标准实现 (适用于算法竞赛和教学)
 * 该实现遵循了《算法导论》中的经典定义和伪代码。
 * - 颜色表示: 0 代表黑色 (BLACK), 1 代表红色 (RED)。
 * - 哨兵节点: 使用一个 TNULL 节点来代表所有的叶子节点 (NIL)，简化了边界条件的处理。
 * - 核心操作: 实现了插入 (insert)、删除 (delete)、查找 (search) 以及左/右旋 (left/right rotate)。
 */
public class RedBlackTree {

    // 颜色常量
    private static final int RED = 1;
    private static final int BLACK = 0;

    // 节点定义
    private static class Node {
        int value;
        Node parent;
        Node left;
        Node right;
        int color;

        Node(int value) {
            this.value = value;
        }
    }

    private final Node TNULL; // 哨兵节点
    private Node root;

    // 构造函数
    public RedBlackTree() {
        TNULL = new Node(0);
        TNULL.color = BLACK;
        TNULL.left = null; // TNULL 的子节点和父节点在逻辑上不存在，但可以指向自身或null
        TNULL.right = null;
        root = TNULL;
    }

    // --- 核心操作 ---

    /**
     * 左旋操作
     * x                y
     * / \              / \
     * a   y    ----->   x   c
     * / \          / \
     * b   c        a   b
     */
    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) { // x 是根节点
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    /**
     * 右旋操作 (左旋的镜像)
     * y            x
     * / \          / \
     * x   c  -----> a   y
     * / \              / \
     * a   b            b   c
     */
    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) { // x 是根节点
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    /**
     * 插入新节点
     */
    public void insert(int key) {
        Node node = new Node(key);
        node.parent = null;
        node.left = TNULL;
        node.right = TNULL;
        node.color = RED; // 新插入节点总是红色

        Node y = null;
        Node x = this.root;

        // 1. 找到插入位置
        while (x != TNULL) {
            y = x;
            if (node.value < x.value) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        // 2. 插入节点
        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.value < y.value) {
            y.left = node;
        } else {
            y.right = node;
        }

        // 如果新节点是根节点，直接涂黑并返回
        if (node.parent == null) {
            node.color = BLACK;
            return;
        }

        // 如果父节点是根节点，无需调整
        if (node.parent.parent == null) {
            return;
        }

        // 3. 修复红黑树性质
        fixInsert(node);
    }

    /**
     * 插入后修复红黑树
     */
    private void fixInsert(Node k) {
        Node u; // 叔叔节点
        while (k.parent.color == RED) {
            if (k.parent == k.parent.parent.right) { // 父节点是右孩子
                u = k.parent.parent.left;
                if (u.color == RED) { // Case 1: 叔叔是红色
                    u.color = BLACK;
                    k.parent.color = BLACK;
                    k.parent.parent.color = RED;
                    k = k.parent.parent;
                } else { // 叔叔是黑色
                    if (k == k.parent.left) { // Case 2: "之"字形 -> 转为"一"字形
                        k = k.parent;
                        rightRotate(k);
                    }
                    // Case 3: "一"字形
                    k.parent.color = BLACK;
                    k.parent.parent.color = RED;
                    leftRotate(k.parent.parent);
                }
            } else { // 父节点是左孩子 (对称)
                u = k.parent.parent.right;
                if (u.color == RED) { // Case 1
                    u.color = BLACK;
                    k.parent.color = BLACK;
                    k.parent.parent.color = RED;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) { // Case 2
                        k = k.parent;
                        leftRotate(k);
                    }
                    // Case 3
                    k.parent.color = BLACK;
                    k.parent.parent.color = RED;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = BLACK; // 根节点永远是黑色
    }

    /**
     * 节点移植：用节点 v 替换节点 u
     */
    private void transplant(Node u, Node v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        if (v != null) { // v 可以是 TNULL，此时 TNULL 的 parent 不用设置
            v.parent = u.parent;
        }
    }

    /**
     * 删除节点
     */
    public void delete(int value) {
        Node z = search(value);
        if (z == TNULL) {
            return; // 节点不存在
        }

        Node x;
        Node y = z;
        int yOriginalColor = y.color;

        if (z.left == TNULL) {
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == TNULL) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                if (x != null) x.parent = y; // x可能是TNULL
            } else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }

        if (yOriginalColor == BLACK) {
            fixDelete(x);
        }
    }

    /**
     * 删除后修复红黑树
     */
    private void fixDelete(Node x) {
        if (x == null) return; // 如果 x 为 null，则不需要修复
        while (x != root && x.color == BLACK) {
            if (x == x.parent.left) {
                Node s = x.parent.right; // 兄弟节点
                if (s.color == RED) { // Case 1: 兄弟是红色
                    s.color = BLACK;
                    x.parent.color = RED;
                    leftRotate(x.parent);
                    s = x.parent.right;
                }

                if (s.left.color == BLACK && s.right.color == BLACK) { // Case 2: 兄弟和其子节点都黑
                    s.color = RED;
                    x = x.parent;
                } else {
                    if (s.right.color == BLACK) { // Case 3: 兄弟黑，左子红，右子黑
                        s.left.color = BLACK;
                        s.color = RED;
                        rightRotate(s);
                        s = x.parent.right;
                    }
                    // Case 4: 兄弟黑，右子红
                    s.color = x.parent.color;
                    x.parent.color = BLACK;
                    s.right.color = BLACK;
                    leftRotate(x.parent);
                    x = root;
                }
            } else { // 对称情况
                Node s = x.parent.left;
                if (s.color == RED) { // Case 1
                    s.color = BLACK;
                    x.parent.color = RED;
                    rightRotate(x.parent);
                    s = x.parent.left;
                }

                if (s.left.color == BLACK && s.right.color == BLACK) { // Case 2
                    s.color = RED;
                    x = x.parent;
                } else {
                    if (s.left.color == BLACK) { // Case 3
                        s.right.color = BLACK;
                        s.color = RED;
                        leftRotate(s);
                        s = x.parent.left;
                    }
                    // Case 4
                    s.color = x.parent.color;
                    x.parent.color = BLACK;
                    s.left.color = BLACK;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = BLACK;
    }

    // --- 辅助查询方法 ---

    /**
     * 查找值为 key 的节点
     */
    public Node search(int key) {
        Node current = root;
        while (current != TNULL && key != current.value) {
            if (key < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return current;
    }

    /**
     * 查找以 node 为根的子树中的最小节点
     */
    private Node minimum(Node node) {
        while (node.left != TNULL) {
            node = node.left;
        }
        return node;
    }

    /**
     * 查找整棵树的最小节点
     */
    public Node minimum() {
        if (root == TNULL) return TNULL;
        return minimum(root);
    }

    /**
     * 查找以 node 为根的子树中的最大节点
     */
    private Node maximum(Node node) {
        while (node.right != TNULL) {
            node = node.right;
        }
        return node;
    }

    /**
     * 查找整棵树的最大节点
     */
    public Node maximum() {
        if (root == TNULL) return TNULL;
        return maximum(root);
    }
}
