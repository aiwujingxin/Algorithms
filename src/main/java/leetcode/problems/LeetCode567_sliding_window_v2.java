package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/10 21:27
 */
public class LeetCode567_sliding_window_v2 {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] dict1 = new int[26];
        int[] dict2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            dict1[s1.charAt(i) - 'a']++;
            dict2[s2.charAt(i) - 'a']++;
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (dict1[i] == dict2[i]) {
                count++;
            }
        }

        if (count == 26) {
            return true;
        }

        for (int i = 1; i <= s2.length() - s1.length(); i++) {
            int left = s2.charAt(i - 1) - 'a';
            int right = s2.charAt(i + s1.length() - 1) - 'a';


            dict2[right]++;

            if (dict2[right] == dict1[right]) {
                count++;
            } else if (dict2[right] == dict1[right] + 1) {
                count--;
            }

            dict2[left]--;

            if (dict2[left] == dict1[left]) {
                count++;
            } else if (dict2[left] == dict1[left] - 1) {
                count--;
            }

            if (count == 26) {
                return true;
            }

        }

        return false;
    }
}
