package leetcode.problems;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/25 22:16
 * @see LeetCode300_greedy
 */
public class LeetCode354 {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        int[] dp = new int[envelopes.length];
        int len = 0;
        for (int[] envelope : envelopes) {
            int num = envelope[1];
            int left = 0;
            int right = len;
            while (left < right) {
                int mid = (left + right) / 2;
                if (dp[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (len == right) {
                len++;
            }
            dp[left] = num;
        }
        return len;
    }
}
