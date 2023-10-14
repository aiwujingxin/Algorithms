package leetcode.lists.lcr;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 23:00
 */
public class LCR93 {

    // 和LIS很像
    public int lenLongestFibSubseq(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
        int max = 2;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 寻找到前一个状态
                if (map.containsKey(arr[i] - arr[j]) && map.get(arr[i] - arr[j]) < j) {
                    dp[i][j] = dp[j][map.get(arr[i] - arr[j])] + 1;
                } else {
                    dp[i][j] = 2;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max > 2 ? max : 0;
    }
}
