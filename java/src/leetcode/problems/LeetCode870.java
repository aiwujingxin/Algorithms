package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 23:42
 */
public class LeetCode870 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] arr1 = new int[n][2];
        int[][] arr2 = new int[n][2];
        for (int i = 0; i < n; i++) arr1[i] = new int[]{nums1[i], i};
        for (int i = 0; i < n; i++) arr2[i] = new int[]{nums2[i], i};
        Arrays.sort(arr1, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(arr2, Comparator.comparingInt(o -> o[0]));
        int[] ans = new int[n];
        boolean[] vs = new boolean[n];
        Arrays.fill(ans, -1);
        int i = 0;
        int j = 0;
        while (i < n) {
            if (arr1[i][0] > arr2[j][0]) {
                ans[arr2[j][1]] = arr1[i][0];
                vs[arr1[i][1]] = true;
                j++;
            }
            i++;
        }
        int x = 0;
        int y = 0;
        while (x < n && y < n) {
            while (x < n && vs[x]) {
                x++;
            }
            while (y < n && ans[y] != -1) {
                y++;
            }
            if (y < n) {
                ans[y] = nums1[x];
                y++;
                x++;
            }
        }
        return ans;
    }

    public void swap(int[] x, int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }
}
