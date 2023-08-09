package leetcode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/23 13:47
 */
public class LeetCode719_binarysearch {

    //https://leetcode.com/problems/find-k-th-smallest-pair-distance/discuss/1676700/Java-or-Two-Solution-or-Binary-Search-OR-Sliding-Window
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0, hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) { //Find the smallest workable number, i.e. find the first T in a ...FFFFTTTT... sequence
            int mid = lo + (hi - lo) / 2;
            if (cover(nums, mid, k)) {
                hi = mid; //is the number we guess enough to cover k?
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    //Return true if we have enough number to cover k, false otherwise.
    private boolean cover(int[] nums, int guess, int k) {
        int cnt = 0, n = nums.length;
        for (int i = 0; i < n && cnt < k; i++) {
            int lo = i, hi = n - 1;
            while (lo < hi) {
                int mid = lo + (hi - lo + 1) / 2;
                if (nums[mid] <= nums[i] + guess) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            cnt += lo - i;
        }
        return cnt >= k;
    }
}
