package leetcode.lists.lcr;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/26 15:39
 */
public class LCR119 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 1;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int t = 1;
                while (set.contains(num + 1)) {
                    t++;
                    num++;
                }
                res = Math.max(res, t);
            }
        }
        return res;
    }
}
