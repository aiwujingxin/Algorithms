package classic

import (
	"math"
	"sort"
)

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/22 18:02
 */

func maxAliveYear(birth []int, death []int) int {

	sort.Slice(birth, func(i, j int) bool {
		return birth[i] < birth[j]
	})
	sort.Slice(death, func(i, j int) bool {
		return death[i] < death[j]
	})

	birthIndex := 0
	deathIndex := 0
	currentlyAlive := 0
	maxAlive := 0
	maxAliveYear := math.MinInt

	/* Walk through arrays. */
	for birthIndex < len(birth) {
		if birth[birthIndex] <= death[deathIndex] {
			currentlyAlive++ // include birth
			if currentlyAlive > maxAlive {
				maxAlive = currentlyAlive
				maxAliveYear = birth[birthIndex]
			}
			birthIndex++ // move birth index
		} else {
			currentlyAlive-- // include death
			deathIndex++     // move death index
		}
	}
	return maxAliveYear
}
