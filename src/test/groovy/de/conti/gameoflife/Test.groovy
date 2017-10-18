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

}
