package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/25 15:36
 */
public class LeetCode1414 {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        int a = 1;
        int b = 1;
        while (b < k) {
            int c = a + b;
            if (c <= k) {
                list.add(c);
            }
            int t = b;
            b = c;
            a = t;
        }
        int cnt = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            while (k >= list.get(i)) {
                k -= list.get(i);
                cnt++;
            }
        }
        return cnt;
    }
}
