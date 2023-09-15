package leetcode.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 13:17
 */

public class Offer3 {

    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return n;
            }
            set.add(n);
        }
        return -1;
    }
}
