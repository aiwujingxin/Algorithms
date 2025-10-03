package knowledge.datastructure.string.suffix;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 11/9/24 06:47
 * @description 后缀树（Suffix Tree）是一种针对字符串构建的树形数据结构，它能高效地表示字符串的所有后缀。
 * - 本质上，后缀树是一棵紧凑的字典树（Trie），专门用于存储字符串的所有后缀，并且通过合并公共前缀来节省空间。
 * - 用处（应用场景）
 * 1. 快速子串查找
 * 2. 查找最长重复子串
 * 3. 查找最长回文子串/最长公共子串
 * 4. 字符串出现次数统计、位置查找
 */

// 朴素后缀树（学习用 O(n^2) 构建），包含：contains、所有出现位置、最长重复子串
public class SuffixTree {
    private final String text;
    private final SuffixTreeNode root;

    public SuffixTree(String text) {
        if (text == null) throw new IllegalArgumentException("text cannot be null");
        this.text = text;
        this.root = new SuffixTreeNode(-1, -1, null);
        // 提醒：建议以唯一终止符（如 '$'）结尾，避免后缀互为前缀
        buildSuffixTree();
    }

    // 构建后缀树（朴素 O(n^2)）
    private void buildSuffixTree() {
        for (int i = 0; i < text.length(); i++) {
            addSuffix(i);
        }
    }

    // 插入 text[i:]
    private void addSuffix(int suffixStart) {
        SuffixTreeNode node = root;
        int j = suffixStart;
        while (j < text.length()) {
            char c = text.charAt(j);
            SuffixTreeNode child = node.children.get(c);
            if (child == null) {
                // 新建叶子节点 [j, n)
                node.children.put(c, new SuffixTreeNode(j, text.length(), node));
                return;
            }
            int k = child.start;
            // 在边上尽可能匹配
            while (k < child.end && j < text.length() && text.charAt(k) == text.charAt(j)) {
                k++;
                j++;
            }
            if (k == child.end) {
                // 完全走过当前边，继续向下
                node = child;
            } else {
                // 不匹配，需要分裂边
                SuffixTreeNode split = new SuffixTreeNode(child.start, k, node);
                node.children.put(c, split);

                // 新建叶子挂在 split 下
                split.children.put(text.charAt(j), new SuffixTreeNode(j, text.length(), split));

                // 原 child 调整起点并挂到 split 下
                child.start = k;
                child.parent = split;
                split.children.put(text.charAt(k), child);
                return;
            }
        }
    }

    // 是否包含模式串
    public boolean contains(String pattern) {
        if (pattern == null) return false;
        if (pattern.isEmpty()) return true;
        SuffixTreeNode node = root;
        int i = 0;
        while (i < pattern.length()) {
            char c = pattern.charAt(i);
            SuffixTreeNode child = node.children.get(c);
            if (child == null) return false;
            int k = child.start;
            while (k < child.end && i < pattern.length() && text.charAt(k) == pattern.charAt(i)) {
                k++;
                i++;
            }
            if (i == pattern.length()) {
                // 模式串已匹配完
                return true;
            }
            if (k < child.end) {
                // 边上提前不等，失败
                return false;
            }
            node = child;
        }
        return true;
    }

    // 返回 pattern 在 text 中的所有出现位置（按升序）
    public List<Integer> getAllOccurrences(String pattern) {
        if (pattern == null) return Collections.emptyList();
        if (pattern.isEmpty()) {
            // 约定：空串出现于每个位置
            List<Integer> all = new ArrayList<>();
            for (int i = 0; i < text.length(); i++) all.add(i);
            return all;
        }
        SuffixTreeNode node = root;
        int i = 0;
        while (i < pattern.length()) {
            char c = pattern.charAt(i);
            SuffixTreeNode child = node.children.get(c);
            if (child == null) return Collections.emptyList();
            int k = child.start;
            while (k < child.end && i < pattern.length() && text.charAt(k) == pattern.charAt(i)) {
                k++;
                i++;
            }
            if (i < pattern.length() && k < child.end) {
                // 边上不等
                return Collections.emptyList();
            }
            node = child;
        }
        // 匹配到某节点（可能是边内或节点结束处）
        // 收集该节点子树所有叶子（后缀起点）作为出现位置
        List<Integer> result = new ArrayList<>();
        collectLeafPositions(node, result);
        Collections.sort(result);
        return result;
    }

    // 最长重复子串（出现至少两次）
    public String getLongestRepeatedSubstring() {
        if (text.isEmpty()) return "";
        LrsResult res = new LrsResult();
        // DFS 返回子树叶子数量，同时维护从根的累计路径长度
        dfsForLRS(root, 0, -1, res);
        if (res.bestLen <= 0) return "";
        return text.substring(res.bestStart, res.bestStart + res.bestLen);
    }

    // 打印后缀树（用于调试）
    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(SuffixTreeNode node, int depth) {
        for (SuffixTreeNode child : node.children.values()) {
            // 缩进
            for (int i = 0; i < depth; i++) System.out.print("  ");
            System.out.println(edgeLabel(child));
            printTree(child, depth + 1);
        }
    }

    // ========= 内部辅助 =========

    private String edgeLabel(SuffixTreeNode node) {
        return text.substring(node.start, node.end);
    }

    private void collectLeafPositions(SuffixTreeNode node, List<Integer> result) {
        if (node.children.isEmpty()) {
            result.add(node.start);
            return;
        }
        for (SuffixTreeNode child : node.children.values()) {
            collectLeafPositions(child, result);
        }
    }

    // LRS 结果
    private static class LrsResult {
        int bestStart = 0;
        int bestLen = 0;
    }

    // 返回值：子树叶子数；参数 pathLen = 从根到当前节点的路径总长度
    // enterEdgeStart: 进入当前节点的边在 text 中的起点；根用 -1
    private int dfsForLRS(SuffixTreeNode node, int pathLen, int enterEdgeStart, LrsResult res) {
        if (node.children.isEmpty()) {
            // 叶子：路径长度不再延伸（没有记录），叶子数=1
            return 1;
        }
        int totalLeaves = 0;
        for (SuffixTreeNode child : node.children.values()) {
            int edgeLen = child.end - child.start;
            totalLeaves += dfsForLRS(child, pathLen + edgeLen, child.start, res);
        }
        // 当前节点是内部节点，若子树叶子数 >= 2，说明当前路径代表重复子串
        if (node != root && totalLeaves >= 2) {
            // 当前节点代表从根到此的路径，长度 pathLen
            // 该路径的开始位置应当是“从根沿路径最早边的 child.start”，
            // 但要精确截取：我们需要记录“路径末端进入此节点的边结束后，整条路径的起点”
            // 简化实现：在每次递归中，enterEdgeStart 传的是进入“当前节点”的边起点；
            // 但我们真正需要的起点是“整条路径的开始”。为避免维护整条路径栈，
            // 我们可以在需要更新最佳答案时，回溯起点：路径起点 = 当前路径末端的 (start - (pathLen - edgeLen_of_enter_edge - ...))
            // 为代码简洁，改用“路径栈”方案更直接：见下一个改良版本。
        }
        return totalLeaves;
    }

    // 改良：使用路径栈，准确定位 LRS 子串区间
    public String getLongestRepeatedSubstringAccurate() {
        if (text.isEmpty()) return "";
        LrsAccResult res = new LrsAccResult();
        Deque<int[]> pathStack = new ArrayDeque<>(); // 每个元素为 [start, end)
        dfsForLRSWithPath(root, pathStack, res);
        if (res.bestLen <= 0) return "";
        return text.substring(res.bestStart, res.bestStart + res.bestLen);
    }

    private static class LrsAccResult {
        int bestStart = 0;
        int bestLen = 0;
    }

    // 返回子树叶子数；pathStack 保存从根到“当前节点”的所有边区间
    private int dfsForLRSWithPath(SuffixTreeNode node, Deque<int[]> pathStack, LrsAccResult res) {
        if (node.children.isEmpty()) {
            return 1;
        }
        int leaves = 0;
        for (SuffixTreeNode child : node.children.values()) {
            pathStack.addLast(new int[]{child.start, child.end});
            leaves += dfsForLRSWithPath(child, pathStack, res);
            pathStack.removeLast();
        }
        if (node != root && leaves >= 2) {
            // 计算从根到当前节点路径总长度与“路径起点”
            int totalLen = 0;
            Integer pathStart = null;
            for (int[] seg : pathStack) {
                if (pathStart == null) pathStart = seg[0];
                totalLen += seg[1] - seg[0];
            }
            if (totalLen > res.bestLen) {
                res.bestLen = totalLen;
                res.bestStart = pathStart == null ? 0 : pathStart;
            }
        }
        return leaves;
    }

    // 节点定义
    private static class SuffixTreeNode {
        Map<Character, SuffixTreeNode> children = new HashMap<>();
        int start, end;       // 边在原字符串中的 [start, end)
        SuffixTreeNode parent;

        SuffixTreeNode(int start, int end, SuffixTreeNode parent) {
            this.start = start;
            this.end = end;
            this.parent = parent;
        }
    }

    // 演示
    public static void main(String[] args) {
        String s = "banana$"; // 建议使用唯一终止符
        SuffixTree tree = new SuffixTree(s);

        System.out.println("Tree:");
        tree.printTree();

        System.out.println("contains(ana): " + tree.contains("ana"));
        System.out.println("contains(apple): " + tree.contains("apple"));

        System.out.println("Occurrences of ana: " + tree.getAllOccurrences("ana"));

        // 两种 LRS（accurate 是精确版）
        System.out.println("LRS (accurate): " + tree.getLongestRepeatedSubstringAccurate());
    }
}
