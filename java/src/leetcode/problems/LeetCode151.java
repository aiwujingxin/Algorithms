package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/17 14:54
 */
public class LeetCode151 {

    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = parts.length - 1; i >= 0; i--) {
            sb.append(parts[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
