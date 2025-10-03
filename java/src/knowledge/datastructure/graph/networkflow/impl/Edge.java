package knowledge.datastructure.graph.networkflow.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 13:26
 */
public class Edge {

    int to, rev;
    int cap, flow;

    public Edge(int to, int capacity) {
        this.to = to;
        this.cap = capacity;
        this.flow = 0;
    }

    Edge(int to, int rev, int cap) {
        this.to = to;
        this.rev = rev;
        this.cap = cap;
        this.flow = 0;
    }

    int residual() {
        return cap - flow;
    }
}
