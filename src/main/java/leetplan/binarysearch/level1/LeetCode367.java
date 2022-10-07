package leetplan.binarysearch.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/7 16:13
 */
public class LeetCode367 {

    public boolean isPerfectSquare(int num) {

        if (num == 0 || num == 1) {
            return true;
        }
        int l = 0;
        int r = num;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            long square = (long) mid * mid;

            if (square == num) {
                return true;
            }
            if (square < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
