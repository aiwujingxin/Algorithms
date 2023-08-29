package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/17 17:24
 */

func inorderSuccessor(root *TreeNode, p *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	var res *TreeNode
	flag := false
	var dfs func(root *TreeNode, p *TreeNode)
	dfs = func(root *TreeNode, p *TreeNode) {
		if root == nil {
			return
		}
		dfs(root.Left, p)
        if res != nil {
            return
        }
		if root == p {
			flag = true
		}
		if flag && root.Val > p.Val {
			res = root
			flag = false
		}
		dfs(root.Right, p)
	}
	dfs(root, p)
	return res
}
