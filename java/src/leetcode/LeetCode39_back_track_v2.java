package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/21 22:29
 */
public class LeetCode39_back_track_v2 {

    List<List<Integer>> res;
    List<Integer> list;

    public List<List<Integer>> combinationSum(int[] array, int target) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        backtrack(array, target, 0);
        return res;
    }

    public void backtrack(int[] array, int target, int last) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int money : array) {
            if (money <= target && money >= last) {
                list.add(money);
                backtrack(array, target - money, money);
                list.remove(list.size() - 1);
            }
        }
    }
}
