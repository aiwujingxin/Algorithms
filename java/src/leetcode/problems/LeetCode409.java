package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/27 22:08
 */
public class LeetCode409 {

    public int longestPalindrome(String s) {
        int[] arr = new int[256];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'A']++;
        }
        int same = 0;
        boolean single = false;
        for (int j : arr) {
            if (j % 2 == 0) {
                same += j;
            }
            if (j % 2 == 1) {
                single = true;
                same += j / 2 * 2;
            }
        }
        return same + (single ? 1 : 0);
    }
}
