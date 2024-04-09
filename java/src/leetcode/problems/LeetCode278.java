package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/6 00:23
 */
public class LeetCode278 {

    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = l + r >> 1;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}
