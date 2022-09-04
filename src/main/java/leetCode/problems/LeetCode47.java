package leetCode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-06-21 11:55 下午
 */
public class LeetCode47 {

    public static void main(String[] args) {
        LeetCode47 leetCode47 = new LeetCode47();
        System.out.println(leetCode47.permuteUnique(new int[]{1, 2, 2, 2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        helper(res, nums, new HashSet<>(), new ArrayList<>());
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, HashSet<Integer> visited,
            ArrayList<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited.contains(i - 1)) {
                continue;
            }
            temp.add(nums[i]);
            visited.add(i);
            helper(res, nums, visited, temp);
            temp.remove(temp.size() - 1);
            visited.remove(i);
        }
    }

}
