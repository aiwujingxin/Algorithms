package leetCode.problems;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/25 23:32
 */
public class LeetCode354_poker {


    public static int maxEnvelopes(int[][] matrix) {
        Arrays.sort(matrix, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        return lengthOfLIS(matrix);
    }

    public static int lengthOfLIS(int[][] nums) {
        int N = nums.length;
        int[] top = new int[N];
        // 牌堆数初始化为 0
        int piles = 0;
        for (int[] num : nums) {
            // 要处理的扑克牌
            int poker = num[1];

            /* 搜索左侧边界的二分查找 *****/
            int L = 0, R = piles - 1;
            while (L <= R) {
                int mid = L + ((R - L) >> 1);
                //搜索左侧边界 等于时 R要缩
                if (top[mid] >= poker) {
                    R = mid - 1;
                } else if (top[mid] < poker) {
                    L = mid + 1;
                }
            }

            // 没找到合适的牌堆，新建一堆
            if (L == piles) {
                piles++;
            }

            // 把这张牌放到牌堆顶
            top[L] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }
}
