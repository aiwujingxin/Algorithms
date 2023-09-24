package leetcode.lists.LCR;

import java.util.LinkedList;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/24 10:18
 */
public class LCR42 {

    class RecentCounter {

        LinkedList<Integer> list;

        public RecentCounter() {
            list = new LinkedList<>();
        }

        public int ping(int t) {
            while (!list.isEmpty() && t - list.getFirst() > 3000) {
                list.removeFirst();
            }
            list.addLast(t);
            return list.size();
        }
    }

}


