package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/5 12:16
 */
public class LeetCode416_dfs_MEL {

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        List<List<Integer>> list = new ArrayList<>();
        helper(nums, list, 0, new ArrayList<>(), sum);
        for (List<Integer> temp : list) {
            int tSum = temp.stream().mapToInt(Integer::intValue).sum();
            if (tSum == sum - tSum) {
                return true;
            }
        }
        return false;
    }

    private void helper(int[] nums, List<List<Integer>> res, int index, ArrayList<Integer> temp, int sum) {
        res.add(new ArrayList<>(temp));
        int s = 0;
        for (int num : temp) {
            s += num;
        }
        if (s * 2 > sum) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, res, i + 1, temp, sum);
            temp.remove(temp.size() - 1);
        }
    }
}
