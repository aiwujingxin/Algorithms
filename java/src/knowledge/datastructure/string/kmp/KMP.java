package knowledge.datastructure.string.kmp;

/**
 * @author aiwujingxin@gmail.com
 * @date 2024/10/29 01:55
 * @description KMP 算法的主要思想是提前判断如何重新开始查找，而这种判断只取决于模式本身。
 * 利用失配时的信息（next数组）避免指针回溯，实现线性时间匹配。时间复杂度 O(N+M)。
 * 时间复杂度 O(n+m)
 * @link <a href="https://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html">讲解</a>
 * @see leetcode.problems.LeetCode28
 * @see leetcode.problems.LeetCode214
 * @see leetcode.problems.LeetCode495
 * @see leetcode.problems.LeetCode1392
 * @see leetcode.problems.LeetCode3031
 */

public class KMP implements knowledge.datastructure.string.String.Match {

    public int strStr(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        char[] s = text.toCharArray();
        char[] p = pattern.toCharArray();
        int[] nxt = next(p);
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && s[i] != p[j]) j = nxt[j - 1];
            if (s[i] == p[j]) j++;
            if (j == m) return i - m + 1;
        }
        return -1;
    }

    //s[i - next[i]] : i] == s[0: next[i]]
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
