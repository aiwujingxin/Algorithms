package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/23 10:55
 */
public class LeetCode1839 {

    public int longestBeautifulSubstring(String word) {
        if (word == null || word.isEmpty()) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int[] arr = new int[26];
        int ans = 0;
        int count = 0;
        while (right < word.length()) {
            arr[word.charAt(right) - 'a']++;
            if (arr[word.charAt(right) - 'a'] == 1) {
                count++;
            }
            while (right > 0 && word.charAt(right - 1) > word.charAt(right) && left < right) {
                arr[word.charAt(left) - 'a']--;
                if (arr[word.charAt(left) - 'a'] == 0) {
                    count--;
                }
                left++;
            }
            if (count == 5) {
                ans = Math.max(right - left + 1, ans);
            }
            right++;
        }
        return ans;
    }
}
