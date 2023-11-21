package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/21 21:59
 */
public class LeetCode383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null || magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] arr1 = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            arr1[ransomNote.charAt(i) - 'a']++;
        }
        int[] arr2 = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr2[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr1[i] > arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
