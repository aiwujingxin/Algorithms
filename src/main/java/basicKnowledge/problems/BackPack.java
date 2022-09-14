package basicKnowledge.problems;

import basicKnowledge.algorithm.backtrack.Backpack_BackTrack;
import basicKnowledge.algorithm.dp.Backpack_dp;
import basicKnowledge.algorithm.dp.Backpack_dp_opt;
import basicKnowledge.algorithm.greedy.Backpack_Greedy;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/13 12:23
 */
public interface BackPack {

    //《算法导论》 P243页

    int Backpack(int[] goodsValue, int[] goodsWeight, int packageWeight);

    int[] goodsValue05 = {6, 6, 1, 5, 2, 1, 1, 9, 4, 9, 9, 5, 4, 5, 2};
    int[] weight05 = {3, 8, 3, 9, 4, 6, 6, 3, 9, 2, 9, 8, 1, 9, 7};
    int packageWeight05 = 40;
    int targetValue05 = 50;


    static void main(String[] args) {
        System.out.println(new Backpack_dp().Backpack(goodsValue05, weight05, packageWeight05) == targetValue05);
        System.out.println(new Backpack_BackTrack().Backpack(goodsValue05, weight05, packageWeight05) == targetValue05);
        System.out.println(new Backpack_dp_opt().Backpack(goodsValue05, weight05, packageWeight05) == targetValue05);
        System.out.println(new Backpack_Greedy().Backpack(goodsValue05, weight05, packageWeight05) == targetValue05);
    }
}
