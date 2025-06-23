package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 10:53
 */
public class LeetCode38 {

    public String countAndSay(int n) {
        String cur = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cur.length(); j++) {
                int cnt = 1;
                while (j + 1 < cur.length() && cur.charAt(j) == cur.charAt(j + 1)) {
                    j++;
                    cnt++;
                }
                sb.append(cnt).append(cur.charAt(j));
            }
            cur = sb.toString();
        }
        return cur;
    }
}
