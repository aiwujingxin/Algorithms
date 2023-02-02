package basic.problems;

import basic.algorithm.backtrack.Backpack_BackTrack;
import basic.algorithm.dp.Backpack_dp_1d;
import basic.algorithm.dp.Backpack_dp_2d;
import basic.algorithm.greedy.Backpack_Greedy;

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


    int[] goodsValue051 = {6, 6, 1, 5, 4, 5, 2};
    int[] weight051 = {3, 8, 3, 9, 1, 9, 7};
    int packageWeight051 = 20;
    int targetValue051 = 18;

    int[] goodsValue052 = {6, 6, 1, 5, 2, 1, 1, 9, 4, 9, 9, 5, 4, 5, 2};
    int[] weight052 = {3, 8, 3, 9, 4, 6, 6, 3, 9, 2, 9, 8, 1, 9, 7};
    int packageWeight052 = 45;
    int targetValue052 = 53;


    int[] goodsValue053 = {6, 6, 1, 5, 8, 5, 2};
    int[] weight053 = {3, 8, 3, 8, 1, 9, 7};
    int packageWeight053 = 13;
    int targetValue053 = 20;

    int[] goodsValue054 = {6, 10, 5, 10};
    int[] weight0534 = {3, 1, 2, 4};
    int packageWeight054 = 6;
    int targetValue054 = 21;

    static void main(String[] args) {
        System.out.println(new Backpack_dp_2d().Backpack(goodsValue05, weight05, packageWeight05) == targetValue05);
        System.out.println(new Backpack_dp_1d().Backpack(goodsValue05, weight05, packageWeight05) == targetValue05);
        System.out.println(new Backpack_BackTrack().Backpack(goodsValue05, weight05, packageWeight05) == targetValue05);
        System.out.println(new Backpack_Greedy().Backpack(goodsValue05, weight05, packageWeight05) == targetValue05);


        System.out.println(new Backpack_dp_2d().Backpack(goodsValue051, weight051, packageWeight051) == targetValue051);
        System.out.println(new Backpack_dp_2d().Backpack(goodsValue052, weight052, packageWeight052) == targetValue052);
        System.out.println(new Backpack_dp_2d().Backpack(goodsValue053, weight053, packageWeight053) == targetValue053);

    }
}
