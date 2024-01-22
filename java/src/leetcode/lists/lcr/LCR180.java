package leetcode.lists.lcr;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/13 17:20
 */

public class LCR180 {

    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> res = new ArrayList<>();

        int left = 1;
        int right = left;

        int sum = 0;
        while (right < target) {
            sum += right;
            while (sum > target) {
                sum -= left;
                left++;
            }
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    list.add(i);
                }
                res.add(list);
            }
            right++;
        }

        int[][] result = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            int[] l = new int[res.get(i).size()];
            for (int j = 0; j < res.get(i).size(); j++) {
                l[j] = res.get(i).get(j);
            }
            result[i] = l;
        }
        return result;
    }

}
