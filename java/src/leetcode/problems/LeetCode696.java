package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/12 13:11
 */
public class LeetCode696 {

    /**
     * 0 0 0 0 0 0 1 1 1 1 1 1  0 0 0 0 0 0
     * l           r         rr
     * <p>
     * sum = 6  len =12
     * <p>
     * res += 6
     * <p>
     * 连续的 0 多少个
     * 连续的 1 多少个
     * res +=Min（连续的 0的个数， 连续的 1 的个数）
     **/

    public int countBinarySubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int zCunt = 0;
        int oCunt = 0;

        int left = 0;

        int res = 0;
        while (left + 1 < s.length()) {
            if (s.charAt(left) == '0') {
                zCunt = 1;
            } else {
                oCunt = 1;
            }

            while (left + 1 < s.length() && s.charAt(left + 1) == s.charAt(left)) {
                if (s.charAt(left + 1) == '0') {
                    zCunt++;
                } else {
                    oCunt++;
                }
                left++;
            }
            int right = left + 1;
            if (right == s.length()) {
                return res;
            }
            if (s.charAt(right) == '0') {
                zCunt = 1;
            } else {
                oCunt = 1;
            }
            int rright = right + 1;
            while (rright < s.length() && s.charAt(rright) == s.charAt(right)) {
                if (s.charAt(rright) == '0') {
                    zCunt++;
                } else {
                    oCunt++;
                }
                rright++;
            }
            res += Math.min(zCunt, oCunt);
            zCunt = 0;
            oCunt = 0;
            left = right;
        }
        return res;
    }
}
