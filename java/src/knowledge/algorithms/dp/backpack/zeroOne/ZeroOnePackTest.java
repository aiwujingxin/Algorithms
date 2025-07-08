package knowledge.algorithms.dp.backpack.zeroOne;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/29 17:15
 */
public class ZeroOnePackTest {

    public static void main(String[] args) {
        int[] C = new int[]{1, 2, 3, 4};
        int[] W = new int[]{2, 4, 4, 6};
        int V = 5;
        System.out.println(new ZeroOne_backtrack().backPack(C, W, V));
        System.out.println(new ZeroOne_branch_bound().backPack(C, W, V));
        System.out.println(new ZeroOne_dp_1d().backPack(C, W, V));
        System.out.println(new ZeroOne_dp_2d().backPack(C, W, V));
    }
}
