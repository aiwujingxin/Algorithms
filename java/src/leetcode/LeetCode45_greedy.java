package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/8 22:07
 */
public class LeetCode45_greedy {

    //https://leetcode.com/problems/jump-game-ii/discuss/1192401/Easy-Solutions-w-Explanation-or-Optimizations-from-Brute-Force-to-DP-to-Greedy-BFS

    int jump(int[] nums) {
        int i = 0;
        int maxReachable = 0;
        int lastJumpedPos = 0;
        int jumps = 0;
        while (lastJumpedPos < nums.length - 1) {
            maxReachable = Math.max(maxReachable, i + nums[i]);
            if (i == lastJumpedPos) {
                lastJumpedPos = maxReachable;
                jumps++;
            }
            i++;
        }
        return jumps;
    }
}
