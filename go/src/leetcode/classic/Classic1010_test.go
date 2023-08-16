package classic

import (
	"fmt"
	"testing"
)

/**
 * @Author: jingxinwu
 * @Date: 2023/2/25 15:54
 */

func TestStreamRank(t *testing.T) {
	rank := ConstructorStreamRank()
	rank.Track(4)
	rank.Track(3)
	rank.Track(5)
	rank.Track(3)
	rank.Track(1)
	rank.Track(5)
	rank.Track(1)
	fmt.Print(rank.GetRankOfNumber(9))
}
