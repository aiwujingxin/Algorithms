package leetcode.lists.hot200;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/24 17:15
 */
public class LeetCode359 {

    class Logger {

        private HashMap<String, Integer> msgDict;

        /**
         * Initialize your data structure here.
         */
        public Logger() {
            msgDict = new HashMap<>();
        }

        /**
         * Returns true if the message should be printed in the given timestamp, otherwise returns false.
         */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!this.msgDict.containsKey(message)) {
                this.msgDict.put(message, timestamp);
                return true;
            }
            Integer oldTimestamp = this.msgDict.get(message);
            if (timestamp - oldTimestamp >= 10) {
                this.msgDict.put(message, timestamp);
                return true;
            }
            return false;
        }
    }
}
