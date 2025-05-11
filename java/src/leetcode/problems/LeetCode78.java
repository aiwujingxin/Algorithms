package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

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
     * @param start 通过保证元素之间的相对顺序不变来防止出现重复的子集
     * @param list  记录根节点到每个节点的路径的值
     */
    private void backtrack(int[] nums, int start, List<List<Integer>> res, List<Integer> list) {
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

    List<List<Integer>> res; // 用于存储所有子集的结果
    List<Integer> track; // 用于存储当前递归路径的子集

    public List<List<Integer>> subsets_bk_v2(int[] nums) {
        res = new ArrayList<>();
        track = new ArrayList<>();
        backtrack(nums, 0);
        return res;
    }

    // 01背包 左分支1代表选择，右分支0 代表不选
    void backtrack(int[] nums, int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        // 选
        track.add(nums[i]);
        backtrack(nums, i + 1);
        // 撤销选择
        track.remove(track.size() - 1);

        // 不选
        backtrack(nums, i + 1);
    }
}
