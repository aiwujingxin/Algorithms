package leetcode.problems;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/25 22:16
 */
public class LeetCode354_dp_binary_v2 {

    public static void main(String[] args) {
        System.out.println(new LeetCode354_dp_binary_v2().maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    }

    //https://leetcode.com/problems/russian-doll-envelopes/discuss/1134006/My-Java-Solution-using-Sort-and-Longest-Increasing-Subsequence-concept
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int result = 0;
        for (int[] e : envelopes) {
            int index = Arrays.binarySearch(dp, 0, result, e[1]);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = e[1];
            if (index == result) {
                result += 1;
            }
        }
        return result;
    }
}
