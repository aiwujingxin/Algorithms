package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/5 22:57
 * @description 双指针 计数
 */
public class LeetCode809 {

    public int expressiveWords(String s, String[] words) {
        return (int) java.util.Arrays.stream(words).filter(w -> check(s, w)).count();
    }

    private boolean check(String s, String w) {
        int i = 0, j = 0, n = s.length(), m = w.length();
        while (i < n && j < m) {
            if (s.charAt(i) != w.charAt(j)) return false;
            char c = s.charAt(i);
            int sc = 0, wc = 0;
            while (i < n && s.charAt(i) == c) {
                sc++;
                i++;
            }
            while (j < m && w.charAt(j) == c) {
                wc++;
                j++;
            }
            if (sc < wc || (sc != wc && sc < 3)) return false;
        }
        return i == n && j == m;
    }
}
