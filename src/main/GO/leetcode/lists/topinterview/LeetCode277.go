package topinterview

func solution(knows func(a int, b int) bool) func(n int) int {
	return func(n int) int {
		celebrity := 0
		for i := 1; i < n; i++ {
			if knows(celebrity, i) {
				celebrity = i
			}
		}
		for i := 0; i < n; i++ {
			if i == celebrity {
				continue
			}
			if knows(celebrity, i) || !knows(i, celebrity) {
				return -1
			}
		}
		return celebrity
	}
}
