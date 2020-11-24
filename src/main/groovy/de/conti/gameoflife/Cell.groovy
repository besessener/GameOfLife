package de.conti.gameoflife

class Cell {
	Cell c1
	Cell c2
	Cell c3
	Cell c4
	Cell c5
	Cell c6
	Cell c7
	Cell c8
	boolean alive
	private numberOfNeighbors = 0

	Cell(alive) {
		this.alive = alive
	}

	boolean isAliveNextRound() {
		int aliveNeighbors = 0
		for (int i = 1; i <= numberOfNeighbors; i++) {
			aliveNeighbors += this."c$i"?.alive ? 1 : 0
		}

		(aliveNeighbors == 2 && alive) || aliveNeighbors == 3
	}

	void addNeighbor(Cell c) {
		this."c${++numberOfNeighbors}" = c
	}
}

