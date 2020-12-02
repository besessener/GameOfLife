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
}
