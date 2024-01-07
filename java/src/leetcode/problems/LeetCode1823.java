package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/3 21:33
 * @description 约瑟夫环
 * @link <a href="https://godweiyang.com/2020/03/19/leetcode-interview-62/"></a>
 * 映射关系 𝑓(𝑛)=(𝑓(𝑛−1)+𝑚)%𝑛
 */
public class LeetCode1823 {

    public int findTheWinne(int n, int k) {
        if (n <= 1) {
            return n;
        }
        int ans = (findTheWinne(n - 1, k) + k) % n;
        return ans == 0 ? n : ans;
    }

    public int findTheWinner_v2(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            list.add(i);
        }
        int cur = 0;
        while (list.size() > 1) {
            int kill = (cur + k - 1) % list.size();
            list.remove(kill);
            cur = kill % list.size();
        }
        return list.get(0);
    }

}
