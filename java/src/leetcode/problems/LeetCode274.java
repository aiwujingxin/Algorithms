package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/15 14:36
 */
public class LeetCode274 {

    public int hIndex(int[] citations) {
        int left = 0, right = 1000;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(mid, citations)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int h, int[] arr) {
        int cnt = 0;
        for (int j : arr) {
            if (j >= h) {
                cnt++;
            }
        }
        return cnt >= h;
    }
}
