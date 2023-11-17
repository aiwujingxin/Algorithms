package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2023/11/17 22:28
 */
public class LeetCode345 {

    public String reverseVowels(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < n && !isVowel(arr[left])) {
                left++;
            }
            while (right > 0 && !isVowel(arr[right])) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    public void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
