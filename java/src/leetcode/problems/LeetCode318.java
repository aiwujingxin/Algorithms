package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/3 15:22
 */
public class LeetCode318 {

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] ints = new int[n];
        for (int i = 0; i < words.length; i++) {
            ints[i] = convert(words[i]);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((ints[i] & ints[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    private int convert(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res |= 1 << (s.charAt(i) - 'a');
        }
        return res;
    }
}
