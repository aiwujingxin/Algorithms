package leetcode.lists.LCR;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 01:45
 */
public class LCR84 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }
        backtrack(0, res, nums);
        return res;
    }

    private void backtrack(int index, List<List<Integer>> res, int[] nums) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            res.add(new ArrayList<>(temp));
            return;
        }
        HashSet<Integer> visited = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (visited.contains(nums[i])) {
                continue;
            }
            visited.add(nums[i]);
            swap(nums, index, i);
            backtrack(index + 1, res, nums);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
