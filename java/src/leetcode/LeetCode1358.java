package leetcode;

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
        int[] cnt = new int[3];
        int m = 0;
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < n) {
            int indexR = s.charAt(right) - 'a';
            cnt[indexR]++;
            if (cnt[indexR] == 1) {
                m++;
            }
            while (m > k) {
                int indexL = s.charAt(left) - 'a';
                cnt[indexL]--;
                if (cnt[indexL] == 0) {
                    m--;
                }
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }
}
