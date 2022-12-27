package topinterview

func titleToNumber(columnTitle string) int {
	if len(columnTitle) == 0 {
		return 0
	}
	number := 0
	for i, multiple := len(columnTitle)-1, 1; i >= 0; i-- {
		k := columnTitle[i] - 'A' + 1
		number += int(k) * multiple
		multiple *= 26
	}
	return number
}
