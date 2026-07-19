package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 5/5/26 13:03
 */
public class LeetCode2568 {

    public int minImpossibleOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int i = 1;
        while (set.contains(i)) {
            i <<= 1; // i 不断乘以 2
        }
        return i;
    }
}
