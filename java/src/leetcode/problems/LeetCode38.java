package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/20 10:31
 */
public class LeetCode38 {

    public static void main(String[] args) {
        System.out.println(new LeetCode38().countAndSay(6));
    }

    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int left = 0;
            int right = left;
            while (right < s.length()) {
                int cnt = 0;
                while (right < s.length() && s.charAt(left) == s.charAt(right)) {
                    right++;
                    cnt++;
                }
                sb.append(cnt);
                sb.append(s.charAt(left) - '0');
                left = right;
            }
            s = sb.toString();
        }
        return s;
    }
}
