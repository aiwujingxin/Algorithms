package classic

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/18 15:15
 */

type LRUCache struct {
	mp       map[int]*CacheNode
	capacity int
	q        *CacheNodeList
}

func ConstructorLRUCache(capacity int) LRUCache {
	return LRUCache{
		mp:       make(map[int]*CacheNode),
		capacity: capacity,
		q:        &CacheNodeList{},
	}
}

type CacheNode struct {
	key   int
	value int
	next  *CacheNode
	pre   *CacheNode
}

type CacheNodeList struct {
	head *CacheNode
	last *CacheNode
}

func (c *CacheNodeList) remove(node *CacheNode) {
	if c.head == node {
		c.head = node.next
		node = nil
	} else if c.last == node {
		c.last = node.pre
		c.last.next = nil
	} else {
		node.pre.next = node.next
		node.next.pre = node.pre
		node = nil
	}
}

func (c *CacheNodeList) addFirst(node *CacheNode) {
	if c.head == nil {
		c.head = node
		c.last = node
	} else {
		node.next = c.head
		c.head.pre = node
		c.head = node
	}
}

func (c *CacheNodeList) removeLast() *CacheNode {
	if c.last == nil {
		return nil
	}
	node := c.last
	c.last = c.last.pre
	if c.last != nil {
		c.last.next = nil
	}
	return node
}

func (this *LRUCache) Get(key int) int {
	if node, ok := this.mp[key]; !ok {
		return -1
	} else {
		// remove TrieNode
		this.q.remove(node)

		// add first
		this.q.addFirst(node)
		return node.value
	}
}

func (this *LRUCache) Put(key int, value int) {
	// 存在的情况
	if node, ok := this.mp[key]; ok {
		node.value = value
		//更新q
		// remove TrieNode
		this.q.remove(node)

		// add first
		this.q.addFirst(node)
		return
	}
	if len(this.mp) == this.capacity {
		//remove last
		node := this.q.removeLast()
		//remove map key
		delete(this.mp, node.key)
	}
	node := &CacheNode{
		key:   key,
		value: value,
	}
	this.mp[key] = node
	// add first
	this.q.addFirst(node)
}
