package leetcode.problems;

import knowledge.datastructure.string.kmp.KMP;

/**
 * @author wujingxinit@outlook.com
 * @date 8/17/25 16:45
 */
public class LeetCode3031 {

    public int minimumTimeToInitialState(String word, int k) {
        int n = word.length();
        int[] pi = new KMP().next(word.toCharArray());
        // 预处理：标记所有 border 长度
        boolean[] isBorderLen = new boolean[n + 1];
        int border = pi[n - 1]; // 从最长的 border 开始
        while (border > 0) {
            isBorderLen[border] = true;
            border = pi[border - 1]; // 正确的 0-based 回退
        }
        isBorderLen[0] = true; // 删光也算前缀
        // 遍历 t，检查 word[t*k:] 是否是前缀
        for (int t = 1; t * k <= n; t++) {
            if (isBorderLen[n - t * k]) {
                return t;
            }
        }
        return (n + k - 1) / k;
    }
}
