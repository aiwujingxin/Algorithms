package leetCode.classic;

/**
 * @author jingxinwu
 * @date 2021-12-05 3:59 下午
 */
public class Number1607 {


    public int maximum(int a, int b) {
        int k = (int) (((long) a - (long) b) >>> 63 & 1);
        return a * (1 - k) + b * k;
    }

}
