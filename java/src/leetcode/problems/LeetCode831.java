package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/28 16:10
 */
public class LeetCode831 {

    public String maskPII(String s) {
        if (s.contains("@")) {
            int index = s.indexOf("@");
            StringBuilder sb = new StringBuilder();
            sb.append(Character.toLowerCase(s.charAt(0)));
            sb.append("*****");
            sb.append(Character.toLowerCase(s.charAt(index - 1)));
            for (int i = index; i < s.length(); i++) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
            return sb.toString();
        }

        s = s.replace("(", "").
                replace(")", "").
                replace("+", "").
                replace("-", "").
                replace(" ", "");
        int code = s.length() - 10;
        StringBuilder sb = new StringBuilder();
        if (code == 0) {
            sb.append("***-***-");
        } else if (code == 1) {
            sb.append("+*-***-***-");
        } else if (code == 2) {
            sb.append("+**-***-***-");

        } else {
            sb.append("+***-***-***-");
        }
        return sb.append(s.substring(s.length() - 4)).toString();
    }
}
