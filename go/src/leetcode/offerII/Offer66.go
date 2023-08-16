package offerII

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/19 14:07
 */

type MapSum struct {
	children map[int]*MapSum
	value    int
	isEnd    bool
}

/** Initialize your data structure here. */
func ConstructorMapSum() MapSum {
	return MapSum{
		children: make(map[int]*MapSum),
		isEnd:    false,
	}
}

func (this *MapSum) Insert(key string, val int) {
	root := this
	for i := 0; i < len(key); i++ {
		if root.children[int(key[i]-'a')] == nil {
			root.children[int(key[i]-'a')] = &MapSum{
				children: make(map[int]*MapSum),
			}
		}
		root = root.children[int(key[i]-'a')]
	}
	root.value = val
	root.isEnd = true
}

func (this *MapSum) StartWith(key string) bool {
	root := this
	for i := 0; i < len(key); i++ {
		if root.children[int(key[i]-'a')] == nil {
			return false
		}
		root = root.children[int(key[i]-'a')]
	}
	return true
}

func (this *MapSum) Sum(prefix string) int {
	root := this
	if !root.StartWith(prefix) {
		return 0
	}
	for i := 0; i < len(prefix); i++ {
		root = root.children[int(prefix[i]-'a')]
	}
	res := 0
	var dfs func(node *MapSum)

	dfs = func(node *MapSum) {
		if node == nil {
			return
		}
		res += node.value
		for _, ch := range node.children {
			dfs(ch)
		}
	}
	dfs(root)
	return res
}
