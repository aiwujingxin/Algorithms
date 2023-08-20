package leetcode;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/23 13:45
 */
public class LeetCode719_slidingwindow {


    //https://leetcode.com/problems/find-k-th-smallest-pair-distance/discuss/1676700/Java-or-Two-Solution-or-Binary-Search-OR-Sliding-Window
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0, hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {//Find the smallest workable number, i.e. find the first T in a ...FFFFTTTT... sequence
            int mid = lo + (hi - lo) / 2;
            if (cover(nums, mid, k)) {
                hi = mid; //is the number we guess enough to cover k?}
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    //Return true if we have enough number to cover k, false otherwise.
    private boolean cover(int[] nums, int guess, int k) {
        int cnt = 0;
        for (int i = 0, j = 0; i < nums.length && cnt < k; i++) { //j = left end, i = right end
            while (nums[i] - nums[j] > guess) {
                j++;
            }
            cnt += i - j; //For every pair that ends at i, there are (j, i), (j + 1, i), ..., (i - 1, i) = i - j pairs
        }
        return cnt >= k;
    }
}
