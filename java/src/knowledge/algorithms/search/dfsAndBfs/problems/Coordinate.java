package knowledge.algorithms.search.dfsAndBfs.problems;

import java.util.Objects;

/**
 * @author wujingxinit@outlook.com
 * @date 9/18/25 17:35
 * 一个表示二维坐标 (x, y) 的不可变类。
 */
public class Coordinate {

    public final int x;
    public final int y;

    /**
     * 创建一个新的二维坐标。
     *
     * @param x X 坐标
     * @param y Y 坐标
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("Coord2D(x=%d, y=%d)", x, y);
    }
}
