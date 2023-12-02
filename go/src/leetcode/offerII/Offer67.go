package offerII

import (
	"math"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/19 16:23
 */

func findMaximumXOR(nums []int) int {
	type TrieNode struct {
		children [2]*TrieNode
	}
	if len(nums) == 0 {
		return 0
	}
	root := &TrieNode{
		children: [2]*TrieNode{},
	}
	for i := 0; i < len(nums); i++ {
		node := root
		num := nums[i]
		for bit := 31; bit >= 0; bit-- {
			curr := (num >> bit) & 1
			if node.children[curr] == nil {
				node.children[curr] = &TrieNode{
					children: [2]*TrieNode{},
				}
			}
			node = node.children[curr]
		}
	}
	res := math.MinInt32
	for i := 0; i < len(nums); i++ {
		node := root
		sum := 0
		num := nums[i]
		for index := 31; index >= 0; index-- {
			curr := (num >> index) & 1
			if curr == 0 {
				if node.children[1] != nil {
					sum += 1 << index
					node = node.children[1]
				} else {
					node = node.children[0]
				}
			} else {
				if node.children[0] != nil {
					sum += 1 << index
					node = node.children[0]
				} else {
					node = node.children[1]
				}
			}
		}
		res = Max(res, sum)
	}
	return res
}
