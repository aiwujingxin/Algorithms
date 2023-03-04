package leetcode.competition.doubleweekly.week99;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/3/4 22:45
 */
public class LeetCode6311 {

    public long coloredCells(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 5;
        }
        if (n == 3) {
            return 13;
        }
        long side = 2L * n - 1;

        long from = n - 1;
        long minus = 0;
        for (long i = 0; i <= from; i++) {
            minus += i;
        }
        return side * side - minus * 4L;
    }
}
