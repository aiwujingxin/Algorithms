package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/19 22:23
 * <a href="https://leetcode.cn/problems/number-of-substrings-containing-all-three-characters/solution/bao-han-suo-you-san-chong-zi-fu-de-zi-zi-fu-chuan-/">...</a>
 */
public class LeetCode1358 {

    public int numberOfSubstrings(String s) {
        return getSubArr(s, 3) - getSubArr(s, 2);
    }

    private int getSubArr(String s, int k) {
        int n = s.length();
        int[] window = new int[3];
        int cnt = 0;
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < n) {
            int c = s.charAt(right) - 'a';
            window[c]++;
            if (window[c] == 1) {
                cnt++;
            }
            while (cnt > k) {
                int d = s.charAt(left) - 'a';
                window[d]--;
                if (window[d] == 0) {
                    cnt--;
                }
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }
}
