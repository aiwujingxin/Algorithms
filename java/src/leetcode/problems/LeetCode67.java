package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 14:37
 */
public class LeetCode67 {

    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) {
            return b;
        }
        if (b == null || b.isEmpty()) {
            return a;
        }
        int ai = a.length() - 1;
        int bi = b.length() - 1;
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        while (ai >= 0 || bi >= 0) {
            int m = ai < 0 ? 0 : a.charAt(ai) - '0';
            int n = bi < 0 ? 0 : b.charAt(bi) - '0';
            int s = m ^ n ^ flag;
            flag = m + n + flag >= 2 ? 1 : 0;
            sb.append(s);
            ai--;
            bi--;
        }
        if (flag == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
