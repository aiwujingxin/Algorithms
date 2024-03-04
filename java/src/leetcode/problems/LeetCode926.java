package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/4 10:51
 */
public class LeetCode926 {

    public int minFlipsMonoIncr(String s) {
        char[] chars = s.toCharArray();
        int zero = chars[0] == '0' ? 0 : 1;
        int one = chars[0] == '0' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            int pre_zero = zero;
            int pre_one = one;
            if (chars[i] == '1') {
                zero = pre_zero + 1;
                one = Math.min(pre_one, pre_zero);
            } else {
                one = Math.min(pre_zero, pre_one + 1);
            }
        }
        return Math.min(zero, one);
    }
}
