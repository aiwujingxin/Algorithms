package leetcode.problems;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2021-06-21 11:55 下午
 */
public class LeetCode47_set {

    public static void main(String[] args) {
        LeetCode47_set leetCode47 = new LeetCode47_set();
        System.out.println(leetCode47.permuteUnique(new int[]{1, 2, 2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }
        backtrack(0, res, nums);
        return res;
    }

    private void backtrack(int depth, List<List<Integer>> res, int[] nums) {
        if (depth == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            res.add(new ArrayList<>(temp));
            return;
        }
        HashSet<Integer> visited = new HashSet<>();
        for (int i = depth; i < nums.length; i++) {
            if (visited.contains(nums[i])) {
                continue;
            }
            visited.add(nums[i]);

            swap(nums, depth, i);
            backtrack(depth + 1, res, nums);
            swap(nums, depth, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
