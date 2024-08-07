package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/7 16:29
 */
public class LeetCode1385 {

    // Checks if the array doesn't contain any value in range (from <= value <= to) using binary search
    private static boolean notInRange(int[] arr, int from, int to) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = l + r >> 1;
            if (arr[mid] >= from && arr[mid] <= to) {
                return false;
            }
            if (arr[mid] < from) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return true;
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int distance = 0;

        for (int val : arr1) {
            if (notInRange(arr2, val - d, val + d)) {
                distance++;
            }
        }

        return distance;
    }
}
