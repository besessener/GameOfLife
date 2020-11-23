package de.conti.gameoflife

import spock.lang.Specification

class Test extends Specification {

	def "Can create games"() {
		given:
			GameOfLife game
		when:
			game = new GameOfLife()
		then:
			game != null

		when:
			game = null
		then:
			game == null
	}

	def "Rule 1: Any live cell with fewer than two live neighbours dies, as if caused by underpopulation."() {
		given:
			Cell cell = new Cell(true)

		expect:
			!cell.isAliveNextRound()

		when:
			cell.addNeighbor(new Cell(true))
			cell.addNeighbor(new Cell(false))

		then:
			!cell.isAliveNextRound()
	}

	def "Rule 2: Any live cell with two or three live neighbours lives on to the next generation."() {
		given:
			Cell cell = new Cell(true)

		when:
			cell.addNeighbor(new Cell(true))
			cell.addNeighbor(new Cell(true))

		then:
			cell.isAliveNextRound()

		when:
			cell.addNeighbor(new Cell(true))

		then:
			cell.isAliveNextRound()

		when:
			cell.addNeighbor(new Cell(false))

		then:
			cell.isAliveNextRound()
	}

	def "Rule 3: Any live cell with more than three live neighbours dies, as if by overpopulation."() {
		given:
			Cell cell = new Cell(true)
			cell.addNeighbor(new Cell(true))
			cell.addNeighbor(new Cell(true))
			cell.addNeighbor(new Cell(true))
			cell.addNeighbor(new Cell(true))

		expect:
			!cell.isAliveNextRound()

		when:
			cell.addNeighbor(new Cell(true))

		then:
			!cell.isAliveNextRound()
	}

	def "Rule 4: Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction."() {
		given:
			Cell cell = new Cell(false)

		expect:
			!cell.isAliveNextRound()

		when:
			cell.addNeighbor(new Cell(true))
			cell.addNeighbor(new Cell(true))
			cell.addNeighbor(new Cell(false))

		then:
			!cell.isAliveNextRound()

		when:
			cell.addNeighbor(new Cell(true))

		then:
			cell.isAliveNextRound()
	}
}
