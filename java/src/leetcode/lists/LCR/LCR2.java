package leetcode.lists.LCR;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 09:26
 */
public class LCR2 {

    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) {
            return b;
        }
        if (b == null || b.isEmpty()) {
            return a;
        }
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        int one = a.length() - 1;
        int two = b.length() - 1;
        while (one >= 0 && two >= 0) {
            int res = (a.charAt(one) - '0') ^ (b.charAt(two) - '0') ^ flag;
            flag = ((a.charAt(one) - '0') + (b.charAt(two) - '0') + flag >= 2 ? 1 : 0);
            sb.append(res);
            one--;
            two--;
        }

        while (one >= 0) {
            sb.append((a.charAt(one) - '0') ^ flag);
            flag = (a.charAt(one) - '0') & flag;
            one--;
        }
        while (two >= 0) {
            sb.append((b.charAt(two) - '0') ^ flag);
            flag = (b.charAt(two) - '0') & flag;
            two--;
        }
        if (flag == 1) {
            sb.append(flag);
        }
        return sb.reverse().toString();
    }
}
