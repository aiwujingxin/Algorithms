package LeetCode;

/**
 * @author jingxinwu
 * @date 2021-12-12 3:05 PM
 */
public class LeetCode191 {

    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}
