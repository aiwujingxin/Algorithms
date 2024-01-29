package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/29 16:38
 */
public class LeetCode2840 {

    public boolean checkStrings(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq3 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                freq1[s1.charAt(i) - 'a']++;
            } else {
                freq3[s1.charAt(i) - 'a']++;
            }
        }
        int[] freq2 = new int[26];
        int[] freq4 = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            if (i % 2 == 0) {
                freq2[s2.charAt(i) - 'a']++;
            } else {
                freq4[s2.charAt(i) - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i] || freq3[i] != freq4[i]) {
                return false;
            }
        }
        return true;
    }
}
