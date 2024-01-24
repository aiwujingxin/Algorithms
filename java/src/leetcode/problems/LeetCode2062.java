package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/24 14:30
 */
public class LeetCode2062 {

    public int countVowelSubstrings(String word) {
        int res = 0;
        int n = word.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = meet(word.charAt(i)) ? 1 : 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 4; j < n; j++) {
                int[] freq = new int[26];
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                    freq[word.charAt(k) - 'a']++;
                }
                if (j - i + 1 == sum && check(freq)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean check(int[] freq) {
        String s = "aeiou";
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] <= 0) {
                return false;
            }
        }
        return true;
    }

    private boolean meet(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
