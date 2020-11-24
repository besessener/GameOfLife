package de.conti.gameoflife

import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics

class GameOfLife extends JPanel{
	static Cell[][] board
	static def boardSize = 200

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

		JFrame frame = new JFrame("GoL");
		JPanel panel = new GameOfLife()
		frame.add(panel, BorderLayout.CENTER);

		frame.setSize(boardSize + 10, boardSize + 38)
		frame.setPreferredSize(new Dimension(boardSize - 10, boardSize + 38))
		frame.pack()
		frame.setVisible(true)
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		while (true) {
			panel.repaint()
		}
	}

	@Override
	void paintComponent(Graphics g) {
		super.paintComponent (g)

		def nextIteration = [:]

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
						g.setColor(Color.BLACK)
					} else {
						g.setColor(Color.WHITE)
					}

					g.fillRect(x, y, 1, 1)
				}
			}
	}
}
