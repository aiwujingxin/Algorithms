package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-21 10:16 PM
 */
public class LeetCode275 {

    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return n - left <= citations[left] ? n - left : n - left - 1;
    }
}
