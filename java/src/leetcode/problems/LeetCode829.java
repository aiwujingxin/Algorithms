package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/3/25 11:59
 * <a href="https://leetcode.cn/problems/consecutive-numbers-sum/solutions/1532952/by-ac_oier-220q/"></a>
 */
public class LeetCode829 {

    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        n *= 2;
        for (int k = 1; k * k < n; k++) {
            if (n % k != 0) continue;
            if ((n / k - (k - 1)) % 2 == 0) ans++;
        }
        return ans;
    }

    public int consecutiveNumbersSum_TEL(int n) {
        int cnt = 1;
        for (int l = 1; l <= n / 2; l++) {
            double r = solveForEnd(l, n);
            if (r == -1) continue;
            if ((l + r) * (r - l + 1) / 2 == n) {
                cnt++;
            }
        }
        return cnt;
    }

    public static double solveForEnd(long start, long sum) {
        // 一元二次方程: a * end² + b * end + c = 0
        double a = 1;
        double b = 1;
        double c = -(start * start - start + 2 * sum);
        // 计算判别式
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return -1;
        }
        // 求根公式
        double end1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double end2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        // 选择正根（末项必须大于等于首项）
        double end = (end1 >= start) ? end1 : end2;
        if (end < start) {
            return -1;
        }
        return Math.round(end);
    }
}
