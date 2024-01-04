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

    public void backtrack(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝逻辑，固定相同的元素在排列中的相对位置 保证相同元素在排列中的相对位置保持不变： 2 -> 2' -> 2''
            //!used[i - 1] 这种剪枝逻辑剪得干净利落, 从源头就剪掉了
            // used[i - 1] 仅仅维护了 2'' -> 2' -> 2 的相对顺序
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                // 如果前面的相邻相等元素没有用过，则跳过; 2' 只有在 2 已经被使用的情况下才会被选择
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            backtrack(nums, list, res, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
