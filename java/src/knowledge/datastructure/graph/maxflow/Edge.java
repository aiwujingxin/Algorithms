package knowledge.datastructure.graph.maxflow;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 13:26
 */
public class Edge {

    int to, capacity, flow, rev;

    public Edge(int to, int capacity) {
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;
    }

    public Edge(int to, int capacity, int rev) {
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;
        this.rev = rev;
    }
}
