package leetcode.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/13 22:21
 */
public class Offer64 {
    int res = 0;
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}
