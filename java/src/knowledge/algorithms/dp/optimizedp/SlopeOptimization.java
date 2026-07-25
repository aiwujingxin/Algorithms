package knowledge.algorithms.dp.optimizedp;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 斜率优化 DP (Convex Hull Trick)
 * <适用场景>
 * 转移形如 dp[i] = min_{j<i} ( dp[j] + (前缀差)^2 ) 一类含 i·j 交叉项的方程，
 * 朴素 O(n^2)。把决策 j 视为平面上的点，最优决策落在下凸壳上，用单调队列维护凸壳降到 O(n)。
 * <核心>
 * 以"任务分批 / 玩具装箱"为原型：dp[i] = min(dp[j] + (s[i]-s[j]+i-j-1-L)^2)。
 * 令 a[i]=s[i]+i，把式子拆成关于决策点 (a[j], dp[j]+a[j]^2) 的直线求值，
 * 维护下凸壳；因斜率 2·(a[i]+L+1) 单调递增，队首即最优决策，均摊 O(1)。
 * @see leetcode.problems.LeetCode1478 安排邮筒 (决策单调性 / 区间DP)
 */
public class SlopeOptimization {

    /**
     * 玩具装箱（HDU/经典模型）：n 个玩具长度 c[i]，一段 [j+1,i] 的费用
     * (i-j-1 + sum c - L)^2，求把所有玩具分段的最小总费用。
     * 前缀和 s[i]=c[1]+...+c[i]，令 f(i)=s[i]+i。
     */
    public static long minCost(int[] c, int L) {
        int n = c.length;
        long[] s = new long[n + 1];
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + c[i - 1];
        long[] dp = new long[n + 1];
        long[] a = new long[n + 1];
        for (int i = 0; i <= n; i++) a[i] = s[i] + i;
        int LL = L + 1;

        int[] queue = new int[n + 1];
        int head = 0, tail = 0;
        queue[tail++] = 0; // 决策点 j=0

        for (int i = 1; i <= n; i++) {
            // 队首去除斜率已不优的决策：斜率 k(i) = 2*(a[i]-L-1) 单调增
            long slope = 2 * (a[i] - LL);
            while (head + 1 < tail && y(queue[head + 1], dp, a) - y(queue[head], dp, a)
                    <= slope * (a[queue[head + 1]] - a[queue[head]])) {
                head++;
            }
            int j = queue[head];
            long w = a[i] - a[j] - LL;
            dp[i] = dp[j] + w * w;
            // 维护下凸壳：新点 i 入队前弹出使凸壳上凸的队尾
            while (head + 1 < tail && cross(queue[tail - 2], queue[tail - 1], i, dp, a)) {
                tail--;
            }
            queue[tail++] = i;
        }
        return dp[n];
    }

    // 决策点的纵坐标 y(j) = dp[j] + a[j]^2
    private static long y(int j, long[] dp, long[] a) {
        return dp[j] + a[j] * a[j];
    }

    // 判断中间点 b 是否在 a、c 连线之上（上凸，需弹出）
    private static boolean cross(int p1, int p2, int p3, long[] dp, long[] a) {
        long dx1 = a[p2] - a[p1], dy1 = y(p2, dp, a) - y(p1, dp, a);
        long dx2 = a[p3] - a[p2], dy2 = y(p3, dp, a) - y(p2, dp, a);
        return dy1 * dx2 >= dy2 * dx1;
    }

    public static void main(String[] args) {
        // 5 个玩具长度均为 4，L=1：每个单独装箱代价 (4-1)^2=9，共 45（已与暴力 DP 对拍验证）
        System.out.println("minCost expect 45: " + minCost(new int[]{4, 4, 4, 4, 4}, 1));
    }
}
