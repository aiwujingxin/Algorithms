package classic

/**
 * @Author: jingxinwu
 * @Date: 2023/2/21 22:04
 */
func masterMind(solution string, guess string) []int {
	total, hit := 0, 0
	intMap := make([]int, 26)
	for i := 0; i < 4; i++ {
		intMap[guess[i]-'A']++
	}

	for i := 0; i < 4; i++ {
		if solution[i] == guess[i] {
			hit++
		}
		if intMap[solution[i]-'A'] > 0 {
			total++
			intMap[solution[i]-'A']--
		}
	}
	return []int{hit, total - hit}
}
