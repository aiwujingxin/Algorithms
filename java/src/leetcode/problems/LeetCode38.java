package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 10:53
 */
public class LeetCode38 {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String pre = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int index = 0;
            while (index < pre.length()) {
                int cnt = 0;
                char c = pre.charAt(index);
                while (index < pre.length() && pre.charAt(index) == c) {
                    index++;
                    cnt++;
                }
                sb.append(cnt);
                sb.append(c);
            }
            pre = sb.toString();
        }
        return pre;
    }
}
