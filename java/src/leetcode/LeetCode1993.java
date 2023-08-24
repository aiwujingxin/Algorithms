package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/24 22:33
 */
public class LeetCode1993 {

    class LockingTree {

        int[] parent;
        int[] lockUser;
        Map<Integer, Set<Integer>> map = new HashMap<>();


        public LockingTree(int[] parent) {
            int n = parent.length;
            this.parent = parent;
            lockUser = new int[n];
            for (int i = -1; i < n; i++) {
                map.put(i, new HashSet<>());
            }
            for (int i = 0; i < n; i++) {
                map.get(parent[i]).add(i);
            }// 把当前节点放到对应的父节点里面
        }

        public boolean lock(int num, int user) {
            if (lockUser[num] == 0) {
                lockUser[num] = user;
                return true;
            }
            return false;
        }

        public boolean unlock(int num, int user) {
            if (lockUser[num] == user) {
                lockUser[num] = 0;
                return true;
            }
            return false;
        }

        public boolean upgrade(int num, int user) {
            // 判断本身和祖先结点是否上锁
            int find = num;
            while (find != -1) {
                if (lockUser[find] != 0) {
                    return false;
                }
                find = parent[find];
            }

            boolean hasSubLock = false;// 判断是否有子孙结点上锁
            Deque<Integer> deque = new LinkedList<>();
            deque.offer(num);// 当前节点入队列
            // 遍历其所有的子孙结点
            while (!deque.isEmpty()) {
               Integer node =  deque.poll();
                for (int each : map.get(node)) {
                    if (lockUser[each] != 0) {
                        lockUser[each] = 0;
                        hasSubLock = true;
                    }
                    deque.offer(each);
                }
            }
            if (hasSubLock) {
                lockUser[num] = user;
            }
            return hasSubLock;
        }
    }
}
