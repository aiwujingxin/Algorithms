package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 11:06
 */
public class LeetCode67 {

    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, c = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || c != 0) {
            int x = i >= 0 ? a.charAt(i--) - '0' : 0;
            int y = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = x + y + c;
            sb.append(sum % 2);
            c = sum / 2;
        }
        return sb.reverse().toString();
    }
}
