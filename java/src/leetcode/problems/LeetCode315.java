package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023.11.10 00:59
 */
public class LeetCode315 {

    int[][] temp;
    int[] counts;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][];
        temp = new int[n][];
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

    public void mergeSort(int[][] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    public void merge(int[][] arr, int lo, int mid, int hi) {
        int i = lo;
        int k = lo;
        int j = mid + 1;

        while (i <= mid && j <= hi) {
            if (arr[i][0] <= arr[j][0]) {
                counts[arr[i][1]] += j - mid - 1;
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            counts[arr[i][1]] += j - mid - 1;
            temp[k++] = arr[i++];
        }

        while (j <= hi) {
            temp[k++] = arr[j++];
        }

        for (int x = lo; x <= hi; x++) {
            arr[x] = temp[x];
        }
    }
}
