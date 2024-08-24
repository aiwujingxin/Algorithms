package knowledge.algorithms.dp.backpack.mixed;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/29 22:46
 * @description 混合背包
 */
public interface MixedPack {

    /**
     * @param C 每个物品的体积 C[i]
     * @param W 每个物品的价值 W[i]
     * @param S 每个物品的数量 S[i]
     * @param T 每个物品的类型 0:完全; -1:01背包; >0:多重背包
     * @param V 背包最大容量
     */
    int backPack(int[] C, int[] W, int[] S, int[] T, int V);
}
