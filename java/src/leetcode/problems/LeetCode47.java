package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/19 15:12
 */
public class LeetCode47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), res, used);
        return res;
    }

    void backtrack(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            backtrack(nums, list, res, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
