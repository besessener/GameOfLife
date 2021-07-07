package de.conti.gameoflife

import spock.lang.Specification

class Test extends Specification {

   def "Can create games but don't really care for it"() {
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

   def "a Cell can be alive or dead; default is dead"() {
      expect:
          false
   }

   def "if a cell has no living neighbors, the shall is dead in next round regardless of its own status"() {
      expect:
          false
   }

   def "Rule 1 Any live cell with fewer than two live neighbours dies, as if caused by underpopulation"() {
      expect:
          false
   }

   def "Rule 2 Any live cell with two or three live neighbours lives on to the next generation."(){
      expect:
          false
   }

   def "Rule 3 Any live cell with more than three live neighbours dies, as if by overpopulation."() {
      expect:
          false
   }

   def "Rule 4 Any dead cell with exactly three live neighbours becomes a live cell, as if by"() {
      expect:
          false
   }
}
