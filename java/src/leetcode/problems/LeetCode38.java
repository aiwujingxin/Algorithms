package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 10:53
 */
public class LeetCode38 {

    public String countAndSay(int n) {
        String s = "1";
        for (int i = 0; i < n - 1; i++) {
            int index = 0;
            StringBuilder next = new StringBuilder();
            while (index < s.length()) {
                char c = s.charAt(index);
                int cnt = 0;
                while (index < s.length() && s.charAt(index) == c) {
                    cnt++;
                    index++;
                }
                next.append(cnt).append(c);
            }
            s = next.toString();
        }
        return s;
    }
}
