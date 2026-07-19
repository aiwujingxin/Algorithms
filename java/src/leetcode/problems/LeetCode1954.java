package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 5/6/26 20:27
 */
public class LeetCode1954 {
    public long minimumPerimeter(long neededApples) {
        long l = 1;
        long r = 100000;
        while (l < r) {
            long mid = l + r >> 1;
            if (cal(mid) < neededApples) l = mid + 1;
            else r = mid;
        }
        return l * 8;// 周长;
    }

    private long cal(long n) {
        return (1 + n) * n * (4 * n + 2);
    }
}
