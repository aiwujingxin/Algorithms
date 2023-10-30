package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/30 23:56
 */
public class LeetCode135 {

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int n = ratings.length;
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] >= ratings[i]) {
                left[i] = 1;
            } else {
                left[i] = left[i - 1] + 1;
            }
        }
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i + 1] >= ratings[i]) {
                right[i] = 1;
            } else {
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
