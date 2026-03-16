package leetcode.problems;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wujingxinit@outlook.com
 * @date 3/10/26 22:30
 */
public class LeetCode3767 {

    public long maxPoints(int[] technique1, int[] technique2, int k) {
        int n = technique1.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (technique1[i] >= technique2[i]) {
                cnt++;
            }
        }
        long res = 0;
        if (cnt >= k) {
            for (int i = 0; i < n; i++) {
                res += Math.max(technique1[i], technique2[i]);
            }
            return res;
        }
        int[][] nums = new int[n][4];
        for (int i = 0; i < n; i++) {
            nums[i] = new int[]{technique1[i] - technique2[i], technique1[i], technique2[i]};
        }
        Arrays.sort(nums, (Comparator.comparingInt(o -> o[0])));
        for (int i = 0; i < k; i++) {
            res += nums[i][1];
        }
        for (int i = k; i < n; i++) {
            res += nums[i][2];
        }
        return res;
    }
}
