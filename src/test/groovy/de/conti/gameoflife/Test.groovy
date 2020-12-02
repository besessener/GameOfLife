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

   def "Rule 1 Any live cell with fewer than two live neighbours dies, as if caused by underpopulation."() {
      given:
      Cell cell = new Cell()


      when:
      def isAlive = cell.isAliveNextRound()

      then:
      !isAlive
   }
   def "Rule 1 with 2 neighbours."(){
      given:
      Cell CellWithNeighbours = new Cell()
      CellWithNeighbours.n1 = new Cell();
      CellWithNeighbours.n2 = new Cell();

      CellWithNeighbours.n1.alive = true
      CellWithNeighbours.n2.alive = true

      when:
      def isAlive = CellWithNeighbours.isAliveNextRound()
      then:
      isAlive

   }
}
