package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/3 21:51
 */
public class LeetCode2516 {

    // 转换
    // 窗口内各自 至多有 x-k 个字符
    public int takeCharacters(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] arr = new int[3];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        int a = arr[0] - k;
        int b = arr[1] - k;
        int c = arr[2] - k;

        if (a == 0 && b == 0 && c == 0) return s.length();
        if (a < 0 || b < 0 || c < 0) return -1;

        arr = new int[3];
        int ans = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            arr[s.charAt(right) - 'a']++;
            while (arr[0] > a || arr[1] > b || arr[2] > c) {
                arr[s.charAt(left) - 'a']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return s.length() - ans;
    }
}
