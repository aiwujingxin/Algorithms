package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/5 17:21
 */
public class LeetCode2849 {

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (t == 0) {
            return sx == fx && sy == fy;
        }
        return fy - sy - 1 + fx - sx - 1 == t;
    }
}
