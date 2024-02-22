package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/20 17:48
 */
public class LeetCode506 {

    public String[] findRelativeRanks(int[] score) {
        if (score == null || score.length == 0) {
            return new String[]{};
        }
        int n = score.length;
        int[][] arr = new int[n][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[]{score[i], i};
        }
        String[] res = new String[n];
        Arrays.sort(arr, (o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res[arr[i][1]] = "Gold Medal";
            } else if (i == 1) {
                res[arr[i][1]] = "Silver Medal";
            } else if (i == 2) {
                res[arr[i][1]] = "Bronze Medal";
            } else {
                res[arr[i][1]] = String.valueOf(i + 1);
            }
        }
        return res;
    }
}
