package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 8/18/25 23:19
 * @description 给你一个字符串 s，返回 只含 单一字母 的子串个数 。
 * <p>
 * 示例 1：
 * 输入： s = "aaaba"
 * 输出： 8
 * 解释： 只含单一字母的子串分别是 "aaa"， "aa"， "a"， "b"。
 * "aaa" 出现 1 次。
 * "aa" 出现 2 次。
 * "a" 出现 4 次。
 * "b" 出现 1 次。
 * 所以答案是 1 + 2 + 4 + 1 = 8。
 * 示例 2:
 * 输入： s = "aaaaaaaaaa"
 * 输出： 55
 * <p>
 * 1 <= s.length <= 1000
 * s[i] 仅由小写英文字母组成
 */
public class LeetCode1180 {

    public int countLetters(String s) {
        int ans = 0;
        for (int i = 0, n = s.length(); i < n; ) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            ans += (1 + j - i) * (j - i) / 2;
            i = j;
        }
        return ans;
    }
}
