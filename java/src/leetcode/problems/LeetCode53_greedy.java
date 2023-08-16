package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/12 21:29
 */
public class LeetCode53_greedy {

    //https://leetcode.cn/problems/maximum-subarray/solution/by-nehzil-rmeh/

    //https://leetcode.com/problems/maximum-subarray/discuss/1595369/Java-Greedy-and-DP-solutions
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, currMax = 0;
        for (int num : nums) {
            currMax = Math.max(num, currMax + num);
            max = Math.max(currMax, max);
        }
        return max;
    }
}
