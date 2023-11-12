package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/12 14:29
 */
public class LeetCode748 {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] lic = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (c >= 'a' && c <= 'z') {
                lic[c - 'a']++;
            } else if (c >= 'A' && c <= 'Z') {
                lic[c - 'A']++;
            }
        }
        String res = null;
        for (String s : words) {
            if (check(s, lic)) {
                if (res == null || s.length() < res.length()) {
                    res = s;
                }
            }
        }
        return res;
    }

    private boolean check(String s, int[] arr) {
        int[] t = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                t[c - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (t[i] < arr[i]) {
                return false;
            }
        }
        return true;
    }
}
