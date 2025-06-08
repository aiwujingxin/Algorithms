package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/30 23:56
 */
public class LeetCode135 {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        // 从左往右扫，保证右边比左边大糖果数多
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        // 从右往左扫，保证左边比右边大糖果数多
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.max(left[i], right[i]);
        }
        return res;
    }
}
