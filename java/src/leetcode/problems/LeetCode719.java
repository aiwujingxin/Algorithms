package leetcode.problems;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/23 13:47
 */
public class LeetCode719 {

    //https://leetcode.com/problems/find-k-th-smallest-pair-distance/discuss/1676700/Java-or-Two-Solution-or-Binary-Search-OR-Sliding-Window
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums[nums.length - 1] - nums[0];
        while (l < r) { //Find the smallest workable number, i.e. find the first T in a ...FFFFTTTT... sequence
            int mid = l + r >> 1;
            if (check(nums, mid, k)) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    //Return true if we have enough number to cover k, false otherwise.
    private boolean check(int[] nums, int guess, int k) {
        int cnt = 0, n = nums.length;
        for (int i = 0; i < n && cnt < k; i++) {
            int l = i;
            int r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (nums[mid] > nums[i] + guess) r = mid - 1;
                else l = mid;
            }
            cnt += l - i;
        }
        return cnt < k;
    }
}
