package leetcode.problems;


/**
 * @author wujingxinit@outlook.com
 * @date 6/19/26 11:12
 */
public class LeetCode1262 {

    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int m1_1 = Integer.MAX_VALUE, m1_2 = Integer.MAX_VALUE;
        int m2_1 = Integer.MAX_VALUE, m2_2 = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            int mod = num % 3;
            if (mod == 1) {
                if (num < m1_1) {
                    m1_2 = m1_1;
                    m1_1 = num;
                } else if (num < m1_2) {
                    m1_2 = num;
                }
            } else if (mod == 2) {
                if (num < m2_1) {
                    m2_2 = m2_1;
                    m2_1 = num;
                } else if (num < m2_2) {
                    m2_2 = num;
                }
            }
        }
        int mod = sum % 3;
        if (mod == 0) {
            return sum;
        }
        if (mod == 1) {
            return sum - Math.min(m1_1, m2_1 + m2_2);
        }
        return sum - Math.min(m2_1, m1_1 + m1_2);
    }
}
