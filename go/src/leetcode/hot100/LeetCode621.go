package hot100

func leastInterval(tasks []byte, n int) int {

	if len(tasks) == 0 {
		return 0
	}
	dict := [26]int{}
	for _, ch := range tasks {
		dict[ch-'A']++
	}

	maxCount, maxCountSame := 0, 0
	for _, num := range dict {
		if num > maxCount {
			maxCount = num
			maxCountSame = 1
		} else if num == maxCount {
			maxCountSame++
		}
	}
	return Max((maxCount-1)*(n+1)+maxCountSame, len(tasks))
}
