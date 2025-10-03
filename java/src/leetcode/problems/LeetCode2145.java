package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/12/25 16:08
 */
public class LeetCode2145 {

    public int numberOfArrays(int[] differences, int lower, int upper) {
        int left = findL(differences, lower, upper);
        int right = findR(differences, lower, upper);
        if (left == Integer.MAX_VALUE || right == Integer.MAX_VALUE) return 0;
        return right - left + 1;
    }

    public int findL(int[] ds, int lower, int upper) {
        int l = lower;
        int r = upper;
        while (l < r) {
            int mid = l + r >> 1;
            int res = check(ds, mid, lower, upper);
            if (res == 0) {
                r = mid;
            } else if (res == -1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return check(ds, l, lower, upper) == 0 ? l : Integer.MAX_VALUE;
    }

    public int findR(int[] ds, int lower, int upper) {
        int l = lower;
        int r = upper;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            int res = check(ds, mid, lower, upper);
            if (res == 0) {
                l = mid;
            } else if (res == -1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return check(ds, l, lower, upper) == 0 ? l : Integer.MAX_VALUE;
    }

    public int check(int[] ds, long start, int lo, int up) {
        long cur = start;
        for (int d : ds) {
            cur = cur + d;
            if (cur < lo)
                return -1;
            if (cur > up)
                return 1;
        }
        return 0;
    }
}
