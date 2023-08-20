package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/21 01:39
 */
public class LeetCode13 {
    public int romanToInt(String s) {
        int ans = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == 'M') ans += 1000;
            else if (ch == 'D') ans += 500;
            else if (ch == 'C') {
                if (i != s.length() - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) ans -= 100;
                else ans += 100;
            } else if (ch == 'L') ans += 50;
            else if (ch == 'X') {
                if (i != s.length() - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) ans -= 10;
                else ans += 10;
            } else if (ch == 'V') ans += 5;
            else if (ch == 'I') {
                if (i != s.length() - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) ans -= 1;
                else ans += 1;
            }
        }

        return ans;
    }
}
