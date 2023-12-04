package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/4 16:49
 */
public class LeetCode458 {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        int sum = 1;
        while (sum < buckets) {
            sum *= minutesToTest / minutesToDie + 1;
            pigs++;
        }
        return pigs;
    }
}

