package knowledge.datastructure.graph.topological;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/2 23:48
 * @description 拓扑排序
 * @see leetcode.problems.LeetCode210 课程表II
 * @see leetcode.problems.LeetCode310 最小高度树
 */
public interface Topological {

    int[] findOrder(int n, int[][] edges);
}
