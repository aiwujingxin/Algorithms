package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/8 22:03
 */
public class LeetCode45_brute {

    int jump(int[] nums, int pos) {
        if (pos >= nums.length - 1) {
            return 0;
        }
        int minJumps = 10001;  // initialising to max possible jumps + 1
        for (int j = 1; j <= nums[pos]; j++) {  // explore all possible jump sizes from current position
            minJumps = Math.min(minJumps, 1 + jump(nums, pos + j));
        }
        return minJumps;
    }
}
