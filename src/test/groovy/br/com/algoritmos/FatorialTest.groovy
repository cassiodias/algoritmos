package br.com.algoritmos

import spock.lang.Specification

class FatorialTest extends Specification {

    def "should return 2 as factorial of 2"() {
        expect:
        2 == new Fatorial().of(2)
    }

    def "should return 24 as factorial of 4"() {
        expect:
        24 == new Fatorial().of(4)
    }

    def "should return 1 as factorial of 1"() {
        expect:
        1 == new Fatorial().of(1)
    }

    def "should return 1 as factorial of 0"() {
        expect:
        1 == new Fatorial().of(0)
    }

    def "should throw exception and input is negative"() {
        when:
        new Fatorial().of(-1)

        then:
        thrown(IllegalArgumentException)
    }
}
