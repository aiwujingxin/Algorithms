package topinterview

func generate(numRows int) [][]int {

	if numRows == 0 {
		return [][]int{}
	}
	list := make([][]int, 0)
	list = append(list, []int{1})
	for i := 1; i < numRows; i++ {
		last := list[i-1]
		level := make([]int, 0)
		level = append(level, 1)
		for i := 0; i < len(last)-1; i++ {
			level = append(level, last[i]+last[i+1])
		}
		level = append(level, 1)
		list = append(list, level)
	}
	return list
}
