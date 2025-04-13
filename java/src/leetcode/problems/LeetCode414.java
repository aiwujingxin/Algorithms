package leetcode.problems;

import knowledge.algorithms.sort.QuickSelect;
import knowledge.algorithms.sort.QuickSort;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/28 17:44
 */
public class LeetCode414 {

    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        nums = new int[set.size()];
        int index = 0;
        for (int n : set) {
            nums[index] = n;
            index++;
        }
        int res = new QuickSelect().findKthLargest(nums, 3);
        if (nums.length < 3) {
            return nums[0];
        }
        return res;
    }
}
