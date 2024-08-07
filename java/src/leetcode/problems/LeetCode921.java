package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/5 00:20
 */
public class LeetCode921 {

    public int minAddToMakeValid(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                res++;
                count = 0;
            }
        }
        return res + count;
    }
}
