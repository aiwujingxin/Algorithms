package leetcode.plan.binarysearch.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/9 21:13
 */
public class LeetCode278 {

    public int firstBadVersion(int n) {
        if (n == 1) {
            return 1;
        }
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}
