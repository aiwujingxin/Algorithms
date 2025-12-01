package knowledge.datastructure.string;

import knowledge.datastructure.string.hash.DStringHash;
import knowledge.datastructure.string.hash.RabinKarp;
import knowledge.datastructure.string.hash.StringHash;
import knowledge.datastructure.string.kmp.KMP;
import knowledge.datastructure.string.manacher.Manacher;
import knowledge.datastructure.string.problems.InfixToSuffix;
import knowledge.datastructure.string.problems.NumberToChinese;
import knowledge.datastructure.string.suffix.SuffixArray;
import knowledge.datastructure.string.suffix.SuffixAutomaton;
import knowledge.datastructure.string.suffix.SuffixTree;
import knowledge.datastructure.string.trie.ACAutomaton;
import knowledge.datastructure.string.trie.Trie;
import knowledge.mathematics.BigDecimal;
import leetcode.lists.lcci.LCCI0814;
import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 11/9/24 06:36
 * @description 字符串 & 相关的问题
 * <字符串匹配>
 * @see KMP
 * @see RabinKarp
 * <字符串哈希>
 * @see StringHash
 * @see DStringHash
 * @see RabinKarp
 * <前缀结构>
 * @see Trie
 * @see ACAutomaton
 * <后缀结构>
 * @see SuffixArray
 * @see SuffixAutomaton
 * @see SuffixTree
 * <字符串回文>
 * @see Manacher
 * <动态规划>
 * @see LeetCode1638
 * @see LeetCode72
 * @see LeetCode1143
 * <字符串计算>
 * @see InfixToSuffix       中缀转后缀
 * @see BigDecimal          高精度
 * @see LeetCode150         逆波兰表达式求值 ["2","1","+","3","*"] => ((2 + 1) * 3) = 9
 * @see LeetCode227         基本计算器 II " 3+5 / 2 "
 * @see LeetCode224         基本计算器 "(1+(4+5+2)-3)+(6+8)"
 * @see LeetCode772         基本计算器 III  "2*(5+5*2)/3+(6/2+8)"
 * @see LeetCode241         为运算表达式设计优先级
 * @see LeetCode166         分数到小数
 * <字符串解析>
 * @see LeetCode8           字符串转换整数 (atoi)
 * @see LeetCode65          有效数字
 * @see LeetCode273         整数转换英文表示
 * @see LeetCode12          整数转罗马数字
 * @see LeetCode13          罗马数字转整数
 * @see NumberToChinese
 * @see LeetCode439         三元表达式解析器
 * @see LCCI0814            布尔运算
 * @see LeetCode7           整数反转
 * 1106                     解析布尔表达式
 * <括号问题>
 * @see LeetCode32
 * @see LeetCode921
 * @see LeetCode1541
 * @see LeetCode1963
 * @see LeetCode678_greedy
 * <字典序>
 * @see LeetCode386
 * @see LeetCode440
 * @see LeetCode1985
 */
public interface String {
    /**
     * @author wujingxinit@outlook.com
     * @date 2023/8/30 22:17
     * @description 字符串匹配
     */
    interface Match {

        int strStr(java.lang.String txt, java.lang.String pat);
    }
}
