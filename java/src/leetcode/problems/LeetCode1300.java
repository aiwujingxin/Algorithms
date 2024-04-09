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
        int ls = cal(arr, low);
        int us = cal(arr, up);
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
        int l = 0;
        int r = target;
        while (l < r) {
            int mid = l + r >> 1;
            if (cal(arr, mid) < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    // 使 sum <= target 的最大值
    public int rightBound(int[] arr, int target) {
        int l = 0;
        int r = target;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (cal(arr, mid) > target) r = mid - 1;
            else l = mid;
        }
        return l;
    }

    private int cal(int[] arr, int mid) {
        int sum = 0;
        for (int j : arr) {
            sum += Math.min(j, mid);
        }
        return sum;
    }
}
