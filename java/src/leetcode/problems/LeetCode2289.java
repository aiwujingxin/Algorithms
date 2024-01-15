package leetcode.problems;

import java.util.ArrayDeque;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/14 22:55
 */
public class LeetCode2289 {

    public int totalSteps(int[] nums) {
        var ans = 0;
        var st = new ArrayDeque<int[]>();
        for (var num : nums) {
            var maxT = 0;
            while (!st.isEmpty() && st.peek()[0] <= num)
                maxT = Math.max(maxT, st.pop()[1]);
            maxT = st.isEmpty() ? 0 : maxT + 1;
            ans = Math.max(ans, maxT);
            st.push(new int[]{num, maxT});
        }
        return ans;
    }
}
