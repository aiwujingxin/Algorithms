package knowledge.datastructure.tree.bst;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 23:02
 * @description SplayTree
 */
public class SplayTree {

    private static class Node {
        int key;
        Node left, right, parent;

        Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    private Node root;

    // --- 核心私有方法 ---

    /**
     * 右旋操作 (围绕 parent 节点)
     * 将 node 节点（parent的左孩子）提升到 parent 的位置。
     * <p>
     * parent             node
     * /    \            /    \
     * node   T3  ----->  T1   parent
     * /  \                    /    \
     * T1  T2                  T2    T3
     */
    private void rotateRight(Node parent) {
        Node node = parent.left;
        Node T2 = node.right;
        Node grandparent = parent.parent;

        // 1. 将 node 提升，取代 parent 在 grandparent 中的位置
        node.parent = grandparent;
        if (grandparent == null) {
            this.root = node;
        } else if (parent == grandparent.left) {
            grandparent.left = node;
        } else {
            grandparent.right = node;
        }

        // 2. 将 T2 作为 parent 的新左孩子
        parent.left = T2;
        if (T2 != null) {
            T2.parent = parent;
        }

        // 3. 将 parent 作为 node 的新右孩子
        node.right = parent;
        parent.parent = node;
    }

    /**
     * 左旋操作 (围绕 parent 节点)
     * 将 node 节点（parent的右孩子）提升到 parent 的位置。
     * <p>
     * parent              node
     * /    \             /    \
     * T1   node   -----> parent  T3
     * /  \          /    \
     * T2  T3        T1    T2
     */
    private void rotateLeft(Node parent) {
        Node node = parent.right;
        Node T2 = node.left;
        Node grandparent = parent.parent;

        // 1. 将 node 提升，取代 parent 在 grandparent 中的位置
        node.parent = grandparent;
        if (grandparent == null) {
            this.root = node;
        } else if (parent == grandparent.left) {
            grandparent.left = node;
        } else {
            grandparent.right = node;
        }

        // 2. 将 T2 作为 parent 的新右孩子
        parent.right = T2;
        if (T2 != null) {
            T2.parent = parent;
        }

        // 3. 将 parent 作为 node 的新左孩子
        node.left = parent;
        parent.parent = node;
    }

    /**
     * 伸展操作：将指定节点 `node` 旋转至树根。
     * 这是 Splay Tree 的核心。
     */
    private void splay(Node node) {
        if (node == null) return;

        // 循环直到 node 成为根节点
        while (node.parent != null) {
            Node parent = node.parent;
            Node grandparent = parent.parent;

            if (grandparent == null) {
                // Zig Case: 父节点是根，只需一次旋转
                if (node == parent.left) {
                    rotateRight(parent);
                } else {
                    rotateLeft(parent);
                }
            } else {
                if (node == parent.left) {
                    if (parent == grandparent.left) {
                        // Zig-Zig Case (left-left): 先转祖父，再转父亲
                        rotateRight(grandparent);
                        rotateRight(parent);
                    } else {
                        // Zig-Zag Case (right-left): 先转父亲，再转（新的）父亲
                        rotateRight(parent);
                        rotateLeft(grandparent);
                    }
                } else { // node == parent.right
                    if (parent == grandparent.left) {
                        // Zig-Zag Case (left-right)
                        rotateLeft(parent);
                        rotateRight(grandparent);
                    } else {
                        // Zig-Zig Case (right-right)
                        rotateLeft(grandparent);
                        rotateLeft(parent);
                    }
                }
            }
        }
        // 循环结束后，node 必然是根
        this.root = node;
    }

    // --- 公共 API ---

    /**
     * 插入一个新值。
     * 如果值已存在，则将该值的节点伸展到根。
     */
    public void insert(int key) {
        // 1. 如果树为空，新节点即为根
        if (root == null) {
            root = new Node(key);
            return;
        }

        // 2. 按照二叉搜索树的规则查找插入位置
        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            if (key < current.key) {
                current = current.left;
            } else if (key > current.key) {
                current = current.right;
            } else {
                // 如果键已存在，直接伸展该节点并返回，不插入重复值
                splay(current);
                return;
            }
        }

        // 3. 创建并链接新节点
        Node newNode = new Node(key);
        newNode.parent = parent;
        if (key < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        // 4. 将新插入的节点伸展到根
        splay(newNode);
    }

    /**
     * 查找一个值。
     *
     * @return 如果找到，返回该节点；否则返回 null。
     * 无论是否找到，最后访问的节点都会被伸展到根。
     */
    public Node search(int key) {
        Node current = root;
        Node lastAccessed = null;

        while (current != null) {
            lastAccessed = current;
            if (key < current.key) {
                current = current.left;
            } else if (key > current.key) {
                current = current.right;
            } else {
                // 找到了！伸展该节点到根
                splay(current);
                return current;
            }
        }

        // 没找到，将查找路径上最后一个非空节点伸展到根
        if (lastAccessed != null) {
            splay(lastAccessed);
        }
        return null; // 返回 null 表示未找到
    }

    /**
     * 删除一个值。
     */
    public void delete(int key) {
        // 1. 查找并伸展要删除的节点到根。如果找不到，search 会伸展最后访问的节点，然后直接返回。
        Node nodeToDelete = search(key);
        if (nodeToDelete == null) {
            return; // 节点不存在，无需删除
        }
        // 经过 search, nodeToDelete 已经是根节点

        Node leftSubtree = nodeToDelete.left;
        Node rightSubtree = nodeToDelete.right;

        if (leftSubtree == null) {
            // 2a. 如果没有左子树，右子树直接成为新的根
            this.root = rightSubtree;
            if (rightSubtree != null) {
                rightSubtree.parent = null;
            }
        } else {
            // 2b. 如果有左子树，先断开左子树与根的连接
            leftSubtree.parent = null;

            // 3. 找到左子树中的最大值（即左子树的最右节点）
            Node maxInLeft = leftSubtree;
            while (maxInLeft.right != null) {
                maxInLeft = maxInLeft.right;
            }

            // 4. 将这个最大值节点伸展到它所在子树的根（即整个树的新根）
            splay(maxInLeft); // 注意：splay 操作会更新 this.root

            // 5. 此时，新的根 (maxInLeft) 的右孩子必然是 null。
            //    将原来的右子树连接到新根的右边。
            this.root.right = rightSubtree;
            if (rightSubtree != null) {
                rightSubtree.parent = this.root;
            }
        }
    }
}
