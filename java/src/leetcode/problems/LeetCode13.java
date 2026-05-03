package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/23 21:41
 */
public class LeetCode13 {

    private static final int[] DICT = new int[128];

    static {
        DICT['I'] = 1;
        DICT['V'] = 5;
        DICT['X'] = 10;
        DICT['L'] = 50;
        DICT['C'] = 100;
        DICT['D'] = 500;
        DICT['M'] = 1000;
    }

    public int romanToInt(String s) {
        int ans = 0;
        int prev = Integer.MAX_VALUE;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int curr = DICT[s.charAt(i)];
            ans += curr;
            if (curr > prev) {
                ans -= prev * 2;
            }
            prev = curr;
        }
        return ans;
    }
}
