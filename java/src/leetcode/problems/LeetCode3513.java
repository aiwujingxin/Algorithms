package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 8/19/25 22:41
 */
public class LeetCode3513 {

    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        return 1 << (32 - Integer.numberOfLeadingZeros(n));
    }
}
