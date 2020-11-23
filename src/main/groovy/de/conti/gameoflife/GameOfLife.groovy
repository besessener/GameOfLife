package de.conti.gameoflife

import javax.swing.JFrame
import javax.swing.WindowConstants
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics

class GameOfLife extends JFrame{
	static Cell[][] board
	static def boardSize = 100

	static void main(String[] args) {
		// initialize
		board = new Cell[boardSize][boardSize]
		for (int y = 0; y < boardSize; y++) {
			for (int x = 0; x < boardSize; x++) {
				board[y][x] = new Cell(new Random().nextBoolean())
			}
		}

		// add neighborhood
		for (int y = 0; y < boardSize; y++) {
			for (int x = 0; x < boardSize; x++) {
				if (y > 0) {
					board[y][x].addNeighbor(board[y - 1][x])

					if (x > 0) {
						board[y][x].addNeighbor(board[y - 1][x - 1])
					}

					if (x < boardSize - 1) {
						board[y][x].addNeighbor(board[y - 1][x + 1])
					}
				}

				if (y < boardSize - 1) {
					board[y][x].addNeighbor(board[y + 1][x])

					if (x > 0) {
						board[y][x].addNeighbor(board[y + 1][x - 1])
					}

					if (x < boardSize - 1) {
						board[y][x].addNeighbor(board[y + 1][x + 1])
					}
				}

				if (x > 0) {
					board[y][x].addNeighbor(board[y][x - 1])
				}

				if (x < boardSize - 1) {
					board[y][x].addNeighbor(board[y][x + 1])
				}
			}
		}

		GameOfLife frame = new GameOfLife()
		frame.setSize(boardSize + 10, boardSize + 45)
		frame.setPreferredSize(new Dimension(boardSize - 10, boardSize + 45))
		frame.setVisible(true)
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

	@Override
	void paint(Graphics g) {
		super.paint(g);

		def nextIteration = [:]
		while (true) {
			for (int y = 0; y < boardSize; y++) {
				for (int x = 0; x < boardSize; x++) {
					def cell = board[y][x]
					nextIteration[cell] = cell.isAliveNextRound()
				}
			}

			for (int y = 0; y < boardSize; y++) {
				for (int x = 0; x < boardSize; x++) {
					def cell = board[y][x]
					cell.alive = nextIteration[cell] ? 1 : 0

					if (nextIteration[cell]) {
						g.setColor(Color.BLACK);
					} else {
						g.setColor(Color.WHITE);
					}

					g.fillRect(x + 10, y + 35, 1, 1);
				}
			}
		}
	}
}
