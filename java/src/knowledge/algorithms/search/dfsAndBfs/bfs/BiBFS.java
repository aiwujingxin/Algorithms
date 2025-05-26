package knowledge.algorithms.search.dfsAndBfs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 11:55
 * @description 双向 BFS
 */

public class BiBFS {

    // 起点和终点
    static String start = "start";
    static String goal = "goal";

    public static void main(String[] args) {
        int result = bfs(start, goal);
        System.out.println("最短步数: " + result);
    }

    static int bfs(String start, String goal) {
        if (start.equals(goal)) return 0;

        Set<String> visitedStart = new HashSet<>();
        Set<String> visitedGoal = new HashSet<>();
        Queue<String> queueStart = new LinkedList<>();
        Queue<String> queueGoal = new LinkedList<>();
        Map<String, Integer> distStart = new HashMap<>();
        Map<String, Integer> distGoal = new HashMap<>();

        visitedStart.add(start);
        visitedGoal.add(goal);
        queueStart.offer(start);
        queueGoal.offer(goal);
        distStart.put(start, 0);
        distGoal.put(goal, 0);

        while (!queueStart.isEmpty() && !queueGoal.isEmpty()) {
            int res;

            // 始端较小就扩展始端，否则扩展终端
            if (queueStart.size() <= queueGoal.size()) {
                res = expand(queueStart, visitedStart, visitedGoal, distStart, distGoal);
            } else {
                res = expand(queueGoal, visitedGoal, visitedStart, distGoal, distStart);
            }

            if (res != -1) return res;
        }

        return -1; // 无法连接
    }

    // 单侧扩展一层
    static int expand(Queue<String> queue, Set<String> visitedThis, Set<String> visitedOther,
                      Map<String, Integer> distThis, Map<String, Integer> distOther) {
        int size = queue.size();
        while (size-- > 0) {
            String current = queue.poll();
            int currDist = distThis.get(current);
            for (String neighbor : getNextStates(current)) {
                if (visitedThis.contains(neighbor)) {
                    continue;
                }
                distThis.put(neighbor, currDist + 1);
                visitedThis.add(neighbor);
                queue.add(neighbor);
                if (visitedOther.contains(neighbor)) {
                    return distThis.get(neighbor) + distOther.get(neighbor); // 相遇
                }
            }
        }
        return -1;
    }

    // 状态转移函数（根据问题定义）
    static List<String> getNextStates(String state) {
        // 根据题意生成所有可达状态
        return new ArrayList<>();
    }
}
