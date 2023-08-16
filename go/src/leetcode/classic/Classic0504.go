package classic

/**
 * @Author: jingxinwu
 * @Date: 2023/2/22 09:06
 */

func findClosedNumbers(num int) []int {
	return []int{getNextSlow(num), getPrevSlow(num)}
}

func getNextSlow(i int) int {
	if !hasValidNext(i) {
		return -1
	}
	numOnes := countOnes(i)
	i++
	for countOnes(i) != numOnes {
		i++
	}
	return i
}

func getPrevSlow(i int) int {
	if !hasValidPrev(i) {
		return -1
	}
	numOnes := countOnes(i)
	i--
	for countOnes(i) != numOnes {
		i--
	}
	return i
}

func countOnes(i int) int {
	count := 0
	for i > 0 {
		if (i & 1) == 1 {
			count++
		}
		i = i >> 1
	}
	return count
}

func hasValidNext(i int) bool {
	if i == 0 {
		return false
	}
	count := 0
	for (i & 1) == 0 {
		i >>= 1
		count++
	}
	for (i & 1) == 1 {
		i >>= 1
		count++
	}
	if count == 31 {
		return false
	}
	return true
}

func hasValidPrev(i int) bool {
	for (i & 1) == 1 {
		i >>= 1
	}
	if i == 0 {
		return false
	}
	return true
}
