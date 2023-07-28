package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-06-30 11:04 下午
 */
public class LeetCode90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        helper(nums, 0, res, new ArrayList<>());

        return res;
    }

    private void helper(int[] nums, int index, List<List<Integer>> res, ArrayList<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int i = 0; i < nums.length; i++) {

            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            helper(nums, index + 1, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
