package knowledge.datastructure.adv;

import leetcode.lists.lcr.*;
import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/23 18:32
 * @description 树状数组
 * <描述>
 * 用于高效地解决「前缀和查询」与「单点更新」问题. 时间复杂度 query 和 add 都是 O(logn);
 * <核心>
 * lowbit(i) : 找到 i 二进制数的最后一个 1
 * tree[i]: 管辖区间 [i-lowbit(i)+1, i], 是把 i 和它前面共lowbit(i)个数相加的结果。例如: 88=01011000,其二进制最低位的1以及后面的0组成的二进制是1000,即8,tree[88]管辖8个数组中的元素: a[81..88]
 * <原理>
 * 因为每次 i -(+)= lowbit(i) 向上(下)跳时，都正好跳过了 tree[i] 所管辖的 不重叠区间.
 * 任何正整数 i 都可以唯一拆分为若干个二进制中 1 的位置之和. 这使得前缀和查询能被唯一、高效地拆解成不重叠区间的和。
 * @link <a href="https://leetcode.cn/problems/range-sum-query-mutable/solution/guan-yu-ge-lei-qu-jian-he-wen-ti-ru-he-x-41hv/">模版</a>
 * @link <a href="https://www.youtube.com/watch?v=v2Q4ZjPeFuc">讲解</a>
 * @see LeetCode307 一维
 * @see LeetCode308 二维
 * @see LCR170_bitTree
 * @see LeetCode315_bitTree
 * @see LeetCode327_bitTree
 * @see LeetCode493_bitTree
 * @see LeetCode673_bitTree
 * @see LeetCode683_bittree
 * @see LeetCode1375
 * @see LeetCode1649
 * @see LeetCode2424
 */
public class BITree {
    int[] tree;

    public BITree(int n) {
        tree = new int[n + 1];
    }

    public void add(int x, int u) {
        for (int i = x; i < tree.length; i += (i & -i)) tree[i] += u;
    }

    public int sum(int x) {
        int sum = 0;
        for (int i = x; i > 0; i -= (i & -i)) sum += tree[i];
        return sum;
    }
}