package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-06-26 2:19 下午
 */
public class LeetCode78 {

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(new ArrayList<>());
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, int index, ArrayList<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(i);
            helper(nums, res, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
