package basic.datastructure.string.search;

import basic.datastructure.string.Search;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/7 00:09
 * @see leetcode.problems.LeetCode1044
 */
public class RabinKarp implements Search {

    public final int mul = 10;
    int mod = 101;

    public int search(String txt, String pattern) {
        int n = txt.length();
        int m = pattern.length();

        int base = 1;
        for (int i = 0; i < m - 1; i++) {
            base = (base * mul) % mod;
        }

        int thash = 0;
        int phash = 0;
        // Calculate hash value for pattern and text
        for (int i = 0; i < m; i++) {
            phash = (phash * mul + pattern.charAt(i)) % mod;
            thash = (thash * mul + txt.charAt(i)) % mod;
        }
        // Find the match
        for (int i = 0; i <= n - m; i++) {
            if (phash == thash && eq(txt, i, pattern)) {
                return i;
            }
            if (i < n - m) {
                thash = (mul * (thash - txt.charAt(i) * base) + txt.charAt(i + m)) % mod;
                if (thash < 0) {
                    thash = thash + mod;
                }
            }
        }
        return -1;
    }

    private boolean eq(String text, int start, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            if (text.charAt(start + i) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
