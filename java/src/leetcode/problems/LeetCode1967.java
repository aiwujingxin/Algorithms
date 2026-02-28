package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 1/6/26 01:26
 */
public class LeetCode1967 {

    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        char[] wordArr = word.toCharArray();

        for (String pattern : patterns) {
            if (check(pattern.toCharArray(), wordArr)) {
                res++;
            }
        }
        return res;
    }

    // KMP 匹配主逻辑
    private boolean check(char[] p, char[] w) {
        if (p.length == 0) return true;

        int m = p.length;
        int n = w.length;

        // 1. 获取 next 数组 (使用你的模版)
        int[] nx = next(p);

        // 2. 匹配过程
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && w[i] != p[j]) {
                j = nx[j - 1];
            }
            if (w[i] == p[j]) {
                j++;
            }
            if (j == m) {
                return true; // 匹配成功
            }
        }
        return false;
    }

    // 你的模版代码
    // s[i - next[i] : i] == s[0 : next[i]]
    public int[] next(char[] p) {
        int m = p.length;
        int[] nx = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && p[i] != p[j]) j = nx[j - 1];
            if (p[i] == p[j]) j++;
            nx[i] = j;
        }
        return nx;
    }
}
