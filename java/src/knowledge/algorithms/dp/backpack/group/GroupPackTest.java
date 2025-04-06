package knowledge.algorithms.dp.backpack.group;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/27 01:29
 */
public class GroupPackTest {

    public static void main(String[] args) {
        int[][] weights = {{2, 1}, {3, 2}, {1, 2, 3}, {2, 2}, {1, 2, 3, 4, 5}};
        int[][] values = {{3, 2}, {4, 2}, {2, 3, 4}, {1, 2}, {1, 1, 3, 4, 5}};
        int[] k = new int[]{2, 2, 3, 2, 5};
        int capacity = 9;
        System.out.println(new GroupPack_dp_1d().backPack(4, capacity, k, weights, values));
        System.out.println(new GroupPack_dp_2d().backPack(4, capacity, k, weights, values));
        System.out.println(new GroupPack_dp_3d().backPack(4, capacity, k, weights, values));
    }
}
