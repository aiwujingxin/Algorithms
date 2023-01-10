package leetcode.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/4 00:47
 */

//https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/jian-zhi-offer-62-yuan-quan-zhong-zui-ho-dcow/
public class Offer62_recur {
    int m = 0;

    public int lastRemaining(int n, int m) {
        this.m = m;
        return f(n);
    }

    public int f(int n) {
        if (n == 1) {
            return 0;
        }
        return (f(n - 1) + m) % n;
    }
}
