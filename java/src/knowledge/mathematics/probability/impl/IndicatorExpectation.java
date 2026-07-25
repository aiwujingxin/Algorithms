package knowledge.mathematics.probability.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 指示变量法求期望 (期望线性性)
 * <适用场景>
 * “期望有多少个 X 满足某性质”类问题：逆序对期望、命中格子期望、匹配对期望等。
 * <核心思想>
 * 把目标计数写成一堆 0/1 指示变量之和 T = Σ I_k，
 * 由期望线性性 E[T] = Σ P(I_k = 1)，即使各事件不独立也成立。
 * 关键在于把整体拆成可单独计算概率的小事件。
 * <示例>
 * 下面给出两个经典封闭式：随机排列的期望逆序对数、以及经典生日碰撞的期望配对数。
 */
public class IndicatorExpectation {

    /**
     * 长度 n 的均匀随机排列，期望逆序对数 = C(n,2) * 1/2 = n(n-1)/4。
     * 每对 (i,j) 逆序的概率恰为 1/2，对所有对求和。
     */
    public static double expectedInversions(int n) {
        return n * (n - 1) / 4.0;
    }

    /**
     * n 个人独立均匀落在 days 天里，期望同生日的对数 = C(n,2) / days。
     * 每对同日概率 1/days，对 C(n,2) 对求和。
     */
    public static double expectedBirthdayCollisions(int n, int days) {
        return (n * (n - 1) / 2.0) / days;
    }

    /**
     * 通用模板：给定每个事件发生概率 probabilities，返回发生总数的期望。
     * 直接对所有概率求和即是期望，无需独立性假设。
     */
    public static double expectedCount(double[] probabilities) {
        double sum = 0;
        for (double p : probabilities) sum += p;
        return sum;
    }
}
