package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 14:52
 */
public class LeetCode65 {

    public boolean isNumber(String s) {
        s = s.trim();
        boolean num = false, dot = false, exp = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '.') {
                if (dot || exp) return false;   // 只能有一个点，且不能在 e 后
                dot = true;
            } else if (c == 'e' || c == 'E') {
                if (exp || !num) return false;  // 只能有一个 e，且 e 前必须有数字
                exp = true;
                num = false;                    // 重置 num，确保 e 后必须接数字
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false; // 符号只能在首位或 e 后
            } else {
                return false;                   // 非法字符
            }
        }
        return num;                             // 最终必须包含数字
    }

    class Solution_DFA {
        // 1. 定义状态常量
        private static final int INIT = 0;         // 初始状态
        private static final int SIGN = 1;         // 符号位
        private static final int INT = 2;          // 整数部分
        private static final int DOT_NO_INT = 3;   // 左侧无整数的小数点
        private static final int DOT_WITH_INT = 4; // 左侧有整数的小数点
        private static final int FRACTION = 5;     // 小数部分
        private static final int EXP = 6;          // 指数符号 (e/E)
        private static final int EXP_SIGN = 7;     // 指数符号位
        private static final int EXP_NUM = 8;      // 指数数字部分

        // 字符类型常量
        private static final int TYPE_DIGIT = 0;
        private static final int TYPE_SIGN = 1;
        private static final int TYPE_DOT = 2;
        private static final int TYPE_EXP = 3;
        private static final int TYPE_OTHER = 4;

        // 2. 辅助方法：将字符映射为类型常量
        private int getCharType(char c) {
            if (c >= '0' && c <= '9') return TYPE_DIGIT;
            if (c == '+' || c == '-') return TYPE_SIGN;
            if (c == '.') return TYPE_DOT;
            if (c == 'e' || c == 'E') return TYPE_EXP;
            return TYPE_OTHER;
        }

        public boolean isNumber(String s) {
            // 3. 构建状态转移表 Map<当前状态, Map<字符类型, 下一个状态>>
            Map<Integer, Map<Integer, Integer>> dfa = new HashMap<>();

            // INIT (0)
            dfa.put(INIT, new HashMap<>() {{
                put(TYPE_DIGIT, INT);
                put(TYPE_SIGN, SIGN);
                put(TYPE_DOT, DOT_NO_INT);
            }});

            // SIGN (1)
            dfa.put(SIGN, new HashMap<>() {{
                put(TYPE_DIGIT, INT);
                put(TYPE_DOT, DOT_NO_INT);
            }});

            // INT (2)
            dfa.put(INT, new HashMap<>() {{
                put(TYPE_DIGIT, INT);
                put(TYPE_DOT, DOT_WITH_INT);
                put(TYPE_EXP, EXP);
            }});

            // DOT_NO_INT (3)
            dfa.put(DOT_NO_INT, new HashMap<>() {{
                put(TYPE_DIGIT, FRACTION);
            }});

            // DOT_WITH_INT (4)
            dfa.put(DOT_WITH_INT, new HashMap<>() {{
                put(TYPE_DIGIT, FRACTION);
                put(TYPE_EXP, EXP);
            }});

            // FRACTION (5)
            dfa.put(FRACTION, new HashMap<>() {{
                put(TYPE_DIGIT, FRACTION);
                put(TYPE_EXP, EXP);
            }});

            // EXP (6)
            dfa.put(EXP, new HashMap<>() {{
                put(TYPE_DIGIT, EXP_NUM);
                put(TYPE_SIGN, EXP_SIGN);
            }});

            // EXP_SIGN (7)
            dfa.put(EXP_SIGN, new HashMap<>() {{
                put(TYPE_DIGIT, EXP_NUM);
            }});

            // EXP_NUM (8)
            dfa.put(EXP_NUM, new HashMap<>() {{
                put(TYPE_DIGIT, EXP_NUM);
            }});

            int state = INIT;
            for (char c : s.toCharArray()) {
                int type = getCharType(c);

                // 如果当前状态不包含该字符类型的转移路径，说明遇到非法字符或非法顺序
                if (!dfa.getOrDefault(state, new HashMap<>()).containsKey(type)) {
                    return false;
                }

                // 转移到下一个状态
                state = dfa.get(state).get(type);
            }

            // 4. 判断最终状态是否为合法的结束状态
            return state == INT || state == DOT_WITH_INT || state == FRACTION || state == EXP_NUM;
        }
    }
}
