package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/3 02:03
 */
public class LeetCode752_2bfs_v2 {

    //https://leetcode.cn/problems/open-the-lock/solution/java-752-da-kai-zhuan-pan-suo-bfsbian-li-z3w6/

    public int openLock(String[] deadends, String target) {
        // 记录需要跳过的死亡密码
        HashSet<String> deadSet = new HashSet<>();
        Collections.addAll(deadSet, deadends);
        // 记录已经穷举过的密码，防止走回头路
        HashSet<String> visited = new HashSet<>();
        HashSet<String> q1 = new HashSet<>();
        HashSet<String> q2 = new HashSet<>();


        // 从起点开始启动广度优先搜索
        int step = 0;
        q1.add("0000");
        q2.add(target);
        visited.add("0000");

        while (!q1.isEmpty() && !q2.isEmpty()) {

            // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
            HashSet<String> temp = new HashSet<>();
            /* 将当前队列中的所有节点向周围扩散 */
            for (String curr : q1) {

                /* 判断是否到达终点 */
                if (deadSet.contains(curr)) {
                    continue;
                }
                if (q2.contains(curr)) {
                    return step;
                }

                // 双向BFS遍历，visited.add()一定要放到这里
                // visited的更新是滞后于temp的更新的。这也是为何visited的位置相较于原始BFS算法不同的原因。
                visited.add(curr);

                /* 将一个节点的相邻节点加入队列 */
                for (int j = 0; j < 4; j++) {
                    String next1 = addOne(curr, j);
                    String next2 = minusOne(curr, j);
                    if (!visited.contains(next1)) {
                        temp.add(next1);
                        // visited.add(next1);
                    }
                    if (!visited.contains(next2)) {
                        temp.add(next2);
                        // visited.add(next2);
                    }
                }
            }
            /* 在这里增加步数 */
            step++;
            // temp 相当于 q1
            // 这里交换 q1 q2，下一轮 while 就是扩散 q2
            q1 = q2;
            q2 = temp;
        }
        // 如果穷举完都没找到目标密码，那就是找不到了
        return -1;
    }

    // 将 s[i] 向上拨动一次
    public String addOne(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '9') {
            ch[i] = '0';
        } else {
            ch[i]++;
        }
        return new String(ch);
    }

    // 将 s[i] 向下拨动一次
    public String minusOne(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '0') {
            ch[i] = '9';
        } else {
            ch[i]--;
        }
        return new String(ch);
    }
}
