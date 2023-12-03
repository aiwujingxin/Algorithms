package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/20 10:09
 */
public class LeetCode40 {
    /*
     * [10,1,2,7,6,1,5]
     * 8
     * 首先sort 是为了防止 [1,7][7,1]这样的重复结果
     * sort 完了之后 加锁 可以防止 [1,7][1`,7]这样的重复结果, 1` ～ 1`` 等重复的数字，都会在当前层的set控制住，不会向下递归，
     * 所以结果里不会出现[1, XXXXX], [1`,XXXX]的情况
     * */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int index, int target, List<Integer> list, List<List<Integer>> res) {
        // 不能有这个限制
//        if (index == candidates.length) {
//            return;
//        }
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < candidates.length; i++) {
            if (set.contains(candidates[i])) {
                continue;
            }
            set.add(candidates[i]);
            list.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], list, res);
            list.remove(list.size() - 1);
        }
    }
}
