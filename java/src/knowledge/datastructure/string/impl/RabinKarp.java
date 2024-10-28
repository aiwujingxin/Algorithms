package knowledge.datastructure.string.impl;

import knowledge.datastructure.string.Search;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/7 00:09
 * @see leetcode.problems.LeetCode1044
 * @see leetcode.problems.LeetCode187
 * @see leetcode.problems.LeetCode28
 * @see leetcode.problems.LeetCode718
 */
public class RabinKarp implements Search {

    public int strStr(String txt, String pat) {
        int n = pat.length();
        // 进制（只考虑 ASCII 编码）
        int mul = 256;
        // 取一个比较大的素数作为求模的除数
        long mod = 1658598167;
        long pow = 1;
        for (int i = 0; i < n - 1; i++) {
            pow = pow * mul % mod; // 计算过程中不断求模，避免溢出
        }
        // 计算模式串的哈希值
        long patHash = 0;
        for (int i = 0; i < pat.length(); i++) {
            patHash = (mul * patHash + pat.charAt(i)) % mod;
        }
        long hash = 0;
        int left = 0;
        int right = 0;
        while (right < txt.length()) {
            hash = ((mul * hash) % mod + txt.charAt(right)) % mod;
            right++;
            if (right - left == n) {
                if (hash == patHash) {
                    // 当前窗口中的子串哈希值等于模式串的哈希值
                    // 还需进一步确认窗口子串是否真的和模式串相同，避免哈希冲突
                    if (pat.equals(txt.substring(left, right))) {
                        return left;
                    }
                }
                // 缩小窗口，移出字符
                // 因为 hash - (txt[left] * pow) % mod 可能是负数 再加一个 mod，保证 hash 不会是负数
                hash = (hash - (txt.charAt(left) * pow) % mod + mod) % mod;
                left++;
            }
        }
        return -1;
    }
}
