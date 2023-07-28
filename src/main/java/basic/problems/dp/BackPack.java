package basic.problems.dp;

import basic.algorithm.dp.backpack.zeroOnePack.ZeroOnePack_backtrack;
import basic.algorithm.dp.backpack.zeroOnePack.ZeroOnePack_branch_bound;
import basic.algorithm.dp.backpack.zeroOnePack.ZeroOnePack_dfs_memo;
import basic.algorithm.dp.backpack.zeroOnePack.ZeroOnePack_dp_2d;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/13 12:23
 */
public interface BackPack {

    int w = 32;
    int[] weight = new int[]{2, 3, 5, 7, 3, 4, 5, 3, 2, 4, 5, 6, 7, 8, 9, 6, 5, 4, 3, 2, 7, 8};
    int[] goodsValue = new int[]{1, 5, 2, 4, 8, 5, 3, 7, 8, 1, 4, 3, 6, 5, 2, 5, 7, 3, 8, 9, 7, 2};
    int ans = 64;

    static void main(String[] args) {
        System.out.println(new ZeroOnePack_backtrack().backPack(w, weight, goodsValue) == ans);
        System.out.println(new ZeroOnePack_branch_bound().backPack(w, weight, goodsValue) == ans);
        System.out.println(new ZeroOnePack_dp_2d().backPack(w, weight, goodsValue) == ans);
        System.out.println(new ZeroOnePack_dp_2d().backPack(w, weight, goodsValue) == ans);
        System.out.println(new ZeroOnePack_dfs_memo().backPack(w, weight, goodsValue) == ans);
        System.out.println(new basic.algorithm.greedy.Backpack_Greedy().backPack(w, weight, goodsValue) == ans);
    }

    //《算法导论》 P243页
    int backPack(int packageWeight, int[] goodsWeight, int[] goodsValue);
}
