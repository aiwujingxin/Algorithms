package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/17 23:59
 */
public class LeetCode2024 {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int len = answerKey.length();
        if (len < 2) {
            return len;
        }
        char[] charArray = answerKey.toCharArray();
        int left = 0;
        int right = 0;
        int res = 0;
        int maxCount = 0;
        int[] freq = new int[26];
        while (right < len) {
            freq[charArray[right] - 'A']++;
            maxCount = Math.max(maxCount, freq[charArray[right] - 'A']);

            while (right - left + 1 > maxCount + k) {
                freq[charArray[left] - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
