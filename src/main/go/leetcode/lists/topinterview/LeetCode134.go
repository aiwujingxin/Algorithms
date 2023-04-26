package topinterview

func canCompleteCircuit(gas []int, cost []int) int {
	tank, storage, start := 0, 0, 0
	for i := 0; i < len(gas); i++ {
		tank += gas[i] - cost[i]
		if tank < 0 {
			start = i + 1
			tank = 0
		}
		storage += gas[i] - cost[i]
	}
	if storage >= 0 {
		return start
	}
	return -1
}
