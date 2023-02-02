package basic.algorithm.backtrack;


import basic.problems.BackPack;

public class Backpack_BackTrack implements BackPack {

    /**
     * Goods[] goods;     物品数组
     * int BackpackValue; 背包整体最佳价值
     * int BackpackRealValue;背包实际重量
     */
    int BackpackValue;
    int tempValue;

    @Override
    public int Backpack(int[] goodsValue, int[] weight, int packageWeight) {
        count(0, 0, packageWeight, goodsValue, weight);
        return BackpackValue;
    }

    public void count(int depth, int sum, int packageWeight, int[] goodsValue, int[] weight) {
        if (sum > packageWeight) {
            return;
        }
        BackpackValue = Math.max(BackpackValue, tempValue);
        for (int i = depth; i < goodsValue.length; i++) {
            tempValue += goodsValue[i];
            sum += weight[i];
            //注意此处是i+1，不是depth+1
            count(i + 1, sum, packageWeight, goodsValue, weight);
            tempValue -= goodsValue[i];
            sum -= weight[i];
        }
    }
}
