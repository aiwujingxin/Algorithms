package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 5/27/26 23:43
 */
public class LeetCode2453 {

    public int destroyTargets(int[] nums, int space) {
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int mod = num % space;
            map.computeIfAbsent(mod, k -> new ArrayList<>()).add(num);
        }
        int max = 0;
        int mod = 0;
        int value = -1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
                mod = entry.getKey();
                value = entry.getValue().getFirst();
            } else if (entry.getValue().size() == max) {
                if (entry.getValue().getFirst() < value) {
                    mod = entry.getKey();
                    value = entry.getValue().getFirst();
                }
            }
        }
        for (int num : nums) {
            if (mod == num % space) {
                ans = Math.min(num, ans);
            }
        }
        return ans;
    }
}
