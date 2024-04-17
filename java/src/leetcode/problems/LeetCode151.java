package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/17 14:54
 */
public class LeetCode151 {

    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        s = s.trim();
        if (s.isEmpty()) {
            return "";
        }
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            String t = strings[i].trim();
            if (t.isEmpty()) {
                continue;
            }
            sb.append(t);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
