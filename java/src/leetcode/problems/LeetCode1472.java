package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/24 11:45
 */
public class LeetCode1472 {

    class BrowserHistory {

        List<String> list;
        int cur;
        int front;

        public BrowserHistory(String homepage) {
            this.list = new ArrayList<>();
            this.list.add(homepage);
            this.cur = 0;
            this.front = 0;
        }

        public void visit(String url) {
            if (this.cur == this.list.size() - 1) {
                this.list.add(url);
            } else {
                this.list.set(this.cur + 1, url);
            }
            this.cur++;
            this.front = this.cur;
        }

        public String back(int steps) {
            int index = Math.max(this.cur - steps, 0);
            this.cur = index;
            return this.list.get(index);
        }

        public String forward(int steps) {
            int index = Math.min(this.cur + steps, this.front);
            this.cur = index;
            return this.list.get(index);
        }
    }
}
