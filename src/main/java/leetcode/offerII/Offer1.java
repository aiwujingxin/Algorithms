package leetcode.offerII;

/**
 * @author jingxinwu
 * @date 2021-12-04 6:46 下午
 */
public class Offer1 {


    public int divide(int a, int b) {
        int flag = 0;
        if (a > 0) {
            a = -a;
            flag += 1;
        }

        if (b > 0) {
            b = -b;
            flag += 1;
        }
        int ret = calc(a, b);
        if (flag != 1 && ret == Integer.MIN_VALUE) {
            ret++;
        }
        return flag == 1 ? ret : -ret;
    }

    private int calc(int a, int b) {
        int ret = 0;
        while (a <= b) {
            int cnt = 1;
            int val = b;
            while (val >= Integer.MIN_VALUE >> 1 && a <= val << 1) {
                cnt += cnt;
                val += val;
            }
            ret -= cnt;
            a -= val;
        }
        return ret;
    }
}
