package leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/10 22:41
 */
public class LeetCode901 {

    class StockSpanner {

        Stack<Integer> stack;
        List<Integer> list;
        List<Integer> res;

        public StockSpanner() {
            stack = new Stack<>();
            list = new ArrayList<>();
            res = new ArrayList<>();
        }

        public int next(int price) {
            if (stack.isEmpty() || list.get(stack.peek()) > price) {
                list.add(price);
                stack.push(list.size() - 1);
                res.add(1);
                return 1;
            }
            int ans = 1;
            while (!stack.isEmpty() && list.get(stack.peek()) < price) {
                ans += this.res.get(stack.pop());
            }
            // add ele
            list.add(price);
            stack.push(list.size() - 1);

            res.add(ans);
            System.out.println(list);
            System.out.println(res);
            return ans;
        }
    }
}
