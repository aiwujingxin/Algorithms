package knowledge.algorithms.dp.backpack.twocost;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/26 01:06
 */
public class TwoCostPackTest {

    public static void main(String[] args) {
        int N = 36; // Number of items
        int V = 100; // Max volume
        int W = 58; // Max weight
        int[] volumes = {1, 2, 3, 4, 2, 1, 5, 1, 1, 2, 1, 2, 5, 2, 1, 12, 3, 4, 5, 6, 7, 8, 9, 0, 21, 13, 13, 1, 32, 1, 1, 2, 1, 2, 5, 2}; // Volumes of items
        int[] weights = {2, 4, 4, 5, 3, 2, 4, 5, 3, 2, 2, 3, 6, 3, 3, 12, 13, 5, 6, 7, 13, 4, 5, 1, 7, 1, 12, 42, 3, 1, 1, 2, 1, 2, 5, 2}; // Weights of items
        int[] values = {1, 1, 1, 1, 1, 2, 5, 2, 1, 12, 3, 4, 6, 1, 1, 1, 1, 13, 4, 5, 1, 7, 1, 12, 42, 3, 1, 11, 1, 1, 1, 1, 1, 3, 4, 5}; // Values of items
        System.out.println(new TwoCost_dp_2d().backPack(N, V, W, volumes, weights, values));
        System.out.println(new TwoCost_dp_3d().backPack(N, V, W, volumes, weights, values));
    }
}
