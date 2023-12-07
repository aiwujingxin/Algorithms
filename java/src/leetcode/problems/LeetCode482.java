package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/7 11:01
 */
public class LeetCode482 {

    public String licenseKeyFormatting(String s, int k) {
        if (s.isEmpty()) {
            return "";
        }
        s = s.replace("-", "");
        if (s.isEmpty()) {
            return "";
        }
        if (s.length() <= k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(Character.toUpperCase(s.charAt(i)));
            }
            return sb.toString();
        }

        int cnt = s.length();
        int f = (cnt % k == 0 ? 0 : cnt % k);
        int index = f;
        StringBuilder sb = new StringBuilder();
        if (f != 0) {
            while (f > 0) {
                sb.append(Character.toUpperCase(s.charAt(f - 1)));
                f--;
            }
            sb.reverse();
            sb.append("-");
        }
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) != '-') {
                if ((i - index) != 0 && (i - index) % k == 0 && (i <= s.length() - k)) {
                    sb.append('-');
                }
                sb.append(Character.toUpperCase(s.charAt(i)));
            }
        }
        return sb.toString();
    }
}
