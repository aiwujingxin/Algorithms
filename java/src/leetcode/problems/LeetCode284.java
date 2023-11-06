package leetcode.problems;

import java.util.Iterator;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/7 00:25
 */
public class LeetCode284 {

    class PeekingIterator implements Iterator<Integer> {
        Iterator<Integer> iter;
        Integer next;

        public PeekingIterator(Iterator<Integer> iterator) {
            this.iter = iterator;
            if (iter.hasNext()) next = iter.next();
        }

        public Integer peek() {
            return next;
        }

        @Override
        public Integer next() {
            Integer ans = next;
            next = iter.hasNext() ? iter.next() : null;
            return ans;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }
    }
}
