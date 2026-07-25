package knowledge.mathematics.probability.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 马尔可夫链 (状态分布演化与稳态)
 * <适用场景>
 * 有限状态随机游走：给定转移矩阵 P（P[i][j]=从 i 到 j 的概率），
 * 求 t 步后分布、长期稳态分布，或吸收态命中概率。
 * <核心思想>
 * t 步分布 = 初始行向量乘 P^t；对遍历链，幂迭代收敛到稳态 π（满足 πP=π）。
 * 这里用幂迭代逼近稳态，避免显式解线性方程组。
 */
public class MarkovChain {

    private final double[][] transition;
    private final int states;

    public MarkovChain(double[][] transition) {
        this.transition = transition;
        this.states = transition.length;
    }

    /**
     * 从初始分布 start 演化 steps 步后的分布。
     */
    public double[] distributionAfter(double[] start, int steps) {
        double[] current = start.clone();
        for (int step = 0; step < steps; step++) {
            double[] next = new double[states];
            for (int i = 0; i < states; i++) {
                if (current[i] == 0) continue;
                for (int j = 0; j < states; j++) {
                    next[j] += current[i] * transition[i][j];
                }
            }
            current = next;
        }
        return current;
    }

    /**
     * 幂迭代逼近稳态分布，迭代 iterations 次后从均匀分布出发的极限。
     */
    public double[] stationary(int iterations) {
        double[] uniform = new double[states];
        for (int i = 0; i < states; i++) uniform[i] = 1.0 / states;
        return distributionAfter(uniform, iterations);
    }
}
