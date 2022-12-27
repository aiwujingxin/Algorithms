package topinterview

func copyRandomList(head *Node) *Node {
	if head == nil {
		return nil
	}
	mp := make(map[*Node]*Node)
	var dfs func(node *Node) *Node
	dfs = func(node *Node) *Node {
		if node == nil {
			return nil
		}
		if newNode, ok := mp[node]; ok {
			return newNode
		}
		newNode := &Node{
			Val: node.Val,
		}
		mp[node] = newNode
		newNode.Next = dfs(node.Next)
		newNode.Random = dfs(node.Random)
		return newNode
	}
	return dfs(head)
}
