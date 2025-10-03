package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/8/25 16:17
 */
public class LeetCode3296 {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long l = 1;
        long r = Long.MAX_VALUE;
        while (l < r) {
            long m = l + r >> 1;
            if (check(mountainHeight, workerTimes, m))
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    private boolean check(int mountainHeight, int[] workerTimes, long m) {
        double len = 0;
        for (int workerTime : workerTimes) {
            double t = lenOf(workerTime, m);
            len += t;
        }
        return len >= mountainHeight;
    }

    // 计算该工人在time时间内可以下降的长度
    private long lenOf(int workerTime, long time) {
        long l = 1;
        long r = time;
        while (l < r) {
            long m = l + r + 1 >> 1;
            if (check2(workerTime, m, time))
                l = m;
            else
                r = m - 1;
        }
        if (check2(workerTime, l, time))
            return l;
        return l - 1;
    }

    private boolean check2(long workerTime, long cnt, long total) {
        return (1 + cnt) <= total / workerTime * 2 / cnt;
    }
}
