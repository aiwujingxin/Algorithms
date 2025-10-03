package leetcode.problems;

import java.util.Collections;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 7/29/25 13:11
 */
public class LeetCode2860 {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int n = nums.size(), cnt = 0;
        // 判断 i == 0 的情况
        if (nums.get(0) > 0) {
            cnt++;
        }
        for (int i = 0; i < n - 1; i++) {
            int k = i + 1;
            if (nums.get(i) < k && k < nums.get(i + 1)) {
                cnt++;
            }
        }
        // 判断 i == n - 1 的情况
        if (nums.get(n - 1) < n) {
            cnt++;
        }
        return cnt;
    }
}
