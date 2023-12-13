package leetcode.lists.lcr;

/**
 * @author jingxinwu
 * @date 2021-11-22 10:58 下午
 */
public class LCR163 {

    public int findNthDigit(int n) {
        int start = 1;
        int digitNum = 1;
        long base = 9;
        while (n > digitNum * base) {
            n -= (int) (digitNum * base);
            start *= 10;
            base *= 10;
            digitNum++;
        }
        start += (n - 1) / digitNum;
        String s = String.valueOf(start);
        char c = s.charAt((n - 1) % digitNum);
        return c - '0';
    }
}
