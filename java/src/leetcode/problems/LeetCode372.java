package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/16 17:04
 */
public class LeetCode372 {

    public int superPow(int a, int[] b) {
        if (b == null || b.length == 0 || a == 1) {
            return a;
        }
        List<Integer> list = new ArrayList<>();
        for (int j : b) {
            list.add(j);
        }
        return (int) superPow(a, list) % 1337;
    }

    public double superPow(int a, List<Integer> list) {
        if (list.isEmpty()) {
            return 1;
        }
        int num = list.remove(list.size() - 1);
        return (myPow(a, num) * myPow(superPow(a, list), 10)) % 1337;
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (x == 1 || x == 0) {
            return x;
        }
        if (n < 0) {
            return 1 / dfs(x, -n);
        }
        return dfs(x, n);
    }

    private double dfs(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        x %= 1337;

        if (n % 2 == 0) {
            return dfs(x * x, n / 2);
        }
        return x * dfs(x * x, n / 2);
    }
}
