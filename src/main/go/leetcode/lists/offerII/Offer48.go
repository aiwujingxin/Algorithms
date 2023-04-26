package offerII

import (
	"strconv"
	"strings"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/16 20:37
 */

type Codec struct {
}

func ConstructorCodec() Codec {
	return Codec{}
}

// Serializes a tree to a single string.
func (this *Codec) serialize(node *TreeNode) string {
	if node == nil {
		return "[null]"
	}
	queue := make([]*TreeNode, 0, 32)
	queue = append(queue, node)
	list := make([]string, 0, 32)
	for len(queue) > 0 {
		node := queue[0]
		queue = queue[1:]
		if node != nil {
			list = append(list, strconv.Itoa(node.Val))
			queue = append(queue, node.Left)
			queue = append(queue, node.Right)
		} else {
			list = append(list, "null")
		}
	}
	return "[" + strings.Join(list, ",") + "]"
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {
	//fmt.Println(s)
	data = data[1 : len(data)-1]
	if data == "null" {
		return nil
	}
	list := strings.Split(data, ",")
	index := 1
	root := &TreeNode{}
	root.Val, _ = strconv.Atoi(list[0])
	queue := make([]*TreeNode, 0, 32)
	queue = append(queue, root)
	for len(queue) > 0 {
		node := queue[0]
		queue = queue[1:]
		if list[index] != "null" {
			node.Left = &TreeNode{}
			node.Left.Val, _ = strconv.Atoi(list[index])
			queue = append(queue, node.Left)
		}
		index++
		if list[index] != "null" {
			node.Right = &TreeNode{}
			node.Right.Val, _ = strconv.Atoi(list[index])
			queue = append(queue, node.Right)
		}
		index++
	}
	return root
}
