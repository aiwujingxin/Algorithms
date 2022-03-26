package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-06-21 10:45 下午
 */
public class LeetCode40 {

    public static void main(String[] args) {
        LeetCode40 leetCode40 = new LeetCode40();

        System.out.println(leetCode40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return ans;
        }

        /**
         * [10,1,2,7,6,1,5]
         * 8
         *
         * 首先sort 是为了防止 [1,7][7,1]这样的重复结果
         *
         * */
        Arrays.sort(candidates);

        helper(ans, candidates, target, new ArrayList<>(), 0);

        return ans;

    }

    private void helper(List<List<Integer>> ans, int[] candidates, int target, ArrayList<Integer> temp, int start) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            //本层不能有重复的数字
            /**
             * [10,1,2,7,6,1,5]
             * 8
             *
             * sort 完了之后 加锁 可以防止 [1,7][1`,7]这样的重复结果, 1` ～ 1`` 等重复的数字，都会在当前层的set控制住，不会向下递归，
             * 所以结果里不会出现[1, XXXXX], [1`,XXXX]的情况
             *
             * */
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            // i+1 是为了防止重复结果，不可以选择前面的元素
            helper(ans, candidates, target - candidates[i], temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}
