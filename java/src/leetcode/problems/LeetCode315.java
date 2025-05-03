package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023.11.10 00:59
 */
public class LeetCode315 {

    int[][] t;
    int[] counts;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][];
        t = new int[n][];
        counts = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{nums[i], i};
        }
        mergeSort(arr, 0, n - 1);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(counts[i]);
        }
        return list;
    }

    public void mergeSort(int[][] nums, int l, int r) {
        if (l >= r) return;
        int m = l + r >> 1;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        merge(nums, l, m, r);
    }

    public void merge(int[][] nums, int l, int m, int r) {
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            if (nums[i][0] <= nums[j][0]) {
                counts[nums[i][1]] += j - m - 1;
                t[k++] = nums[i++];
            } else {
                t[k++] = nums[j++];
            }
        }
        while (i <= m) {
            counts[nums[i][1]] += j - m - 1;
            t[k++] = nums[i++];
        }
        while (j <= r) t[k++] = nums[j++];
        for (i = l; i <= r; i++) nums[i] = t[i];
    }
}
