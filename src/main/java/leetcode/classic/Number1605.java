package leetcode.classic;

/**
 * @author jingxinwu
 * @date 2021-12-06 12:35 上午
 */
public class Number1605 {

    public int trailingZeroes(int n) {
        int cnt = 0;
        for (long num = 5; n / num > 0; num *= 5) {
            cnt += n / num;
        }
        return cnt;
    }
}
