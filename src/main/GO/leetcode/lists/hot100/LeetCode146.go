package hot100

// LRUCache https://leetcode.com/problems/lru-cache/solutions/448713/golang-solution-using-hashmap-and-double-linked-list/
type LRUCache struct {
	capacity int
	cache    map[int]*CacheNode
	Head     *CacheNode
	Tail     *CacheNode
}
type CacheNode struct {
	prev  *CacheNode
	next  *CacheNode
	key   int
	value int
}

// Least recently used is always added next to Head node.
func (this *LRUCache) addNode(node *CacheNode) {
	node.prev = this.Head
	node.next = this.Head.next
	this.Head.next.prev = node
	this.Head.next = node
}

// Remove the node from the DLL
func (this *LRUCache) removeNode(node *CacheNode) {
	node.prev.next = node.next
	node.next.prev = node.prev
	node.next = nil
	node.prev = nil
}

// Last accessed is moved to the front of the queue as MRU
func (this *LRUCache) addToFront(node *CacheNode) {
	this.removeNode(node)
	this.addNode(node)
}

func Constructor(capacity int) LRUCache {
	obj := LRUCache{
		capacity: capacity,
		cache:    make(map[int]*CacheNode),
	}
	obj.Head = &CacheNode{}
	obj.Tail = &CacheNode{}
	obj.Head.next = obj.Tail
	obj.Tail.prev = obj.Head
	return obj
}

func (this *LRUCache) Get(key int) int {
	if node, ok := this.cache[key]; ok {
		this.addToFront(node)
		return node.value
	}
	return -1
}

func (this *LRUCache) Put(key int, value int) {
	if node, ok := this.cache[key]; ok {
		node.value = value
		this.addToFront(node)
	} else {
		node := &CacheNode{
			key:   key,
			value: value,
		}
		if len(this.cache) < this.capacity {
			this.cache[key] = node
			//add lists
			this.addNode(node)
		} else {
			//add
			this.cache[key] = node
			//remove

			delete(this.cache, this.Tail.prev.key)

			this.removeNode(this.Tail.prev)
			//add lists
			this.addNode(node)
		}
	}
}
