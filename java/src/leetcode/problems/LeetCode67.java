package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 11:06
 */
public class LeetCode67 {

    public String addBinary(String a, String b) {
        int m = a.length() - 1;
        int n = b.length() - 1;
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        while (m >= 0 || n >= 0) {
            int v1 = m < 0 ? 0 : (a.charAt(m) - '0');
            int v2 = n < 0 ? 0 : (b.charAt(n) - '0');
            int t = v1 ^ v2 ^ flag;
            flag = v1 + v2 + flag >= 2 ? 1 : 0;
            sb.append(t);
            m--;
            n--;
        }
        if (flag == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
