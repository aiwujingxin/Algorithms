package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 5/3/25 21:03
 */
public class LeetCode2131 {

    public int longestPalindrome(String[] words) {
        int[][] cnt = new int[26][26];
        int pairLength = 0;
        boolean hasMiddle = false;

        for (String word : words) {
            cnt[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j) {  // symmetric word like "aa", "bb"
                    pairLength += (cnt[i][j] / 2) * 4;
                    if (cnt[i][j] % 2 == 1) {
                        hasMiddle = true;
                    }
                } else if (i < j) {
                    // match "ab" with "ba"
                    int match = Math.min(cnt[i][j], cnt[j][i]);
                    pairLength += match * 4;
                }
            }
        }
        return pairLength + (hasMiddle ? 2 : 0);
    }
}
