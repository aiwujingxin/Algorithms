package leetcode.problems;

import knowledge.datastructure.string.search.impl.KMP;

/**
 * @author wujingxinit@outlook.com
 * @date 8/17/25 16:45
 */
public class LeetCode3031 {

    public int minimumTimeToInitialState(String word, int k) {
        int n = word.length();
        int[] pi = new KMP().next(word);
        // 遍历 t，检查 word[t*k:] 是否是前缀
        for (int t = 1; t * k <= n; t++) {
            int start = t * k;
            if (isPrefix(word, start, pi)) {
                return t;
            }
        }
        return (n + k - 1) / k;
    }

    // 检查 word[start:] 是否是 word 的前缀
    private boolean isPrefix(String word, int start, int[] pi) {
        int n = word.length();
        int len = n - start;
        // KMP border 只能从 pi[n] 不断回溯
        int border = pi[n];
        while (border > 0) {
            if (border == len) return true;
            border = pi[border];
        }
        return len == 0; // 特殊情况：完全删光
    }
}
