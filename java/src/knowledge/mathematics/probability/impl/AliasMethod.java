package knowledge.mathematics.probability.impl;

import java.util.Random;

/**
 *
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description AliasMethod
 * 别名方法 (Alias Method)
 * 用于在 O(1) 时间内从给定的离散概率分布中进行采样
 * 预处理时间复杂度 O(N)，空间复杂度 O(N)
 */
public class AliasMethod {
    private final int[] alias;
    private final double[] prob;
    private final Random random;

    public AliasMethod(double[] probabilities) {
        int n = probabilities.length;
        alias = new int[n];
        prob = new double[n];
        random = new Random();

        int[] small = new int[n];
        int[] large = new int[n];
        int smallCount = 0, largeCount = 0;

        for (int i = 0; i < n; i++) {
            prob[i] = probabilities[i] * n;
            if (prob[i] < 1.0) {
                small[smallCount++] = i;
            } else {
                large[largeCount++] = i;
            }
        }

        while (smallCount > 0 && largeCount > 0) {
            int l = small[--smallCount];
            int g = large[--largeCount];

            alias[l] = g;
            prob[g] = (prob[g] + prob[l]) - 1.0;

            if (prob[g] < 1.0) {
                small[smallCount++] = g;
            } else {
                large[largeCount++] = g;
            }
        }

        while (largeCount > 0) {
            prob[large[--largeCount]] = 1.0;
        }
        while (smallCount > 0) {
            prob[small[--smallCount]] = 1.0;
        }
    }

    /**
     * @return 采样得到的下标
     */
    public int next() {
        int column = random.nextInt(prob.length);
        boolean coinToss = random.nextDouble() < prob[column];
        return coinToss ? column : alias[column];
    }
}
