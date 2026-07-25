package knowledge.mathematics.probability.impl;

import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @description 水库抽样 (Reservoir Sampling)
 * 用于从未知大小或非常大的数据流中，等概率地抽取 K 个元素
 * 空间复杂度 O(K)，时间复杂度 O(N)
 */
public class ReservoirSamplingK {
    private final int k;
    private final int[] reservoir;
    private int count;
    private final Random random;

    public ReservoirSamplingK(int k) {
        this.k = k;
        this.reservoir = new int[k];
        this.count = 0;
        this.random = new Random();
    }

    /**
     * 处理数据流中的一个新元素
     */
    public void add(int value) {
        if (count < k) {
            reservoir[count] = value;
        } else {
            int j = random.nextInt(count + 1);
            if (j < k) {
                reservoir[j] = value;
            }
        }
        count++;
    }

    /**
     * @return 当前抽样结果
     */
    public int[] getReservoir() {
        if (count < k) {
            int[] result = new int[count];
            System.arraycopy(reservoir, 0, result, 0, count);
            return result;
        }
        return reservoir.clone();
    }
}
