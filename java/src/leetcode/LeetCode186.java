package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/8 16:14
 */
public class LeetCode186 {

    public void reverseWords(char[] s) {
        int i = 0;
        int j = 0;

        while (j < s.length) {
            if (s[j] == ' ') {
                reverse(s, i, j - 1);
                i = j;
                j = j + 1;
            } else {
                j++;
            }
        }
        reverse(s, i, j - 1);
        reverse(s, 0, s.length - 1);
    }

    public void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
            i++;
            j--;
        }
    }
}
