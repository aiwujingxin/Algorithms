package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/25 20:13
 */
public class LeetCode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res, new ArrayList<>());
        return res;
    }

    /**
     * @param start 通过保证元素之间的相对顺序不变来防止出现重复的子集，start 控制树枝的生长避免产生重复的子集
     * @param list  记录根节点到每个节点的路径的值
     */
    private void backtrack(int[] nums, int start, List<List<Integer>> res, ArrayList<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsets_bit(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i >> j & 1) == 1) {
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }
}
