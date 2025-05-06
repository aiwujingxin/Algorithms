package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 10:53
 */
public class LeetCode38 {

    public String countAndSay(int n) {
        String pre = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int index = 0; index < pre.length(); index++) {
                int cnt = 1;
                while (index + 1 < pre.length() && pre.charAt(index) == pre.charAt(index + 1)) {
                    index++;
                    cnt++;
                }
                sb.append(cnt).append(pre.charAt(index));
            }
            pre = sb.toString();
        }
        return pre;
    }
}
