package knowledge.algorithms.dp.probabilitydp;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 概率期望 DP (Probability & Expectation DP)
 * <解题识别>
 * 涉及随机过程的期望步数 / 概率分布，用 DP 递推。核心是"期望的线性性"：E[总]=ΣE[分]。
 * <两个方向>
 * 1) 概率 DP：一般顺推，dp[到达某状态的概率] = Σ 前驱概率 × 转移概率。
 * 2) 期望 DP：一般逆推，从终止态（期望 0）倒推，dp[i] = Σ p·(dp[j]+代价)。
 * <核心>
 * 期望常需解方程（自环时移项）。掷骰子到达终点的期望步数是最小原型。
 * @see knowledge.mathematics.probability.impl.IndicatorExpectation 指示器 + 期望线性性
 * @see knowledge.algorithms.dp.DP 动态规划总纲
 */
public class ExpectationDP {

    /**
     * 掷一枚均匀 m 面骰子，从位置 0 走到 ≥ n 的期望步数。
     * 逆推：E[i] = 1 + (1/m)·Σ_{d=1..m} E[i+d]，E[i]=0 当 i>=n。
     */
    public static double expectedSteps(int n, int m) {
        double[] e = new double[n + m + 1];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int d = 1; d <= m; d++) sum += e[i + d];
            e[i] = 1 + sum / m;
        }
        return e[0];
    }

    /**
     * 收集所有 n 种优惠券（每次等概率抽一种）的期望次数（Coupon Collector）。
     * E = n·(1 + 1/2 + ... + 1/n)，用期望线性性直接求和。
     */
    public static double couponCollector(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) sum += 1.0 / i;
        return n * sum;
    }

    /**
     * 抛硬币直到出现连续 k 个正面的期望抛掷次数（正面概率 p）。
     * E[i] 表示已连续 i 个正面到达目标的期望：E[i] = 1 + p·E[i+1] + (1-p)·E[0]，解得闭式。
     */
    public static double consecutiveHeads(int k, double p) {
        // 已知闭式：E = (1 - p^k) / (p^k · (1-p))
        double pk = Math.pow(p, k);
        return (1 - pk) / (pk * (1 - p));
    }

    public static void main(String[] args) {
        // 6 面骰子走到 >=1：一步必达，期望 1
        System.out.println("expectedSteps(1,6) expect 1.0: " + expectedSteps(1, 6));
        System.out.printf("couponCollector(6) expect 14.7: %.4f%n", couponCollector(6));
        // 连续 2 个正面，公平硬币：期望 6
        System.out.printf("consecutiveHeads(2,0.5) expect 6.0: %.4f%n", consecutiveHeads(2, 0.5));
    }
}
