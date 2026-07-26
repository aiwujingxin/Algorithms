package knowledge.algorithms.presumAnddiff;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/22 10:45
 * @description 前缀和 (Prefix Sum) 算法模板
 * <本质>
 * 1. 空间换时间：通过 O(N) 的预处理，实现 O(1) 的区间查询。
 * 2. 区间问题单点化：将求区间 [i, j] 的状态，转化为求端点 j 和端点 i-1 的状态差（或状态运算）。
 * 3. 差分数组的逆运算：对差分数组求前缀和，即可还原出原数组。
 * <解决问题>
 * 1. 区间求和/区间异或：快速计算数组/矩阵中任意区间的元素之和或异或和。
 * 2. 子数组满足特定条件：将“子数组和为K”转化为寻找“两个前缀和的差为K”。
 * <技巧与踩坑点>
 * 1. 哨兵节点 (n+1 技巧)：前缀和数组长度通常设为 n+1，令 preSum[0] = 0，完美解决区间包含下标 0
 * 时的越界特判问题。
 * 2. 空间优化 (滚动变量)：如果题目只关心“当前前缀和”与“历史前缀和”的关系（如配合 HashMap），无需开辟数组，用一个
 * int 变量维护当前和即可，空间复杂度降为 O(1)。
 * 3. 同余定理防负数：在处理取模问题时（如被 K 整除），Java 中的负数取模仍为负数。必须使用 `(sum % K + K)
 * % K` 来保证余数为正。
 * 4. 状态转换：将原数组转化成 [0,1] 或者 [-1,1]（例如：奇数视作1，偶数视作0；或者求0和1数量相等的子数组）。
 * 5. 异或前缀和：利用 a ^ a = 0 的性质，区间 [i, j] 的异或和等于 preXor[j+1] ^
 * preXor[i]（加减法变成了异或）。
 * 6. 树上前缀和：在树的 DFS 遍历中携带前缀和，利用回溯思想，在退出节点时从 HashMap 中撤销当前节点的前缀和状态。
 * <基础>
 * @see LeetCode303 区域和检索
 * @see LeetCode304 二维区域和检索
 * <哈希表>
 * @see LeetCode560 和为 K 的子数组 (前缀和+哈希表求次数)
 * @see LeetCode974 和可被 K 整除的子数组 (同余定理: preSum[i]%K == preSum[j]%K)
 * @see LeetCode523 连续的子数组和 (同余定理求长度)
 * @see LeetCode525 连续数组 (将0转为-1，求和为0的最长子数组)
 * @see LeetCode1248 统计「优美子数组」 (奇数转1，偶数转0，转化为和为K的子数组)
 * @see LeetCode437 路径总和 III (树上前缀和 + 回溯恢复现场)
 * <前缀异或>
 * @see LeetCode1310 子数组异或查询 (利用 x ^ x = 0 的性质)
 * <二分 单调队列>
 * @see LeetCode209 长度最小的子数组 (正数数组，前缀和单调递增，可结合二分)
 * @see LeetCode862 和至少为 K 的最短子数组 (包含负数，前缀和不再单调，需用单调队列)
 * <前后缀分解>
 * @see LeetCode238 除自身以外数组的乘积 一维
 * @see LeetCode2906 构造乘积矩阵 二维
 * <二维前缀>
 * @see LeetCode1314 矩阵区域和
 * @see LeetCode1292 元素和小于等于阈值的正方形的最大边长
 * <差分数组>
 * @see LeetCode1109 航班预订统计
 * @see LeetCode1094 拼车
 * <其他综合>
 * @see LeetCode2947 统计美丽子字符串 I
 */
public class PreSum {

    /**
     * 一维前缀和：s[i] = a[0]+...+a[i-1]，区间 [l,r] 和为 s[r+1]-s[l]。
     */
    public static class PreSum1D {
        long[] s;

        public PreSum1D(int[] a) {
            s = new long[a.length + 1];
            for (int i = 0; i < a.length; i++)
                s[i + 1] = s[i] + a[i];
        }

        // 区间 [l, r] 的和（含端点）
        public long query(int l, int r) {
            return s[r + 1] - s[l];
        }
    }

    /**
     * 二维前缀和：s[i][j] 为左上角到 (i-1,j-1) 的矩形和，区间查询用容斥。
     */
    public static class PreSum2D {
        long[][] s;

        public PreSum2D(int[][] a) {
            int m = a.length, n = a[0].length;
            s = new long[m + 1][n + 1];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    s[i + 1][j + 1] = s[i][j + 1] + s[i + 1][j] - s[i][j] + a[i][j];
        }

        // 矩形 [(r1,c1),(r2,c2)] 的和（含端点）
        public long query(int r1, int c1, int r2, int c2) {
            return s[r2 + 1][c2 + 1] - s[r1][c2 + 1] - s[r2 + 1][c1] + s[r1][c1];
        }
    }

    /**
     * 前缀异或：x[i] = a[0]^...^a[i-1]，区间 [l,r] 异或和为 x[r+1]^x[l]。
     */
    public static class PreXor {
        int[] x;

        public PreXor(int[] a) {
            x = new int[a.length + 1];
            for (int i = 0; i < a.length; i++)
                x[i + 1] = x[i] ^ a[i];
        }

        public int query(int l, int r) {
            return x[r + 1] ^ x[l];
        }
    }

    /**
     * 前缀积：配合后缀积可求"除自身以外的乘积"，避免除法处理 0。
     */
    public static class PreProduct {
        // 返回 res[i] = 所有 a[j] (j != i) 的乘积
        public static int[] productExceptSelf(int[] a) {
            int n = a.length;
            int[] res = new int[n];
            res[0] = 1;
            for (int i = 1; i < n; i++)
                res[i] = res[i - 1] * a[i - 1]; // 前缀积
            int suffix = 1;
            for (int i = n - 1; i >= 0; i--) {
                res[i] *= suffix; // 乘后缀积
                suffix *= a[i];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        PreSum1D p1 = new PreSum1D(new int[]{1, 2, 3, 4, 5});
        System.out.println("sum[1,3] expect 9: " + p1.query(1, 3));
        PreSum2D p2 = new PreSum2D(new int[][]{{1, 2}, {3, 4}});
        System.out.println("rect[(0,0),(1,1)] expect 10: " + p2.query(0, 0, 1, 1));
        PreXor px = new PreXor(new int[]{1, 3, 4, 8});
        System.out.println("xor[1,2] expect 7: " + px.query(1, 2));
        int[] prod = PreProduct.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.print("productExceptSelf expect [24,12,8,6]: [");
        for (int v : prod)
            System.out.print(v + " ");
        System.out.println("]");
    }
}
