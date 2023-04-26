package offer

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/4 15:11
 */

func copyRandomList(head *Node) *Node {

	if head == nil {
		return head
	}
	mp := make(map[*Node]*Node)

	var dfs func(node *Node) *Node

	dfs = func(node *Node) *Node {
		if node == nil {
			return nil
		}
		if k, ok := mp[node]; ok {
			return k
		}
		newHead := &Node{
			Val: node.Val,
		}
		mp[node] = newHead
		newHead.Random = dfs(node.Random)
		newHead.Next = dfs(node.Next)
		return newHead
	}
	return dfs(head)
}
