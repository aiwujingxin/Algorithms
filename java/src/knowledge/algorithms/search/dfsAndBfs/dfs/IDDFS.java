package knowledge.algorithms.search.dfsAndBfs.dfs;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 5/27/25 02:46
 * @description IDDFS
 */

public class IDDFS {

    static int maxDepth;             // 当前的迭代深度上限
    static boolean found = false;    // 是否找到目标
    static final int INF = 100000;   // 用于剪枝或标记最大深度
    static String target = "目标状态"; // 根据题意定义

    public static void main(String[] args) {
        String start = "初始状态";  // 初始化
        for (maxDepth = 0; maxDepth < INF; maxDepth++) {
            found = false;
            dfs(start, 0);
            if (found) {
                System.out.println("找到，最浅深度为: " + maxDepth);
                break;
            }
        }
        if (!found) {
            System.out.println("未找到");
        }
    }

    // IDDFS 的核心 DFS 模板
    static void dfs(String state, int depth) {
        if (depth > maxDepth || found) {
            return;
        }
        if (state.equals(target)) {
            found = true;
            return;
        }
        // 生成下一层状态
        for (String next : getNextStates(state)) {
            dfs(next, depth + 1);
            if (found) return; // 剪枝
        }
    }

    // 示例：根据当前状态生成所有可能的下一步状态
    static List<String> getNextStates(String state) {
        // 根据具体问题实现状态转移逻辑
        return new ArrayList<>();
    }
}
