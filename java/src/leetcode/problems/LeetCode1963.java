package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/5 13:03
 */
public class LeetCode1963 {

    public int minSwaps(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                res++;
                count = 0;
            }
        }
        return res % 2 == 0 ? res / 2 : res / 2 + 1;
    }
}
