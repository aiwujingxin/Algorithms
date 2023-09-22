package leetcode.lists.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 15:50
 */
public class Offer15 {
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
