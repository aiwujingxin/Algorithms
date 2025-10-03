package knowledge.algorithms.search.dfsAndBfs.problems;

import knowledge.algorithms.search.dfsAndBfs.bfs.BiBFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

/**
 * @author wujingxinit@outlook.com
 * @date 9/18/25 15:08
 * @description <a href="https://vjudge.net/problem/HDU-1401"></a>
 */

public class HDU1401_solitaire {
    // 棋子移动规则的偏移量
    private static final int[] dr = {-1, 2, 0, 0}; // 行变化: 上1, 下2, 左0, 右0
    private static final int[] dc = {0, 0, -1, 2}; // 列变化: 上0, 下0, 左1, 右2

    // 辅助类，用于表示棋子坐标，并使其可排序
    private static class Piece implements Comparable<Piece> {
        int r, c;

        Piece(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Piece other) {
            if (this.r != other.r) {
                return this.r - other.r;
            }
            return this.c - other.c;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Piece piece = (Piece) obj;
            return r == piece.r && c == piece.c;
        }
    }

    /**
     * 将一组棋子转换为规范化的字符串状态。
     * 规范化包括排序，以确保状态的唯一性。
     */
    private static String piecesToState(List<Piece> pieces) {
        Collections.sort(pieces);
        StringBuilder sb = new StringBuilder();
        for (Piece p : pieces) {
            sb.append(p.r).append(p.c);
        }
        return sb.toString();
    }

    /**
     * 从输入行解析出初始的棋子列表。
     */
    private static List<Piece> parsePieces(Scanner scanner) {
        List<Piece> pieces = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            // 输入是1-8，我们转为0-7
            int r = scanner.nextInt() - 1;
            int c = scanner.nextInt() - 1;
            pieces.add(new Piece(r, c));
        }
        return pieces;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            List<Piece> startPieces = parsePieces(scanner);
            // 第二行的输入可能在同一行或下一行，需要重新创建Scanner来处理
            // 简单的做法是假设输入总是两行
            List<Piece> endPieces = parsePieces(scanner);
            String startState = piecesToState(startPieces);
            String endState = piecesToState(endPieces);
            // 定义状态转移函数 getNeighbors
            Function<String, List<String>> getNeighbors = (currentState) -> {
                List<String> neighbors = new ArrayList<>();
                List<Piece> currentPieces = new ArrayList<>();
                // 从状态字符串反向解析出棋子位置
                for (int i = 0; i < 8; i += 2) {
                    int r = Character.getNumericValue(currentState.charAt(i));
                    int c = Character.getNumericValue(currentState.charAt(i + 1));
                    currentPieces.add(new Piece(r, c));
                }
                // 遍历4个棋子，尝试移动每一个
                for (int i = 0; i < 4; i++) {
                    Piece movingPiece = currentPieces.get(i);
                    // 尝试4种移动
                    for (int j = 0; j < 4; j++) {
                        int newR = movingPiece.r + dr[j];
                        int newC = movingPiece.c + dc[j];
                        // 1. 检查是否出界 (0-7)
                        if (newR < 0 || newR >= 8 || newC < 0 || newC >= 8) {
                            continue;
                        }
                        // 2. 检查是否与其它棋子重叠
                        boolean collision = false;
                        for (int k = 0; k < 4; k++) {
                            if (i == k) continue; // 不和自己比较
                            if (currentPieces.get(k).r == newR && currentPieces.get(k).c == newC) {
                                collision = true;
                                break;
                            }
                        }
                        if (collision) {
                            continue;
                        }
                        // 生成新状态
                        List<Piece> newPieces = new ArrayList<>(currentPieces);
                        newPieces.set(i, new Piece(newR, newC)); // 更新移动的棋子位置
                        neighbors.add(piecesToState(newPieces));
                    }
                }
                return neighbors;
            };
            // 创建并调用 BiBFS 模板
            BiBFS<String> bfs = new BiBFS<>();
            int steps = bfs.search(startState, endState, getNeighbors);
            if (steps != -1 && steps <= 8) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }
}
