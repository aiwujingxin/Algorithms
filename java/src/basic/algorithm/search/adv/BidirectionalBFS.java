package basic.algorithm.search.adv;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 11:55
 */
public class BidirectionalBFS {

    public static int bidirectionalBFS(Node startNode, Node targetNode) {
        // 队列用于正向搜索和反向搜索
        Queue<Node> forwardQueue = new LinkedList<>();
        Queue<Node> backwardQueue = new LinkedList<>();

        // 正向搜索从起始节点开始
        forwardQueue.offer(startNode);
        startNode.visited = true;
        startNode.distance = 0;

        // 反向搜索从目标节点开始
        backwardQueue.offer(targetNode);
        targetNode.visited = true;
        targetNode.distance = 0;

        while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()) {
            // 正向搜索
            int forwardSize = forwardQueue.size();
            for (int i = 0; i < forwardSize; i++) {
                Node currentNode = forwardQueue.poll();

                // 判断当前节点是否在反向搜索的访问过的节点集合中
                if (currentNode.visitedByBackward) {
                    // 找到了双向BFS的交叉节点，返回总距离
                    return currentNode.distance + targetNode.distance;
                }

                // 扩展当前节点的邻居节点
                for (Node neighbor : currentNode.neighbors) {
                    if (!neighbor.visited) {
                        forwardQueue.offer(neighbor);
                        neighbor.visited = true;
                        neighbor.distance = currentNode.distance + 1;
                    }
                }
            }

            // 反向搜索
            int backwardSize = backwardQueue.size();
            for (int i = 0; i < backwardSize; i++) {
                Node currentNode = backwardQueue.poll();

                // 判断当前节点是否在正向搜索的访问过的节点集合中
                if (currentNode.visitedByForward) {
                    // 找到了双向BFS的交叉节点，返回总距离
                    return currentNode.distance + startNode.distance;
                }

                // 扩展当前节点的邻居节点
                for (Node neighbor : currentNode.neighbors) {
                    if (!neighbor.visited) {
                        backwardQueue.offer(neighbor);
                        neighbor.visited = true;
                        neighbor.distance = currentNode.distance + 1;
                    }
                }
            }
        }

        // 如果无法找到路径，返回-1
        return -1;
    }

    static class Node {
        int val;
        List<Node> neighbors;
        boolean visited;
        boolean visitedByForward;
        boolean visitedByBackward;
        int distance;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
            this.visited = false;
            this.visitedByForward = false;
            this.visitedByBackward = false;
            this.distance = 0;
        }
    }
}
