package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/30 13:58
 */
public class LeetCode1753 {

    public int maximumScore(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        int diff = arr[0];
        int canDiff = arr[2] - arr[1];
        arr[2] -= canDiff;
        int chengyuDiff = diff - canDiff;
        if (chengyuDiff > 0) {
            arr[1] -= chengyuDiff / 2;
            arr[2] -= chengyuDiff / 2;
            if (chengyuDiff % 2 == 1) {
                arr[2]--;
            }
            return diff + arr[2];
        }
        return diff + arr[1];
    }
}
