package hot100

import (
	"strconv"
	"strings"
)

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/solutions/552538/golang-with-queue/

type Codec struct {
}

func ConstructorCodec() Codec {
	return Codec{}
}

// Serializes a tree to a single string.
func (this *Codec) serialize(root *TreeNode) string {
	if root == nil {
		return "X,"
	}
	left := this.serialize(root.Left)
	right := this.serialize(root.Right)

	return strconv.Itoa(root.Val) + "," + left + right
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {
	nodes := strings.Split(data, ",")
	return this.deserializeHelper(&nodes)
}

func (this *Codec) deserializeHelper(nodes *[]string) *TreeNode {
	nodeVal := "X"
	if len(*nodes) > 0 {
		nodeVal = (*nodes)[0]
		*nodes = (*nodes)[1:]
	}
	if nodeVal == "X" {
		return nil
	}
	val, _ := strconv.Atoi(nodeVal)
	root := TreeNode{Val: val}
	root.Left = this.deserializeHelper(nodes)
	root.Right = this.deserializeHelper(nodes)

	return &root

}
