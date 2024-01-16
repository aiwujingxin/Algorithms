package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/16 23:20
 */
public class LeetCode1433 {

    public boolean checkIfCanBreak(String s1, String s2) {
        return check(s1, s2) || check(s2, s1);
    }

    private boolean check(String s1, String s2) {
        int[] arr1 = new int[26];
        int n = s1.length();
        for (int i = 0; i < n; ++i) {
            arr1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; ++i) {
            char c = s2.charAt(i);
            boolean canFind = false;
            for (int j = c - 'a'; j < 26; ++j) {
                if (arr1[j] > 0) {
                    --arr1[j];
                    canFind = true;
                    break;
                }
            }
            if (!canFind) {
                return false;
            }
        }
        return true;
    }
}
