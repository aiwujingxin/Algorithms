package knowledge.datastructure.adv;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/22 22:16
 * @description 并查集
 * @link <a href="https://algs4.cs.princeton.edu/15uf/"></a>
 * @see LeetCode323           无向图中连通分量的数目
 * @see LeetCode547_uf        省份数量
 * @see LeetCode684_uf        冗余连接
 * @see LeetCode1319_uf       连通网络的操作次数
 * @see LeetCode2492_uf       两个城市间路径的最小分数
 * @see LeetCode2685          统计完全连通分量的数量
 * @see LeetCode765           情侣牵手
 * @see LeetCode827           最大人工岛
 * @see LeetCode947_uf        移除最多的同行或同列石头
 * @see LeetCode990           等式方程的可满足性
 * @see LeetCode839           相似字符串组
 * @see LeetCode2316          统计无向图中无法互相到达点对数
 * @see LeetCode2424          最长上传前缀
 */
public class UnionFind {

    private final int[] pa, size;
    private int cnt;

    public UnionFind(int n) {
        this.pa = new int[n];
        this.size = new int[n];
        this.cnt = n;
        for (int i = 0; i < n; i++) {
            pa[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        return pa[x] == x ? x : (pa[x] = find(pa[x])); // 路径压缩
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return false;
        }
        pa[x] = y;
        size[y] += size[x];
        cnt--;
        return true;
    }

    public int getCount() {
        return cnt;
    }

    public int sizeOfSet(int x) {
        return size[find(x)];
    }
}
