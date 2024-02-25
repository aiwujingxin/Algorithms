package knowledge.dp.backpack.group;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/7 02:25
 * @description 分组背包
 */
public interface GroupPack {

    int groupKnapsack(int n, int V, int[] groupSizes, int[][] values, int[][] weights);
}
