package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/11 19:08
 */
public class LeetCode78 {

    public List<List<Integer>> subsets(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, 0, res, new ArrayList<>());

        return res;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> res, ArrayList<Integer> temp) {
        res.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, i + 1, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
