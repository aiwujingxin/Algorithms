package knowledge.algorithms.search.adv;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 11:48
 */
public class AStar {

    public static List<int[]> constructPath(Node node) {
        // 回溯构造路径
        List<int[]> path = new ArrayList<>();
        while (node != null) {
            path.add(node.state);
            node = node.parent;
        }
        Collections.reverse(path);
        return path;
    }

    public List<int[]> astarSearch(int[] startState, int[] goalState) {
        // 初始化起始节点和目标节点
        Node startNode = new Node(startState);
        Node goalNode = new Node(goalState);

        // 初始化开放集合和关闭集合
        List<Node> openSet = new ArrayList<>();  // 开放集合用列表实现，保存待扩展的节点
        Set<int[]> closedSet = new HashSet<>();  // 关闭集合用集合实现，保存已经扩展过的节点

        openSet.add(startNode);

        while (!openSet.isEmpty()) {
            // 选择开放集合中总代价最小的节点进行扩展
            Node currentNode = Collections.min(openSet, Comparator.comparingInt(node -> node.totalCost));

            // 若当前节点为目标节点，找到了路径，搜索结束
            if (Arrays.equals(currentNode.state, goalNode.state)) {
                return constructPath(currentNode);
            }

            // 从开放集合中移除当前节点，并将其加入关闭集合
            openSet.remove(currentNode);
            closedSet.add(currentNode.state);

            // 扩展当前节点的邻居节点
            List<Node> neighbors = expandNeighbors(currentNode);

            for (Node neighbor : neighbors) {
                // 如果邻居节点已经在关闭集合中，跳过
                if (closedSet.contains(neighbor.state)) {
                    continue;
                }

                // 计算邻居节点的路径代价和启发式估计值
                int cost = currentNode.cost + 1;  // 假设每个邻居节点的移动代价都为1
                int heuristic = calculateHeuristic(neighbor.state, goalNode.state);

                // 如果邻居节点不在开放集合中，加入开放集合
                if (!openSet.contains(neighbor)) {
                    neighbor.cost = cost;
                    neighbor.heuristic = heuristic;
                    neighbor.totalCost = cost + heuristic;
                    neighbor.parent = currentNode;
                    openSet.add(neighbor);
                } else {
                    // 如果邻居节点已经在开放集合中，更新其路径代价和父节点
                    if (cost < neighbor.cost) {
                        neighbor.cost = cost;
                        neighbor.totalCost = cost + heuristic;
                        neighbor.parent = currentNode;
                    }
                }
            }
        }

        // 若开放集合为空且没有找到路径，搜索失败
        return null;
    }

    private List<Node> expandNeighbors(Node currentNode) {
        return new ArrayList<>();
    }

    private int calculateHeuristic(int[] neighbor, int[] goal) {
        return 0;
    }

    static class Node {
        int[] state;  // 当前节点的状态
        Node parent;  // 父节点
        int cost;  // 从起始节点到当前节点的路径代价
        int heuristic;  // 当前节点到目标节点的启发式估计值（启发函数的值）
        int totalCost;  // 当前节点的总代价（路径代价加启发式估计值）

        public Node(int[] state) {
            this.state = state;
        }
    }
}
