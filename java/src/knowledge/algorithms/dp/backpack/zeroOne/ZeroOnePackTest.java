package knowledge.algorithms.dp.backpack.zeroOne;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/29 17:15
 */
public class ZeroOnePackTest {

    public static void main(String[] args) {
        System.out.println(new ZeroOne_dp_1d().backPack(new int[]{1, 2, 3, 4}, new int[]{2, 4, 4, 6}, 5));
        System.out.println(new ZeroOne_dp_2d().backPack(new int[]{1, 2, 3, 4}, new int[]{2, 4, 4, 6}, 5));
    }
}
