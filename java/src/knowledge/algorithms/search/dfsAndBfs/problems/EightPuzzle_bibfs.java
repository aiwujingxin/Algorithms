package knowledge.algorithms.search.dfsAndBfs.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/23 15:32
 * @description 八数码 双向BFS
 * @link <a href="https://www.acwing.com/solution/content/142925/"></a>
 */

public class EightPuzzle_bibfs {

    private static final String END = "12345678x";
    private static String start;
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static final char[] p = {'u', 'r', 'd', 'l'};

    // 检查是否为奇排列（逆序对数量为奇数）
    private static boolean check(String x) {
        int ans = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                if (x.charAt(j) < x.charAt(i)) {
                    ans++;
                }
            }
        }
        return (ans & 1) == 1;
    }

    // 扩展队列
    private static int expand(Queue<String> q, Map<String, Integer> d1, Map<String, Integer> d2) {
        int k = d1.get(q.peek()); // 取出当前第一层元素
        while (!q.isEmpty() && d1.get(q.peek()) == k) {
            //将大小相同的元素全部扩展
            //每次 expand 都只扩展 当前层的所有节点（层级一致），类似于 同步 BFS 层数推进。
            //避免了混合多层状态扩展，便于更快遇到另一边的搜索边界。
            //可看作带宽优先的策略，降低重复路径探索的可能性，减小了不必要的搜索。
            String t = q.poll();
            int x = 0, y = 0;

            // 找到'x'的位置
            for (int i = 0; i < 9; i++) {
                if (t.charAt(i) == 'x') {
                    x = i / 3;
                    y = i % 3;
                    break;
                }
            }

            String keep = t; // 保存原始状态
            for (int i = 0; i < 4; i++) { // 扩展四个方向
                int a = x + dx[i];
                int b = y + dy[i];
                if (a < 0 || b < 0 || a >= 3 || b >= 3) {
                    continue;
                }

                // 交换位置
                char[] chars = t.toCharArray();
                chars[x * 3 + y] = chars[a * 3 + b];
                chars[a * 3 + b] = 'x';
                t = new String(chars);

                if (!d1.containsKey(t) || d1.get(t) > d1.get(keep) + 1) {
                    d1.put(t, d1.get(keep) + 1);
                    if (d2.containsKey(t)) {
                        return d1.get(t) + d2.get(t); // 两个队列相遇，返回总步数
                    }
                    q.offer(t);
                }
                t = keep; // 恢复原始状态
            }
        }
        return -1; // 本轮扩展未找到解
    }

    // 双向BFS
    private static int bfs() {
        if (start.equals(END)) {
            return 0;
        }
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        Map<String, Integer> d1 = new HashMap<>();
        Map<String, Integer> d2 = new HashMap<>();

        q1.offer(start);
        q2.offer(END);
        d1.put(start, 0);
        d2.put(END, 0);

        int ans;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            // 优先扩展较小的队列
            if (q1.size() < q2.size()) {
                ans = expand(q1, d1, d2);
            } else {
                ans = expand(q2, d2, d1);
            }
            if (ans != -1) return ans;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder st = new StringBuilder();
        StringBuilder startBuilder = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            char op = scanner.next().charAt(0);
            if (op != 'x') {
                st.append(op);
            }
            startBuilder.append(op);
        }

        start = startBuilder.toString();
        if (check(st.toString())) {
            System.out.println("-1");
        } else {
            System.out.println(bfs());
        }
    }
}
