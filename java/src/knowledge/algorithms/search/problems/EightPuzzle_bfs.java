package knowledge.algorithms.search.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 5/22/25 00:40
 * @description 八数码 bfs解法
 * @link <a href="https://www.acwing.com/solution/content/29725/"></a>
 */
public class EightPuzzle_bfs {

    class Main {

        public static void main(String[] args) throws Exception {
            BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
            String[] q = sc.readLine().split(" ");
            StringBuilder start = new StringBuilder();//因为输入问题所以不能直接给一个字符串
            for (String s : q) {
                start.append(s);
            }
            String end = "12345678x";
            System.out.println(bfs(start.toString(), end));//从开始状态到结束状态要多少次交换
        }

        static int bfs(String start, String end) {
            Queue<String> q = new LinkedList<>();//存储所有状态
            Map<String, Integer> map = new HashMap<>();//存储每个状态得交换次数
            q.add(start);
            map.put(start, 0);//存初始状态
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};//四个方向

            while (!q.isEmpty()) {//枚举所有状态
                String t = q.poll();//取出头一个状态并向前寻找（t过程中不能修改，因为有四次变化 而位置都是map[t]+1）
                if (t.equals(end)) return map.get(t);//直到找到结束状态为止，此时因为临近扩散原理所以一定是最小值；
                int k = t.indexOf('x');//找到x的坐标
                int x = k / 3, y = k % 3;//将一维下标转二维坐标利于上下左右改变状态

                for (int i = 0; i < 4; i++) {//每个状态都有四次变化
                    int a = x + dx[i], b = y + dy[i];//变化状态之后x的下标
                    if (a >= 0 && a < 3 && b >= 0 && b < 3) {//变化后不出界就是可用的

                        char[] arr = t.toCharArray();//字符串里面不能交换所以就到字符数组里,不直接修改t（以便后续的次数存储直接+1）
                        swap(arr, k, a * 3 + b);//交换值&变状态（因为前面是一维存储字符串，所以二维坐标转一维下标）
                        String s = new String(arr);//转成字符串，因为定义队列和map是用String的

                        if (map.get(s) == null) {//如果这个状态没出现过就存储这个状态
                            q.add(s);
                            map.put(s, map.get(t) + 1);//变化前的次数值加一，因为是+1所以保证四个方向变化的值都是一样的；
                        }
                    }
                }
            }
            return -1;
        }

        static void swap(char[] c, int a, int b) {//用于交换值来变换状态
            char s = c[a];
            c[a] = c[b];
            c[b] = s;
        }
    }

    class Main_BFS_Cantor {

        static final int[] FACT = {1, 1, 2, 6, 24, 120, 720, 5040, 40320}; // 康托展开
        static final int LEN = 362880; // 9!
        static final int[][] DIR = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // 上左下右

        static int[] start = new int[9];
        static int[] goal = new int[9];
        static boolean[] visited = new boolean[LEN];

        static class Node {
            int[] state = new int[9];
            int dis;

            Node(int[] s, int d) {
                System.arraycopy(s, 0, state, 0, 9);
                dis = d;
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            for (int i = 0; i < 9; i++) start[i] = sc.nextInt();
            for (int i = 0; i < 9; i++) goal[i] = sc.nextInt();

            int ans = bfs();
            System.out.println(ans != -1 ? ans : "Impossible");
        }

        static int cantor(int[] state) {
            int result = 0;
            for (int i = 0; i < 9; i++) {
                int count = 0;
                for (int j = i + 1; j < 9; j++) {
                    if (state[i] > state[j]) count++;
                }
                result += count * FACT[8 - i];
            }
            return result;
        }

        static boolean isGoal(int[] state) {
            return Arrays.equals(state, goal);
        }

        public static int bfs() {
            Queue<Node> queue = new LinkedList<>();
            int code = cantor(start);
            visited[code] = true;
            queue.offer(new Node(start, 0));

            while (!queue.isEmpty()) {
                Node cur = queue.poll();

                if (isGoal(cur.state)) return cur.dis;

                int zero = 0;
                for (; zero < 9; zero++) {
                    if (cur.state[zero] == 0) break;
                }

                int x = zero % 3;
                int y = zero / 3;

                for (int[] d : DIR) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    int nz = ny * 3 + nx;

                    if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                        int[] newState = cur.state.clone();
                        // swap zero and target
                        int tmp = newState[zero];
                        newState[zero] = newState[nz];
                        newState[nz] = tmp;

                        int hash = cantor(newState);
                        if (!visited[hash]) {
                            visited[hash] = true;
                            queue.offer(new Node(newState, cur.dis + 1));
                        }
                    }
                }
            }
            return -1; // Impossible
        }

    }
}
