package knowledge.mathematics.probability.impl;

import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 带权水塘抽样 (A-Res, 单元素)
 * <适用场景>
 * 数据流中每个元素带权重 w，要求某元素被最终选中的概率正比于其权重，且只扫描一遍、O(1) 空间。
 * <核心思想>
 * A-Res 算法：为每个元素生成键 key = u^(1/w) (u 为 (0,1] 均匀随机)，保留 key 最大者。
 * 等价于指数竞赛，权重越大键越可能靠近 1。这里维护单个最优元素即 top-1 加权抽样。
 */
public class WeightedReservoirSampling {

    private final Random random;
    private double bestKey;
    private int chosen;
    private boolean hasElement;

    public WeightedReservoirSampling() {
        this(new Random());
    }

    public WeightedReservoirSampling(Random random) {
        this.random = random;
        this.bestKey = -1;
        this.hasElement = false;
    }

    /**
     * 处理流中一个带权元素；权重需为正。
     */
    public void add(int value, double weight) {
        double key = Math.pow(random.nextDouble(), 1.0 / weight);
        if (!hasElement || key > bestKey) {
            bestKey = key;
            chosen = value;
            hasElement = true;
        }
    }

    /**
     * @return 当前按权重抽中的元素
     */
    public int getSample() {
        return chosen;
    }
}
