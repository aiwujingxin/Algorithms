package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/9 18:43
 */
public class LeetCode1656 {


    class OrderedStream {

        String[] strings;
        int ptr = 0;

        public OrderedStream(int n) {
            strings = new String[1001];
        }

        public List<String> insert(int idKey, String value) {
            strings[idKey] = value;
            if (strings[idKey] != null && idKey == ptr) {
                List<String> list = new ArrayList<>();
                while (strings[idKey] != null) {
                    list.add(strings[idKey]);
                    ptr++;
                }
                ptr++;
                return list;
            }
            return new ArrayList<>();
        }
    }

}


