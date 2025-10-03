package knowledge.datastructure.graph.bipartite.impl;

import leetcode.problems.LeetCode1879_km;
import leetcode.problems.LeetCode1947_km;
import leetcode.problems.LeetCode2850_km;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 9/24/25 17:55
 * @description Kuhn-Munkres (KM) 算法 匈牙利算法的加权版本
 * 用于解决二分图带权的最佳完美匹配问题（最大权/最小权）。
 * @see LeetCode1947_km
 * @see LeetCode1879_km
 * @see LeetCode2850_km
 */
public class KM {

    private int n;          // 图的规模 (n x n)
    private int[][] weight; // 权重矩阵
    // KM 算法核心数组
    private int[] lx;       // 左部顶点的顶标
    private int[] ly;       // 右部顶点的顶标
    private int[] match;    // 记录右部顶点匹配的左部顶点 (match[j] = i)
    private boolean[] visX; // 记录一轮DFS中，左部顶点是否被访问过
    private boolean[] visY; // 记录一轮DFS中，右部顶点是否被访问过

    public KM(int[][] weightMatrix) {
        this.n = weightMatrix.length;
        this.weight = weightMatrix;
        this.lx = new int[n];
        this.ly = new int[n];
        this.match = new int[n];
        this.visX = new boolean[n];
        this.visY = new boolean[n];
    }

    /**
     * 求解最大权完美匹配
     *
     * @return 最大权匹配的和
     */
    public int solve() {
        // --- 步骤 1: 初始化顶标 ---
        // 左部顶点的顶标初始化为它连接的边的最大权重
        // 右部顶点的顶标初始化为 0
        Arrays.fill(ly, 0);
        for (int i = 0; i < n; i++) {
            lx[i] = -Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                lx[i] = Math.max(lx[i], weight[i][j]);
            }
        }
        // --- 步骤 2: 为每个左部顶点寻找匹配 ---
        Arrays.fill(match, -1); // 初始时，所有顶点都未匹配
        for (int i = 0; i < n; i++) {
            // 对于每个左部顶点 i，持续寻找匹配直到成功
            while (true) {
                // 每轮开始前，重置访问数组
                Arrays.fill(visX, false);
                Arrays.fill(visY, false);
                // --- 步骤 3: 在相等子图中用 DFS 寻找增广路 ---
                if (dfs(i)) {
                    // 如果找到了，说明顶点 i 匹配成功，跳出循环，为下一个左顶点寻找匹配
                    break;
                }
                // --- 步骤 4: 修改顶标 ---
                // 如果 DFS 没找到增广路，说明当前相等子图不够，需要调整顶标
                // 计算最小的 "松弛量" d
                int d = Integer.MAX_VALUE;
                for (int x = 0; x < n; x++) {
                    if (visX[x]) { // 遍历所有在本次 DFS 中访问过的左顶点
                        for (int y = 0; y < n; y++) {
                            if (!visY[y]) { // 遍历所有未访问过的右顶点
                                // d 就是让一个非相等子图中的边 (x,y) 成为相等子图中的边所需要调整的最小量
                                d = Math.min(d, lx[x] + ly[y] - weight[x][y]);
                            }
                        }
                    }
                }
                // 如果 d 是无穷大，说明图不连通或出现意外，可以终止
                if (d == Integer.MAX_VALUE) {
                    break;
                }
                // 更新顶标：
                // 所有访问过的左顶点 lx[x] -= d
                // 所有访问过的右顶点 ly[y] += d
                for (int x = 0; x < n; x++) {
                    if (visX[x]) {
                        lx[x] -= d;
                    }
                }
                for (int y = 0; y < n; y++) {
                    if (visY[y]) {
                        ly[y] += d;
                    }
                }
                // 修改顶标后，进入下一轮 while 循环，再次为顶点 i 寻找匹配
            }
        }
        // --- 步骤 5: 计算最终结果 ---
        int result = 0;
        for (int j = 0; j < n; j++) {
            if (match[j] != -1) {
                // 根据最终的匹配结果，从原始权重矩阵中累加权重
                result += weight[match[j]][j];
            }
        }
        return result;
    }

    /**
     * DFS 寻找增广路
     *
     * @param u 当前尝试匹配的左部顶点
     * @return 是否能为 u 找到一条增广路
     */
    private boolean dfs(int u) {
        visX[u] = true; // 标记左顶点 u 已访问
        for (int v = 0; v < n; v++) {
            // 只关心未访问过的右顶点
            if (!visY[v]) {
                // 检查边 (u, v) 是否在相等子图中
                int gap = lx[u] + ly[v] - weight[u][v];
                if (gap == 0) {
                    visY[v] = true; // 标记右顶点 v 已访问
                    // 如果 v 未被匹配，或者 v 的原匹配对象可以找到新的匹配
                    if (match[v] == -1 || dfs(match[v])) {
                        match[v] = u; // 将 v 匹配给 u
                        return true;  // 增广成功
                    }
                }
            }
        }
        return false; // 增广失败
    }
}
