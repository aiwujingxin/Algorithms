package basicKnowledge.algorithm.dp;


import basicKnowledge.problems.BackPack;

public class Backpack_dp implements BackPack {

    @Override
    public int Backpack(int[] goodsValue, int[] goodsWeight, int packageWeight) {
        //价值矩阵，列:背包的重量，行:加入的物品
        int[][] dp = new int[packageWeight + 1][goodsValue.length + 1];
        //逐层规划,外层循环表示背包重量增加
        for (int i = 1; i <= packageWeight; i++) {
            //内层循环,遍历物品
            for (int j = 1; j <= goodsValue.length; j++) {
                //如果放入值比背包总重量还大，放弃
                if (goodsWeight[j - 1] > i) { // j - 1表示的是第 j 个物品
                    dp[i][j] = dp[i][j - 1];
                } else {
                    int restWeight = i - goodsWeight[j - 1];//拿了当前物品的背包剩余重量
                    dp[i][j] = Math.max(
                            dp[i][j - 1],//不拿当前物品的解
                            dp[restWeight][j - 1] + goodsValue[j - 1]//选取当前物品+当前重量减去这个物品的最优解
                    );
                }
            }
        }
        return dp[packageWeight][goodsValue.length];
    }
}
