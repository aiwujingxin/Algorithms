package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/22/25 17:14
 */
public class LeetCode2429 {
    public int minimizeXor(int num1, int num2) {
        int cnt = Integer.bitCount(num2);
        int res = 0;
        for (int i = 31; i >= 0 && cnt > 0; i--) {
            if (((num1 >> i) & 1) == 1) {
                res |= (1 << i);
                cnt--;
            }
        }
        for (int i = 0; i < 32 && cnt > 0; i++) {
            if (((res >> i) & 1) == 0) {
                res |= (1 << i);
                cnt--;
            }
        }
        return res;
    }
}
