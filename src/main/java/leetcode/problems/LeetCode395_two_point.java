package leetcode.problems;

import java.util.Arrays;

/**
 * @author jingxinwu
 * @date 2021-12-25 3:48 PM
 */
public class LeetCode395_two_point {

    //https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/2444441/Java-Solution-or-Recursive-or-Sliding-Window
    public int longestSubstring(String st, int k) {
        int ans = 0;

        char[] s = st.toCharArray();

        int[] freq = new int[26];
        for (char c : s) {
            freq[c - 'a']++;
        }

        int uniChars = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                uniChars++;
            }
        }

        for (int curr = 1; curr <= uniChars; curr++) {
            Arrays.fill(freq, 0);
            int start = 0, end = 0;
            int count = 0, count_k = 0;

            while (end < s.length) {
                if (count <= curr) {
                    int ind = s[end] - 'a';
                    if (freq[ind] == 0) {
                        count++;
                    }
                    freq[ind]++;
                    if (freq[ind] == k) {
                        count_k++;
                    }
                    end++;
                } else {
                    int ind = s[start] - 'a';
                    if (freq[ind] == k) {
                        count_k--;
                    }
                    freq[ind]--;
                    if (freq[ind] == 0) {
                        count--;
                    }
                    start++;
                }
                if (count == curr && count_k == curr) {
                    ans = Math.max(ans, end - start);
                }
            }
        }
        return ans;
    }

}
