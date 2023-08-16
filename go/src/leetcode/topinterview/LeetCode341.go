package topinterview

type NestedIterator struct {
	vals []int
}

type NestedInteger struct {
}

func (this NestedInteger) IsInteger() bool {
	return false
}
func (this NestedInteger) GetInteger() int {
	return -1
}
func (this NestedInteger) GetList() []*NestedInteger {
	return nil
}

func ConstructorNestedInteger(nestedList []*NestedInteger) *NestedIterator {
	var vals []int
	var dfs func([]*NestedInteger)
	dfs = func(nestedList []*NestedInteger) {
		for _, nest := range nestedList {
			if nest.IsInteger() {
				vals = append(vals, nest.GetInteger())
			} else {
				dfs(nest.GetList())
			}
		}
	}
	dfs(nestedList)
	return &NestedIterator{vals}
}

func (this *NestedIterator) Next() int {
	val := this.vals[0]
	this.vals = this.vals[1:]
	return val
}

func (this *NestedIterator) HasNext() bool {
	return len(this.vals) > 0
}
