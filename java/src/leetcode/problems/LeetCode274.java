package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/5 23:44
 */
public class LeetCode274 {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 1000;
        while (left < right) {
            int h = (left + right + 1) / 2;
            if (check(h, citations)) {
                left = h;
            } else {
                right = h - 1;
            }
        }
        return left;
    }

    private boolean check(int h, int[] citations) {
        int cnt = 0;
        for (int citation : citations) {
            if (citation >= h) {
                cnt++;
            }
        }
        return cnt >= h;
    }
}
