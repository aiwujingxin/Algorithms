package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 12/17/25 11:31
 */
public class LeetCode3210 {

    public String getEncryptedString(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            chars[i] = s.charAt((i + k) % n);
        }
        return new String(chars);
    }
}
