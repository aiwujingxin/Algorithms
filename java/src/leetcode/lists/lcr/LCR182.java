package leetcode.lists.lcr;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/13 16:48
 */
public class LCR182 {

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] chars = s.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, s.length() - 1);
        reverse(chars, 0, s.length() - 1);
        return new String(chars);
    }

    public void reverse(char[] chars, int start, int end) {
        while (start <= end) {
            char t = chars[start];
            chars[start] = chars[end];
            chars[end] = t;
            start++;
            end--;
        }
    }
}
