package leetcode.problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023.07.17 22:12
 */
public class LeetCode341 {

    interface NestedInteger {
        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        private final List<Integer> list;
        private final Iterator<Integer> cur;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.list = new ArrayList<>();
            dfs(nestedList);
            this.cur = list.iterator();
        }

        @Override
        public Integer next() {
            return cur.next();
        }

        @Override
        public boolean hasNext() {
            return cur.hasNext();
        }

        private void dfs(List<NestedInteger> nestedList) {
            for (NestedInteger nest : nestedList) {
                if (nest.isInteger()) {
                    list.add(nest.getInteger());
                } else {
                    dfs(nest.getList());
                }
            }
        }
    }
}
