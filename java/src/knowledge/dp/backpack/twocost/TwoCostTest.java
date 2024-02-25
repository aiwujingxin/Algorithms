package knowledge.dp.backpack.twocost;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/26 01:06
 */
public class TwoCostTest {

    public static void main(String[] args) {
        int N = 15; // Number of items
        int V = 40; // Max volume
        int W = 30; // Max weight
        int[] volumes = {1, 2, 3, 4, 2, 1, 5, 1, 1, 2, 1, 2, 5, 2, 1, 12, 3, 4, 5, 6, 7, 8, 9, 0, 21, 13, 13, 1, 32}; // Volumes of items
        int[] weights = {2, 4, 4, 5, 3, 2, 4, 5, 3, 2, 2, 3, 6, 3, 3, 12, 13, 5, 6, 7, 13, 4, 5, 1, 7, 1, 12, 42, 3}; // Weights of items
        int[] values1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; // Values of items
        //        int[] values = {3, 4, 5, 6, 4, 3, 3, 2, 5, 2, 4, 5, 2, 5, 7}; // Values of items

        System.out.println(new TwoCost().backPack(N, V, W, volumes, weights, values1));
        System.out.println(new TwoCost().backPack_2d(N, V, W, volumes, weights, values1));
    }

}
