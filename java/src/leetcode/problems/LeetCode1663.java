package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/24 21:42
 */
public class LeetCode1663 {

    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (k <= (n - sb.length() - 1) * 26) {
            sb.append('a');
            k--;
        }
        char c = (char) (k - (n - sb.length() - 1) * 26 - 1 + 'a');
        sb.append(c);
        int b = n - sb.length();
        for (int i = 0; i < b; i++) {
            sb.append('z');
        }
        return sb.toString();
    }
}
