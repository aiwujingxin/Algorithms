package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/1 15:54
 */
public class LeetCode1100 {

    public int numKLenSubstrNoRepeats(String s, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int[] arr = new int[26];
        int size = 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        while (right < n) {
            while (arr[chars[right] - 'a'] > 0 || size == k) {
                if (size == k) {
                    count++;
                }
                arr[chars[left] - 'a']--;
                size--;
                left++;
            }
            arr[chars[right] - 'a']++;
            size++;
            right++;
        }
        if (size == k) {
            count++;
        }
        return count;
    }
}
