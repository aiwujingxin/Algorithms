package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/6 08:34
 */
public class LeetCode1300 {

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + arr[i - 1];
        }
        int l = 0, r = arr[n - 1];
        while (l < r) {
            int m = l + r + 1 >> 1;
            if (cal(arr, s, m) >= target) r = m - 1;
            else l = m;
        }
        int sum1 = cal(arr, s, l);
        int sum2 = cal(arr, s, l + 1);
        return Math.abs(sum1 - target) <= Math.abs(sum2 - target) ? l : l + 1;
    }

    private int cal(int[] arr, int[] s, int value) {
        int n = arr.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r >> 1;
            if (arr[mid] <= value) l = mid + 1;
            else r = mid;
        }
        return s[l] + (n - l) * value;
    }
}
