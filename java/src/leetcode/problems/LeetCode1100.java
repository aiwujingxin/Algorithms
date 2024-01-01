package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/1 15:54
 */
public class LeetCode1100 {

    /**
     * 给你一个字符串 S，找出所有长度为 K 且不含重复字符的子串，请你返回全部满足要求的子串的 数目。
     * <p>
     * 输入：S = "havefunonleetcode", K = 5
     * 输出：6
     * <p>
     * 输入：S = "home", K = 5
     * 输出：0
     */
    public int numKLenSubstrNoRepeats(String s, int k) {
        int[] arr = new int[26];
        int left = 0;
        int right = 0;
        int res = 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        while (right < n) {
            char c = chars[right];
            arr[c - 'a']++;
            while (arr[c - 'a'] > 1 || right - left + 1 > k) {
                char d = chars[left];
                arr[d - 'a']--;
                left++;
            }
            res += right - left + 1 == k ? 1 : 0;
            right++;
        }
        return res;
    }
}
