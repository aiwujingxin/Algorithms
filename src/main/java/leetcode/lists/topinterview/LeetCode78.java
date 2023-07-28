package leetcode.lists.topinterview;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/23 16:57
 */
public class LeetCode78 {

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, 0, nums, new ArrayList<>());
        return list;
    }

    private void dfs(List<List<Integer>> res, int index, int[] nums, ArrayList<Integer> list) {
        if (index > nums.length) {
            return;
        }
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(res, i + 1, nums, list);
            list.remove(list.size() - 1);
        }
    }
}
