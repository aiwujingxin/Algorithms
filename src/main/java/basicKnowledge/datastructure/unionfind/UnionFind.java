package basicKnowledge.datastructure.unionfind;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/16 20:41
 * <a href="https://courses.cs.duke.edu/cps100e/fall09/notes/UnionFind.pdf">...</a>
 * <a href="https://github.com/AhmadElsagheer/Competitive-programming-library/blob/master/data_structures/UnionFind.java">...</a>
 */
public class UnionFind {

    int[] p, rank, setSize;
    int numSets;

    public UnionFind(int N) {
        p = new int[numSets = N];
        rank = new int[N];
        setSize = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
            setSize[i] = 1;
        }
    }

    public int find(int i) {
        return p[i] == i ? i : (p[i] = find(p[i]));
    }

    public boolean isSameSet(int i, int j) {
        return find(i) == find(j);
    }

    public void union(int i, int j) {
        if (isSameSet(i, j)) {
            return;
        }
        numSets--;
        int x = find(i), y = find(j);
        if (rank[x] > rank[y]) {
            p[y] = x;
            setSize[x] += setSize[y];
        } else {
            p[x] = y;
            setSize[y] += setSize[x];
            if (rank[x] == rank[y]) rank[y]++;
        }
    }

    public int numDisjointSets() {
        return numSets;
    }

    public int sizeOfSet(int i) {
        return setSize[find(i)];
    }
}
