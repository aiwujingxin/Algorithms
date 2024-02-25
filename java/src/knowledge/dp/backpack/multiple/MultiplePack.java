package knowledge.dp.backpack.multiple;

import knowledge.dp.backpack.lintcode.BackpackVII;
import knowledge.dp.backpack.lintcode.BackpackVIII;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 00:03
 * @description 多重背包
 * @see BackpackVII
 * @see BackpackVIII
 */
public interface MultiplePack {
    int backPack(int[] weights, int[] values, int[] counts, int capacity);
}
