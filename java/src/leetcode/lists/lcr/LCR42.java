package leetcode.lists.lcr;


import knowledge.datastructure.linkedlist.DoubleLinkedList;
import knowledge.datastructure.linkedlist.Node;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/24 10:18
 */
public class LCR42 {

    class RecentCounter {

        DoubleLinkedList list;

        public RecentCounter() {
            list = new DoubleLinkedList();
        }

        public int ping(int t) {
            while (!list.isEmpty() && t - list.getFirst().val > 3000) {
                list.removeFirst();
            }
            list.addLast(new Node(t));
            return list.size();
        }
    }
}


