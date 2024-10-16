package knowledge.algorithms.search.dfsAndBfs.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 22:48
 */

public class IDAStar {
    // 目标状态
    // ...

    // 启发式函数，用于估计到达目标的代价
    public int heuristic(Node node) {
        // ...
        return 0;
    }

    // 估计从节点n到达目标的代价
    public int f(Node node) {
        return node.cost + heuristic(node);
    }

    // 判断节点是否为目标状态
    public boolean isGoal(Node node) {
        // ...
        return false;
    }

    // 生成子节点
    public List<Node> generateSuccessors(Node node) {
        List<Node> successors = new ArrayList<>();
        // ...
        return successors;
    }

    // IDA*算法的实现
    public Node idaStar(Node root) {
        int threshold = heuristic(root);
        while (true) {
            Map<Node, Integer> visited = new HashMap<>();
            int minCost = search(root, 0, threshold, visited);
            if (minCost == -1) {
                return null;  // 没有找到解
            }
            if (minCost == Integer.MAX_VALUE) {
                return root;  // 已经找到解
            }
            threshold = minCost;
        }
    }

    // 搜索函数
    private int search(Node node, int cost, int threshold, Map<Node, Integer> visited) {
        int f = cost + heuristic(node);
        if (f > threshold) {
            return f;
        }
        if (isGoal(node)) {
            return Integer.MAX_VALUE;
        }
        int minCost = Integer.MAX_VALUE;
        List<Node> successors = generateSuccessors(node);
        for (Node successor : successors) {
            int successorCost = node.cost + 1;  // 假设每个移动的成本都是1
            if (!visited.containsKey(successor) || successorCost < visited.get(successor)) {
                visited.put(successor, successorCost);
                int result = search(successor, successorCost, threshold, visited);
                if (result == Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (result < minCost) {
                    minCost = result;
                }
            }
        }
        return minCost;
    }


    static class Node {
        // 节点的状态
        // ...

        // 节点的启发式估计值（即估计到达目标的代价）
        int heuristic;

        // 节点的路径成本
        int cost;

        // 父节点
        Node parent;

        // 构造函数
        // ...
    }

}
