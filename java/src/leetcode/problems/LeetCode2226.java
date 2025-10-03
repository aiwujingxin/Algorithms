package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/17/25 14:34
 */
public class LeetCode2226 {

    public int maximumCandies(int[] candies, long k) {
        long l = 1;
        long r = 0;
        for (int candy : candies) {
            r = Math.max(r, candy);
        }
        while (l < r) {
            long m = l + r + 1 >> 1;
            if (cal(candies, m) >= k) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        if (cal(candies, l) < k) {
            return (int) l - 1;
        }
        return (int) l;
    }

    public long cal(int[] candies, long mid) {
        long cnt = 0;
        for (int candy : candies) {
            cnt += candy / mid;
        }
        return cnt;
    }
}
