package knowledge.algorithms.search.dfsAndBfs.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 5/22/25 00:40
 * @description 八数码
 * @link <a href="https://www.acwing.com/solution/content/29725/"></a>
 */
public class EightPuzzle_acw {

    static int bfs(String start, String end) {

        Queue<String> q = new LinkedList<>();//存储所有状态
        Map<String, Integer> map = new HashMap<>();//存储每个状态得交换次数
        q.offer(start);
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
                        q.offer(s);
                        map.put(s, map.get(t) + 1);//变化前的次数值加一，因为是+1所以保证四个方向变化的值都是一样的；
                    }
                }
            }
        }
        return -1;
    }

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

    static void swap(char[] c, int a, int b) {//用于交换值来变换状态
        char s = c[a];
        c[a] = c[b];
        c[b] = s;
    }
}
