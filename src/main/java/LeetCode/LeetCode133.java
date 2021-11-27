package LeetCode;

import common.GraphNode;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author jingxinwu
 * @date 2021-07-10 5:15 下午
 */
public class LeetCode133 {

    private HashMap<GraphNode, GraphNode> visited = new HashMap<>();

    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return node;
        }

        // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
        GraphNode cloneNode = new GraphNode(node.val, new ArrayList<>());
        // 哈希表存储
        visited.put(node, cloneNode);

        // 遍历该节点的邻居并更新克隆节点的邻居列表
        for (GraphNode neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }

}
