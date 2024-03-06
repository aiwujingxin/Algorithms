package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/6 08:34
 */
public class LeetCode1300 {

    public int findBestValue(int[] arr, int target) {
        int sum = 0;
        int max = 0;
        for (int j : arr) {
            sum += j;
            max = Math.max(max, j);
        }
        if (sum < target) {
            return max;
        }
        int low = leftBound(arr, target);
        int up = rightBound(arr, target);
        int ls = check(arr, low);
        int us = check(arr, up);
        if (Math.abs(ls - target) < Math.abs(us - target)) {
            return low;
        }
        if (Math.abs(ls - target) > Math.abs(us - target)) {
            return up;
        }
        return Math.min(low, up);
    }

    // 使 sum >= target 的最小值
    public int leftBound(int[] arr, int target) {
        int left = 0;
        int right = target;
        while (left < right) {
            int mid = (left + right) / 2;
            int t = check(arr, mid);
            if (t < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // 使 sum <= target 的最大值
    public int rightBound(int[] arr, int target) {
        int left = 0;
        int right = target;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            int t = check(arr, mid);
            if (t > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    private int check(int[] arr, int mid) {
        int sum = 0;
        for (int j : arr) {
            sum += Math.min(j, mid);
        }
        return sum;
    }
}
