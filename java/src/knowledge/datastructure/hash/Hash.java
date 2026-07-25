package knowledge.datastructure.hash;

import knowledge.datastructure.hash.impl.MyHashMap;
import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/23 16:44
 * @description 哈希表 (Hash) 精选题单(导航索引)
 * <解题识别>
 * 出现以下信号优先考虑哈希:需要 O(1) 判断「存在性 / 出现次数 / 映射关系」,或以「值 / 前缀特征」为键快速聚类。
 * 1. 查存在性 / 去重:用 HashSet,把 O(n) 查找降为 O(1)。
 * 2. 计数 / 分组:用 HashMap<键, 次数或列表>,一次遍历完成统计与归类。
 * 3. 前缀和 + 哈希:把「区间和为 K」转化为「两前缀和之差」,用哈希记录历史前缀。
 * <核心性质>
 * - 均摊 O(1) 增删查,最坏 O(n)(退化为链表 / 哈希碰撞);无序,不能求区间 / 顺序统计。
 * - 键需可哈希且实现 equals/hashCode;自定义对象作键务必重写这两个方法。
 * - 空间换时间:典型空间 O(n),用额外表记录中间状态换取查询加速。
 * <模板实现>
 * @see MyHashMap         从零实现哈希表(拉链法 + 取模散列,理解装载因子与碰撞)
 * <I. 存在性与去重>
 * 策略:遍历时把已见元素放入 Set,查询是否出现过即为 O(1) 命中。
 * @see LeetCode217   存在重复元素 (Set 去重)
 * @see LeetCode219   存在重复元素 II (Set + 下标窗口)
 * @see LeetCode187   重复的DNA序列 (定长子串哈希)
 * @see LeetCode41    缺失的第一个正数 (原地哈希, 值即下标)
 * @see LeetCode202   快乐数 (Set 判环)
 * <II. 计数与分组>
 * 策略:以「值 / 归一化特征」为键,累加次数或聚合成列表。
 * @see LeetCode1     两数之和 (值 -> 下标)
 * @see LeetCode49    字母异位词分组 (排序串 / 计数串为键)
 * @see LeetCode249   移位字符串分组 (差分序列为键)
 * @see LeetCode288   单词的唯一缩写 (缩写为键)
 * <III. 前缀和 + 哈希>
 * 策略:边扫边记录前缀特征出现情况,用「当前值 - 目标」反查历史。
 * @see LeetCode560   和为 K 的子数组 (前缀和计数)
 * @see LeetCode128   最长连续序列 (Set + 序列头判定, O(n))
 * <IV. 哈希设计 (Design)>
 * 策略:自己维护底层结构达成 O(1) 约束,常配合数组 / 双向链表。
 * @see LeetCode706   设计哈希映射 (拉链法)
 * @see LeetCode705   设计哈希集合
 * @see LeetCode380   O(1) 时间插入、删除和获取随机元素 (哈希 + 动态数组)
 * @see LeetCode381   O(1) 时间插入、删除和获取随机元素 - 允许重复
 * @see LeetCode146   LRU 缓存 (哈希 + 双向链表)
 * @see LeetCode355   设计推特 (哈希 + 堆合并)
 * @see LeetCode208   实现 Trie (前缀树, 哈希子节点)
 */
public interface Hash {
}
