package knowledge.datastructure.tree.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 9/18/25 02:20
 * @description 一个通用的、非自平衡的区间树模板。 一个专门用于处理 (start, end) 数值区间的区间树模板。
 */
public class IntervalTree {

    /**
     * 区间树的内部节点类。
     */
    public static class Node implements Comparable<Node> {
        public long start;
        public long end;
        public long maxEndInSubtree; // 以此节点为根的子树中，所有区间的最大结束点
        public Node left, right;

        Node(long start, long end) {
            this.start = start;
            this.end = end;
            this.maxEndInSubtree = end;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.start, other.start);
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    private Node root;
    private int size = 0;

    /**
     * 向区间树中插入一个新的区间 [start, end]。
     *
     * @param start 区间的起始点。
     * @param end   区间的结束点。
     */
    public void insert(long start, long end) {
        if (start > end) {
            throw new IllegalArgumentException("Interval start cannot be greater than its end.");
        }
        root = insert(root, start, end);
        size++;
    }

    private Node insert(Node node, long start, long end) {
        if (node == null) {
            return new Node(start, end);
        }

        // 插入逻辑基于区间的起始点
        if (start < node.start) {
            node.left = insert(node.left, start, end);
        } else {
            // 如果起始点相同，我们简单地将新节点放在右边
            node.right = insert(node.right, start, end);
        }

        // 在回溯过程中更新 maxEndInSubtree
        if (node.maxEndInSubtree < end) {
            node.maxEndInSubtree = end;
        }

        return node;
    }

    /**
     * 从区间树中删除一个精确匹配的区间 [start, end]。
     *
     * @param start 要删除区间的起始点。
     * @param end   要删除区间的结束点。
     */
    public void delete(long start, long end) {
        root = delete(root, start, end);
    }

    private Node delete(Node node, long start, long end) {
        if (node == null) {
            return null;
        }

        // 查找要删除的节点
        if (start < node.start) {
            node.left = delete(node.left, start, end);
        } else if (start > node.start) {
            node.right = delete(node.right, start, end);
        } else { // 找到了起始点相同的节点
            if (node.end == end) { // 结束点也相同，就是这个节点
                // 执行标准的 BST 删除逻辑
                if (node.left == null) {
                    size--;
                    return node.right;
                }
                if (node.right == null) {
                    size--;
                    return node.left;
                }

                // 节点有两个子节点：找到右子树的最小节点作为后继
                Node successor = findMin(node.right);
                node.start = successor.start;
                node.end = successor.end;
                // 从右子树中删除那个后继节点
                node.right = delete(node.right, successor.start, successor.end);
            } else {
                // 起始点相同但结束点不同，继续在右子树查找
                node.right = delete(node.right, start, end);
            }
        }

        // 删除后，在回溯过程中更新 maxEndInSubtree
        if (node != null) {
            updateMaxEnd(node);
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private void updateMaxEnd(Node node) {
        long max = node.end;
        if (node.left != null) {
            max = Math.max(max, node.left.maxEndInSubtree);
        }
        if (node.right != null) {
            max = Math.max(max, node.right.maxEndInSubtree);
        }
        node.maxEndInSubtree = max;
    }

    /**
     * 查找所有与给定查询区间 [start, end] 重叠的区间。
     *
     * @param start 查询区间的起始点。
     * @param end   查询区间的结束点。
     * @return 一个包含所有重叠区间 (以 Node 对象形式) 的列表。
     */
    public List<Node> findOverlapping(long start, long end) {
        List<Node> result = new ArrayList<>();
        findOverlapping(root, start, end, result);
        return result;
    }

    private void findOverlapping(Node node, long start, long end, List<Node> result) {
        if (node == null) {
            return;
        }

        // 剪枝优化 1: 如果左子树的最大结束点都小于查询区间的起始点，则无需搜索左子树。
        if (node.left != null && node.left.maxEndInSubtree >= start) {
            findOverlapping(node.left, start, end, result);
        }

        // 检查当前节点是否与查询区间重叠 (node.start <= end AND node.end >= start)
        if (node.start <= end && node.end >= start) {
            result.add(node);
        }

        // 如果查询区间的起始点大于当前子树的最大结束点，则无需搜索右子树。
        if (start <= node.maxEndInSubtree) {
            findOverlapping(node.right, start, end, result);
        }
    }

    /**
     * @return 树中存储的区间总数。
     */
    public int size() {
        return size;
    }

    /**
     * @return 树是否为空。
     */
    public boolean isEmpty() {
        return root == null;
    }

    public static void main(String[] args) {
        // 创建一个区间树实例
        IntervalTree intervalTree = new IntervalTree();
        // 插入区间
        intervalTree.insert(15, 25);
        intervalTree.insert(10, 20);
        intervalTree.insert(30, 40);
        intervalTree.insert(5, 12);
        System.out.println("树的大小: " + intervalTree.size()); // 输出: 4
        // 查询与区间 [18, 32] 重叠的所有区间
        System.out.println("\n查询与区间 [18, 32] 重叠的区间:");
        List<IntervalTree.Node> overlappingNodes = intervalTree.findOverlapping(18, 32);
        for (IntervalTree.Node node : overlappingNodes) {
            System.out.println("找到重叠区间: " + node);
        }
        // 预期输出:
        // 找到重叠区间: [10, 20]
        // 找到重叠区间: [15, 25]
        // 找到重叠区间: [30, 40]
        // 删除一个区间
        System.out.println("\n删除区间 [10, 20]...");
        intervalTree.delete(10, 20);
        System.out.println("删除后树的大小: " + intervalTree.size()); // 输出: 3
        // 再次查询
        System.out.println("\n再次查询与区间 [18, 32] 重叠的区间:");
        List<IntervalTree.Node> overlappingAfterDelete = intervalTree.findOverlapping(18, 32);
        for (IntervalTree.Node node : overlappingAfterDelete) {
            System.out.println("找到重叠区间: " + node);
        }
        // 预期输出:
        // 找到重叠区间: [15, 25]
        // 找到重叠区间: [30, 40]
    }
}
