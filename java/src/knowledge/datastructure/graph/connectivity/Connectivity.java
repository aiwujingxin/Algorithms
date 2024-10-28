package knowledge.datastructure.graph.connectivity;

import knowledge.datastructure.graph.connectivity.impl.Kosaraju;
import knowledge.datastructure.graph.connectivity.impl.Tarjan;

import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 10/19/24 21:52
 * @description 连通分量
 * @see Kosaraju
 * @see Tarjan
 */
public interface Connectivity {

    List<List<Integer>> findSCC(int n, List<Integer>[] graph);

}
