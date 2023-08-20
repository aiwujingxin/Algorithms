package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/17 17:03
 */
public class LeetCode90_set {
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
        HashSet<Integer> visited = new HashSet<>();

        for (int i = index; i < nums.length; i++) {
            if (visited.contains(nums[i])) {
                continue;
            }
            visited.add(nums[i]);

            temp.add(nums[i]);
            helper(nums, i + 1, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
