package offer

import (
	"fmt"
	"strconv"
	"strings"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/16 20:53
 */

type Codec struct{}

func ConstructorCodec() Codec {
	return Codec{}
}

func (Codec) serialize(root *TreeNode) string {
	sb := &strings.Builder{}
	var dfs func(*TreeNode)
	dfs = func(node *TreeNode) {
		if node == nil {
			sb.WriteString("null,")
			return
		}
		sb.WriteString(strconv.Itoa(node.Val))
		sb.WriteByte(',')
		dfs(node.Left)
		dfs(node.Right)
	}
	dfs(root)
	fmt.Print(sb.String())
	return sb.String()
}

func (Codec) deserialize(data string) *TreeNode {
	sp := strings.Split(data, ",")
	var build func() *TreeNode
	build = func() *TreeNode {
		if sp[0] == "null" {
			sp = sp[1:]
			return nil
		}
		val, _ := strconv.Atoi(sp[0])
		sp = sp[1:]
		return &TreeNode{val, build(), build()}
	}
	return build()
}
