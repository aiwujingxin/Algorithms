package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/5 23:34
 */
//https://leetcode.cn/problems/minimum-height-trees/solution/by-ac_oier-7xio/
//树形 DP 问题通常将问题根据「方向」进行划分。

//首先，它通过输入的边的列表来构建一张图，然后使用深度优先搜索（DFS）来计算每个结点往下的最长链（d1）和次长链（d2），并记录下每个结点父节点的信息（p）。
//接着，它再次使用DFS来计算每个结点向上的最远距离（up），最后用每个结点的最长链和它向上的最远距离的最大值来计算出最小高度，并返回所有具有最小高度的结点的编号。
public class LeetCode310_dp {
    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Arrays.fill(he, -1);
        //链式前向星存储图
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            add(a, b);
            add(b, a);
        }
        //更新向下高度
        dfs1(0, -1);
        //更新向上高度
        dfs2(0, -1);
        List<Integer> ans = new ArrayList<>();
        int min = n;
        //获得最大列表
        for (int i = 0; i < n; i++) {
            int cur = Math.max(f1[i], g[i]);
            if (cur < min) {
                min = cur;
                ans.clear();
                ans.add(i);
            } else if (cur == min) {
                ans.add(i);
            }
        }
        return ans;
    }    int N = 20010, M = N * 2, idx = 0;

    int dfs1(int u, int fa) {
        for (int i = he[u]; i != -1; i = ne[i]) {
            //j为u的相邻节点
            int j = e[i];
            //防止向上走
            if (j == fa) {
                continue;
            }
            //向j走最大高度
            int sub = dfs1(j, u) + 1;
            if (sub > f1[u]) {
                //次大高度
                f2[u] = f1[u];
                //最大高度
                f1[u] = sub;
                //最大高度由j更新而来（经过了j）
                p[u] = j;
            } else if (sub > f2[u]) {
                f2[u] = sub;
            }
        }
        return f1[u];
    }    //f1最大向下高度、f2次大向下高度、g最大向上高度、p最大向下高度由那个节点得到

    void dfs2(int u, int fa) {

        for (int i = he[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == fa) {
                continue;
            }
            //u的得到的最大值不经过j，使用最大值更新
            if (p[u] != j) {
                g[j] = Math.max(g[j], f1[u] + 1);
            } else {  //u的得到的最大值经过j，使用次大值更新
                g[j] = Math.max(g[j], f2[u] + 1);
            }
            //由于从上往下遍历，所以父节点最大向上高度就是g[u]初始值,最开始根节点父节点最大向上高度为0
            g[j] = Math.max(g[j], g[u] + 1);
            //遍历整颗树，递归更新
            dfs2(j, u);
        }
    }    int[] he = new int[N], e = new int[M], ne = new int[M];



    int[] f1 = new int[N], f2 = new int[N], g = new int[N], p = new int[N];




}
