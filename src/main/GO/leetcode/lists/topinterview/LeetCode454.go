package topinterview

func fourSumCount(a, b, c, d []int) int {
	countAB := map[int]int{}
	for _, v := range a {
		for _, w := range b {
			countAB[v+w]++
		}
	}
	ans := 0
	for _, v := range c {
		for _, w := range d {
			ans += countAB[-v-w]
		}
	}
	return ans
}
