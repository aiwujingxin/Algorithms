package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/16 23:30
 */
public class LeetCode46 {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res);
        return res;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> t = new ArrayList<>();
            for (int num : nums) {
                t.add(num);
            }
            res.add(t);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            backtrack(nums, index + 1, res);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int index) {
        int t = nums[i];
        nums[i] = nums[index];
        nums[index] = t;
    }
}

