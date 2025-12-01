package knowledge.datastructure.string.kmp;

/**
 * @author aiwujingxin@gmail.com
 * @date 2024/10/29 01:55
 * @description KMP 算法的主要思想是提前判断如何重新开始查找，而这种判断只取决于模式本身。
 * 利用失配时的信息（next数组）避免指针回溯，实现线性时间匹配。时间复杂度 O(N+M)。
 * 时间复杂度 O(n+m)
 * @link <a href="https://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html">讲解</a>
 */

public class KMP implements knowledge.datastructure.string.String.Match {

    public int strStr(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        if (m == 0) return 0;
        int[] next = next(pattern);
        char[] t = text.toCharArray();
        char[] p = pattern.toCharArray();
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && t[i] != p[j]) j = next[j];
            if (t[i] == p[j]) j++;
            if (j == m) return i - m + 1;
        }
        return -1;
    }

    //next[i]表示对应的部分匹配值, s[i - next[i]] : i] == s[0: next[i]]
    public int[] next(String pattern) {
        int m = pattern.length();
        char[] p = new char[m + 1];
        int[] ne = new int[m + 1];
        for (int i = 0; i < m; i++) p[i + 1] = pattern.charAt(i);
        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && p[i] != p[j + 1]) j = ne[j];
            if (p[i] == p[j + 1]) j++;
            ne[i] = j;
        }
        return ne;
    }

    /**
     * @author wujingxinit@outlook.com
     * @date 10/29/24 00:54
     * @description 0-base
     * @link <a href="https://www.youtube.com/watch?v=3IFxpozBs2I">code</a>
     */
    public static class KMP0 implements knowledge.datastructure.string.String.Match {

        public int strStr(String text, String pattern) {
            int n = text.length();
            int m = pattern.length();
            int i = 0; // index for text
            int j = 0; // index for pattern
            int[] next = next(pattern);
            while (i < n) {
                if (pattern.charAt(j) == text.charAt(i)) {
                    i++;
                    j++;
                    if (j == m) {
                        return i - j;
                    }
                } else if (j != 0) {
                    j = next[j - 1];
                } else {
                    i++;
                }
            }
            return -1;
        }

        //next[i]表示对应的部分匹配值, s[i - next[i]] : i] == s[0: next[i]]
        public int[] next(String pattern) {
            int m = pattern.length();
            int[] next = new int[m];
            int len = 0;
            int i = 1;
            while (i < m) {
                if (pattern.charAt(i) == pattern.charAt(len)) {
                    len++;
                    next[i] = len;
                    i++;
                } else {
                    if (len != 0) {
                        len = next[len - 1];
                    } else {
                        next[i] = len;
                        i++;
                    }
                }
            }
            return next;
        }
    }
}
