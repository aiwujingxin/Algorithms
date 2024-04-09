package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/5 23:52
 */
public class LeetCode275 {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int hIndex = (left + right + 1) / 2;
            if (n - hIndex >= citations[hIndex]) {
                left = hIndex;
            } else {
                right = hIndex - 1;
            }
        }
        return n - left <= citations[left] ? n - left : n - left - 1;
    }

    public int hIndex_v2(int[] cs) {
        int n = cs.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (cs[mid] < n - mid) l = mid + 1;
            else r = mid;
        }
        if (cs[l] < n - l) {
            return 0;
        }
        return n - l;
    }
}
