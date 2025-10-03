package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 8/18/25 23:10
 * @description 每个元音字符出现在多少个子串里，它就贡献了多少次元音
 */
public class LeetCode2063 {

    public long countVowels(String word) {
        long ans = 0;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                // 以当前字符为结尾的子串数 * 以当前字符为开头的子串数 乘积 → 当前字符在 所有子串中出现的次数
                ans += (long) (i + 1) * (n - i);
            }
        }
        return ans;
    }
}
