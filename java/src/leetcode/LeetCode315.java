package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/7 00:13
 */
//https://leetcode.com/problems/count-of-smaller-numbers-after-self/solutions/76578/merge-sort-based-solution-java-easy-to-understand/
public class LeetCode315 {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] indexes = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i;
            res.add(0);
        }
        mergesort(nums, indexes, res, 0, nums.length - 1);
        return res;
    }

    private void mergesort(int[] nums, int[] indexes, List<Integer> res, int start, int end) {
        if (end <= start) return;

        int mid = start + ((end - start) >> 1);
        mergesort(nums, indexes, res, start, mid);
        mergesort(nums, indexes, res, mid + 1, end);

        int l = start, r = mid + 1, p = 0;
        int reversecount = 0;
        int[] tmp = new int[end - start + 1];

        for (; l <= mid; l++, p++) {
            while (r <= end && nums[indexes[r]] < nums[indexes[l]]) {
                tmp[p++] = indexes[r++];
                reversecount++;
            }
            tmp[p] = indexes[l];
            res.set(indexes[l], res.get(indexes[l]) + reversecount);
        }

        if (p >= 0) System.arraycopy(tmp, 0, indexes, start, p);
    }
}
