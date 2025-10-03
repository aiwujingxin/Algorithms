package knowledge.algorithms.dp.backpack.multiple;

import knowledge.algorithms.dp.backpack.multiple.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/25 23:53
 */
public class MultiplePackTest {

    // todo 对数器
    public static void main(String[] args) {
        int[] w = new int[]{1, 2, 3, 4, 2, 3, 4, 3};
        int[] value = new int[]{2, 4, 5, 5, 2, 4, 4, 9};
        int[] cnts = new int[]{3, 1, 3, 2, 2, 2, 1, 2};
        int v = 50;
        System.out.println(new Multiple_dp_1d().backPack(w, value, cnts, v));
        System.out.println(new Multiple_dp_2d().backPack(w, value, cnts, v));
        System.out.println(new Multiple_dq().backPack(w, value, cnts, v));
        System.out.println(new Multiple_bk().backPack(w, value, cnts, v));
        System.out.println(new Multiple_bit().backPack(w, value, cnts, v));
    }
}
