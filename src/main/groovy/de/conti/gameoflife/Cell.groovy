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
	int alive
	private numberOfNeighbors = 8

	Cell(alive) {
		this.alive = alive ? 1 : 0
	}

	boolean isAliveNextRound() {
		int aliveNeighbors = 0
		for (int i = 1; i <= numberOfNeighbors; i++) {
			aliveNeighbors += this."c$i"?.alive ?: 0
		}

		(aliveNeighbors == 2 && alive) || aliveNeighbors == 3
	}

	void addNeighbor(Cell c) {
		for (int i = 1; i <= numberOfNeighbors; i++) {
			if (!this."c$i") {
				this."c$i" = c
				break
			}
		}
	}
}

