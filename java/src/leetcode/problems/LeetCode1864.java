package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/4 15:05
 */
public class LeetCode1864 {

    public int minSwaps(String s) {
        int cnt0 = 0;
        int cnt1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                cnt0++;
            } else {
                cnt1++;
            }
        }
        if (Math.abs(cnt0 - cnt1) > 1) {
            return -1;
        }
        int a = getN(s, '0', cnt0, cnt1);
        int b = getN(s, '1', cnt0, cnt1);
        return (Math.min(a, b) + 1) / 2;
    }

    private int getN(String s, char c, int s0, int s1) {
        int cnt = 0;
        int cnt0 = 0;
        int cnt1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                cnt++;
            }
            if (c == '0') {
                cnt0++;
                c = '1';
            } else {
                cnt1++;
                c = '0';
            }
        }
        if (cnt0 != s0 || cnt1 != s1) {
            return Integer.MAX_VALUE;
        }
        return cnt;
    }
}
