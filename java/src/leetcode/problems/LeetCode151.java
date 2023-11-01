package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-08-04 11:14 下午
 */
public class LeetCode151 {

    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        String[] list = s.trim().split(" ");
        for (int i = list.length - 1; i >= 0; i--) {
            sb.append(list[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public String reverseWords_self(String s) {
        StringBuilder sb = trimSpaces(s);
        reverse(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }

    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            ++left;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char t = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, t);
            left++;
            right--;
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                ++end;
            }
            reverse(sb, start, end - 1);
            start = end + 1;
            ++end;
        }
    }
}
