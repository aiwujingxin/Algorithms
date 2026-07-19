package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 5/4/26 15:53
 */
public class LeetCode3478 {

    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{nums1[i], i, nums2[i]};
        }
        Arrays.sort(arr, (Comparator.comparingInt(o -> o[0])));
        int[] nums = new int[n];
        long sum = 0;
        long[] preK = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = arr[i][2];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
            sum += nums[i];
            preK[i] = sum;
        }
        for (int i = k; i < n; i++) {
            pq.add(nums[i]);
            sum += nums[i];
            sum -= pq.poll();
            preK[i] = sum;
        }
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            int index = findR(arr, arr[i][0]);
            if (index == -1) continue;
            ans[arr[i][1]] = preK[index];
        }
        return ans;
    }

    int findR(int[][] a, int x) {
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (a[mid][0] >= x) r = mid - 1;
            else l = mid;
        }
        if (a[l][0] >= x) return -1;
        return l;
    }
}
