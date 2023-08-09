package basic.structure.string;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/1 12:37
 */
public interface Expr {

    //1106. 解析布尔表达式 https://leetcode.cn/problems/parsing-a-boolean-expression/
    boolean parseBoolExpr(String expression);

    //10. 正则表达式匹配 https://leetcode.cn/problems/regular-expression-matching/
    boolean isMatch(String s, String p);

    //439. 三元表达式解析器 https://leetcode.cn/problems/ternary-expression-parser/
    String parseTernary(String expression);
}
