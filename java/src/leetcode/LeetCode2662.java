package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/8 17:52
 */
public class LeetCode2662 {

    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        Map<Position, List<Position>> graph = new HashMap<>();
        List<Edge> list = new ArrayList<>();
        for (int[] specialRoad : specialRoads) {
            Position position1 = new Position(specialRoad[0], specialRoad[1]);
            Position position2 = new Position(specialRoad[2], specialRoad[3]);
            Edge edge = new Edge(position1, position2, specialRoad[4]);
            list.add(edge);
        }

        int[] dist = new int[10001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(start[0], start[1]));

        while (!queue.isEmpty()) {

            Position position = queue.poll();




        }


        return 0;
    }

    static class Edge {
        public Position a;
        public Position b;
        public int cost;

        public Edge(Position a, Position b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    static class Position {
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }
}



