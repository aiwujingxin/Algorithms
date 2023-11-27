package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/27 15:02
 */
public class LeetCode402 {

    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            while (!sb.isEmpty() && sb.charAt(sb.length() - 1) > num.charAt(i) && k > 0) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(num.charAt(i));
        }
        int index = 0;
        while (index < sb.length() && sb.charAt(index) == '0') {
            index++;
        }
        if (index == sb.length()) {
            return "0";
        }
        if (index < sb.length() - k) {
            return sb.substring(index, sb.length() - k);
        }
        return sb.substring(0, sb.length() - k);
    }
}
