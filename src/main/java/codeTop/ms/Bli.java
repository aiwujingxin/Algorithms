package codeTop.ms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2022-02-22 12:04 PM
 */
public class Bli {


    public static List<List<Integer>> calV1(int[] coins, int target) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, target, coins, 0, 0, new ArrayList<>());
        return list;
    }

    public static void helper(List<List<Integer>> list, int target, int[] conis, int index, int sum,
            ArrayList<Integer> temp) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < conis.length; i++) {
            temp.add(conis[index]);
            sum = sum + conis[index];
            helper(list, target, conis, i, sum, temp);
            temp.remove(temp.size() - 1);
            sum = sum - conis[index];
        }
    }
}
