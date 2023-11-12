package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/12 13:47
 */
public class LeetCode709 {

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch >= 65 && ch <= 90) {
                ch |= 32;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
