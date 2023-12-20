package basic.datastructure.string.impl;

import basic.datastructure.string.Search;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/7 00:09
 * @see leetcode.problems.LeetCode1044
 * @see leetcode.problems.LeetCode187
 * @see leetcode.problems.LeetCode28
 */
public class RabinKarp implements Search {

    public int search(String txt, String pat) {
        int n = pat.length();
        // 进制（只考虑 ASCII 编码）
        int mul = 256;
        // 取一个比较大的素数作为求模的除数
        long mod = 1658598167;
        // R^(L - 1) 的结果
        long base = 1;
        for (int i = 0; i < n; i++) {
            // 计算过程中不断求模，避免溢出
            base = (base * mul) % mod;
        }
        // 计算模式串的哈希值，时间 O(L)
        long patHash = 0;
        for (int i = 0; i < pat.length(); i++) {
            patHash = (mul * patHash + pat.charAt(i)) % mod;
        }
        // 滑动窗口中子字符串的哈希值
        long hash = 0;
        // 滑动窗口代码框架，时间 O(N)
        int left = 0, right = 0;
        while (right < txt.length()) {
            // 扩大窗口，移入字符
            hash = ((mul * hash) % mod + txt.charAt(right)) % mod;
            right++;
            // 当子串的长度达到要求
            if (right - left == n) {
                // 根据哈希值判断是否匹配模式串
                if (hash == patHash) {
                    // 当前窗口中的子串哈希值等于模式串的哈希值
                    // 还需进一步确认窗口子串是否真的和模式串相同，避免哈希冲突
                    if (pat.equals(txt.substring(left, right))) {
                        return left;
                    }
                }
                // 缩小窗口，移出字符
                hash = (hash - (txt.charAt(left) * base) % mod + mod) % mod;
                // X % Q == (X + Q) % Q 是一个模运算法则
                // 因为 windowHash - (txt[left] * RL) % Q 可能是负数
                // 所以额外再加一个 Q，保证 windowHash 不会是负数
                left++;
            }
        }
        // 没有找到模式串
        return -1;
    }
}
