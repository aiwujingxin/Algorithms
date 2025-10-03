package leetcode.problems;


import knowledge.datastructure.string.hash.DoubleStringHash;
import knowledge.datastructure.string.hash.StringHash;
import knowledge.datastructure.string.search.impl.KMP;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/27 20:47
 */
public class LeetCode1392 {

    public String longestPrefix(String s) {
        int n = s.length();
        int[] next = new KMP().next(s);
        return s.substring(0, next[n]);
    }

    public String longestPrefix_hash_TEL(String s) {
        int n = s.length();
        StringHash sh = new StringHash(s);
        int maxLen = 0;
        // 检查所有可能的前缀后缀对
        for (int len = 1; len < n; len++) {
            // 前缀: s[0:len]
            // 后缀: s[n-len:n]
            long prefixHash = sh.getHash(0, len);
            long suffixHash = sh.getHash(n - len, n);
            if (prefixHash == suffixHash) {
                // 可选：再次验证防止哈希冲突
                if (s.substring(0, len).equals(s.substring(n - len))) {
                    maxLen = len;
                }
            }
        }
        return s.substring(0, maxLen);
    }

    public String longestPrefix_d_hash(String s) {
        int n = s.length();
        DoubleStringHash sh = new DoubleStringHash(s);
        int maxLen = 0;
        for (int len = 1; len < n; len++) {
            long[] prefix = sh.getHash(0, len);
            long[] suffix = sh.getHash(n - len, n);
            if (prefix[0] == suffix[0] && prefix[1] == suffix[1]) {
                maxLen = len;
            }
        }
        return s.substring(0, maxLen);
    }
}

