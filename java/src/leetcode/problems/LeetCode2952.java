package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 7/19/26 15:34
 */
public class LeetCode2952 {


    public static void main(String[] args) {
        System.out.println(new LeetCode2952().minimumAddedCoins(new int[]{1, 4, 10}, 19));
    }

    public int minimumAddedCoins(int[] coins, int target) {
        // 1. 预处理：将已有的硬币从小到大排序，便于我们从小到大扫描并填补孔缺

        Arrays.sort(coins);

        int addedCoins = 0; // 记录需要添加的硬币数量
        int i = 0;          // 遍历已有 coins 的指针

        // s 代表当前我们【无法拼凑出的最小整数】（即当前面临的第一个“孔缺”）
        // 初始时，我们连 1 都拼不出来，所以孔缺 s 从 1 开始
        int s = 1;

        // 2. 逐步向右扫描，直到能够覆盖到 target
        while (s <= target) {
            // 如果已有的硬币中，有面值小于或等于当前孔缺 s 的硬币
            if (i < coins.length && coins[i] <= s) {
                // 我们可以直接利用这个硬币，将可表示的区间向右扩展
                s += coins[i];
                i++;
            } else {
                // 如果没有合适的已有硬币，说明在 s 处彻底断档（出现了孔缺）
                // 此时，我们必须【主动添加】一个面值为 s 的硬币来填补这个孔缺
                addedCoins++;
                // 填补后，可表示区间翻倍，孔缺位置 s 相当于左移了一位：s = s * 2
                s <<= 1;
            }
            System.out.println(s);
        }
        return addedCoins;
    }
}
