package knowledge.datastructure.graph.eulergraph;

/**
 * @author wujingxinit@outlook.com
 * @date 10/27/24 00:15
 * @description 欧拉图
 * 通路:        从图中某个节点出发，经过若干条边到达另一个节点的路径
 * 简单通路:    不重复经过任何顶点的通路
 * 回路:        起点和终点相同的通路
 * 简单回路:    不重复经过除起点和终点外其他顶点的回路
 * 欧拉路:      从图中某个节点出发遍历整个图, 经过图中每一条边且仅经过一次。
 * 欧拉回路:    一条起点和终点相同的欧拉路
 * 欧拉图:      一个图中有欧拉回路, 则称这个图为欧拉图
 * 欧拉路问题:  1. 图应该是连通图 2. 判断是否存在欧拉路或者欧拉回路 3.打印欧拉路
 * 无向图有欧拉回路: 当且仅当所有顶点均为偶数度
 * 有向图有欧拉回路: 记一个点出度为1, 入度为-1. 当且仅当所有点的度数为0
 */
public interface EulerGraph {

    boolean isEulerCircuit(int n, int[][] edges);
}
