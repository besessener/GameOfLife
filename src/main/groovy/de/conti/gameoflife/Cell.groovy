package de.conti.gameoflife

class Cell {
	Cell c1, c2, c3, c4, c5, c6, c7, c8
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

