package classic

import "strings"

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/18 15:31
 */

func printKMoves(K int) []string {
	bord := &Bord{
		ant: Ant{
			position:    Position{},
			orientation: "R",
		},
		blackCells:        make(map[Position]bool),
		topLeftCorner:     Position{},
		bottomRightCorner: Position{},
	}
	for i := 0; i < K; i++ {
		bord.move()
	}
	return bord.string()
}

var orientationMp = map[string]map[string]string{
	"R": {
		"X": "U",
		"_": "D",
	},
	"L": {
		"X": "D",
		"_": "U",
	},
	"U": {
		"X": "L",
		"_": "R",
	},
	"D": {
		"X": "R",
		"_": "L",
	},
}

type Position struct {
	row int
	col int
}
type Ant struct {
	position    Position
	orientation string
}

func (a *Ant) move() {
	if a.orientation == "L" {
		a.position.col--
	} else if a.orientation == "R" {
		a.position.col++
	} else if a.orientation == "U" {
		a.position.row--
	} else if a.orientation == "D" {
		a.position.row++
	}
}

func (a *Ant) turn(colour string) {
	a.orientation = orientationMp[a.orientation][colour]
}

type Bord struct {
	ant               Ant
	blackCells        map[Position]bool
	topLeftCorner     Position
	bottomRightCorner Position
}

func (b *Bord) move() {
	b.ant.turn(b.colour(b.ant.position)) // Turn clockwise on white, counter on black
	b.flip(b.ant.position)               // flip
	b.ant.move()                         // move
	b.ensureFit(b.ant.position)
}

func (b *Bord) flip(position Position) {
	if _, ok := b.blackCells[position]; ok {
		delete(b.blackCells, position)
	} else {
		b.blackCells[Position{
			row: position.row,
			col: position.col,
		}] = true
	}
}

func (b *Bord) colour(position Position) string {
	if _, ok := b.blackCells[position]; ok {
		return "X"
	}
	return "_"
}

func (b *Bord) ensureFit(position Position) {
	b.topLeftCorner.row = Min(b.topLeftCorner.row, position.row)
	b.topLeftCorner.col = Min(b.topLeftCorner.col, position.col)
	b.bottomRightCorner.row = Max(b.bottomRightCorner.row, position.row)
	b.bottomRightCorner.col = Max(b.bottomRightCorner.col, position.col)
}

func (b *Bord) string() []string {
	rowMin := b.topLeftCorner.row
	rowMax := b.bottomRightCorner.row
	colMin := b.topLeftCorner.col
	colMax := b.bottomRightCorner.col
	var strs []string
	for r := rowMin; r <= rowMax; r++ {
		sb := strings.Builder{}

		for c := colMin; c <= colMax; c++ {
			if r == b.ant.position.row && c == b.ant.position.col {
				sb.WriteString(b.ant.orientation)
			} else {
				sb.WriteString(b.colour(Position{
					row: r,
					col: c,
				}))
			}
		}
		strs = append(strs, sb.String())
	}
	return strs
}
