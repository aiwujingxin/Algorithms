package knowledge.advstructure;


import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/23 18:32
 * @description 用于高效地解决「前缀和查询」与「单点更新」问题 ;not for range max/min 求区间最大最小值用segTree
 * 时间复杂度 query 和 update 都是 O(logn)
 * lowbit : 运算找出整数在二进制表示下所有等子1的位: 找parent的方式是把最右边的1砍掉==孩子的二进制从右边起比 parent 多 1
 * @link <a href="https://leetcode.cn/problems/range-sum-query-mutable/solution/guan-yu-ge-lei-qu-jian-he-wen-ti-ru-he-x-41hv/">模版</a>
 * @link <a href="https://www.youtube.com/watch?v=v2Q4ZjPeFuc">讲解</a>
 * @see LeetCode307 一维
 * @see LeetCode308 二维
 * @see LeetCode315_BitTree
 * @see LeetCode327_BitTree
 * @see LeetCode493_bittree
 * @see LeetCode673_BitTree
 * @see LeetCode683_bittree
 * @see LeetCode1649
 */
public class BITree {
    int[] tree;

    public BITree(int n) {
        this.tree = new int[n + 1];
    }

    public void add(int x, int u) {
        for (int i = x; i < tree.length; i += (i & (-i))) tree[i] += u;
    }

    public int sum(int x) {
        int sum = 0;
        for (int i = x; i > 0; i -= (i & (-i))) sum += tree[i];
        return sum;
    }
}