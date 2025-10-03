package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/17/25 17:05
 */
public class LeetCode476 {

    public int findComplement(int num) {
        int ans = 0;
        for (int i = 0; i < Integer.SIZE - Integer.numberOfLeadingZeros(num); i++) {
            if (((num >> i) & 1) == 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
