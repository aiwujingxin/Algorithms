package leetcode.offer;

/**
 * @author jingxinwu
 * @date 2021-11-21 2:08 下午
 */
public class Offer14_2_greedy {
    //贪心
    //https://leetcode.cn/problems/jian-sheng-zi-ii-lcof/solution/wu-xu-fu-za-shu-xue-jiang-jie-dong-tai-g-j470/
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        long ret = 1;
        if (n % 3 == 1) {
            ret = 4;
            n = n - 4;
        }
        if (n % 3 == 2) {
            ret = 2;
            n = n - 2;
        }
        while (n > 0) {
            ret = ret * 3 % 1000000007;
            n = n - 3;
        }
        return (int) ret;
    }
}
