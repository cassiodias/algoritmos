package br.com.algo.factorial

import spock.lang.Specification

class FactorialTest extends Specification {

    def "should return 2 as factorial of 2"() {
        expect:
        2 == new Factorial().of(2)
    }

    def "should return 24 as factorial of 4"() {
        expect:
        24 == new Factorial().of(4)
    }

    def "should return 1 as factorial of 1"() {
        expect:
        1 == new Factorial().of(1)
    }

    def "should return 1 as factorial of 0"() {
        expect:
        1 == new Factorial().of(0)
    }

    def "should throw exception and input is negative"() {
        when:
        new Factorial().of(-1)

        then:
        thrown(IllegalArgumentException)
    }
}
