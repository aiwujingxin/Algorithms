package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 11/16/25 18:24
 */
public class LeetCode1513 {
    int mod = 1_000_000_007;

    public int numSub(String s) {
        long sum = 0;
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == '1') {
                int j = index;
                while (j < s.length() && s.charAt(j) == '1') {
                    j++;
                }
                long cnt = j - index;
                sum = (((1 + cnt) * cnt) % mod / 2 + sum) % mod;
                index = j;
            } else {
                index++;
            }
        }
        return (int) sum;
    }
}
