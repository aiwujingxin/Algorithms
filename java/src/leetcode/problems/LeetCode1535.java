package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/17 21:07
 */
public class LeetCode1535 {

    public int getWinner(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            list.add(j);
        }
        if (k >= arr.length) {
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                max = Math.max(max, arr[i]);
            }
            return max;
        }
        int res = list.get(0);
        int cnt = 0;
        while (cnt < k) {
            if (res == Math.max(list.get(0), list.get(1))) {
                cnt++;
            } else {
                res = list.get(0);
                cnt = 0;
            }
            Integer num;
            if (list.get(0) > list.get(1)) {
                num = list.remove(1);
            } else {
                num = list.remove(0);
            }
            list.add(num);
        }
        return list.get(0);
    }
}
