package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wujingxinit@outlook.com
 * @date 11/14/25 18:27
 */
public class LeetCode3439 {


    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int max = 0;
        int n = startTime.length;
        int[][] arr = new int[n + 2][2];
        arr[0] = new int[]{0, 0};
        arr[n + 1] = new int[]{eventTime, eventTime};
        for (int i = 0; i < n; i++) {
            arr[i + 1] = new int[]{startTime[i], endTime[i]};
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        int total = 0;
        int sum = 0;
        for (int i = 0; i <= k + 1; i++) {
            total = arr[i][1];
            sum += arr[i][1] - arr[i][0];
            max = Math.max(max, total - sum);
        }
        for (int i = k + 2; i < arr.length; i++) {
            total += arr[i][1] - arr[i - 1][1];
            total -= arr[i - k - 1][1] - arr[i - k - 2][1];
            sum += arr[i][1] - arr[i][0];
            sum -= arr[i - k - 1][1] - arr[i - k - 1][0];
            max = Math.max(max, total - sum);
        }
        return max;
    }
}
