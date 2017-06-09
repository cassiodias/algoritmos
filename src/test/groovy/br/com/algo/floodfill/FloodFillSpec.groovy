package br.com.algo.floodfill

import spock.lang.Specification

class FloodFillSpec extends Specification {

    def "must failed when has invalid surface"() {
        when:
        new FloodFill(null)
        then:
        thrown(IllegalArgumentException)
    }

    def "must flood one line to the right"() {
        given:
        int[][] surface = [
                [1, 0, 0, 0],
                [1, 1, 1, 1]
        ] as int[][]
        int[][] expectedFloodedSurface = [
                [1, 1, 1, 1],
                [1, 1, 1, 1]
        ] as int[][]

        when:
        new FloodFill(surface).start(0, 1, new Position(0, 1))

        then:
        surface == expectedFloodedSurface
    }

    def "must flood one line to the left"() {
        given:
        def startingAt = new Position(0, 3)
        int[][] surface = [
                [1, 0, 0, 0],
                [1, 1, 1, 1]
        ] as int[][]

        int[][] expectedFloodedSurface = [
                [1, 1, 1, 1],
                [1, 1, 1, 1]
        ] as int[][]

        when:
        new FloodFill(surface).start(0, 1, startingAt)

        then:
        surface == expectedFloodedSurface
    }

    def "must flood down starting from the top"() {
        given:
        def startingAt = new Position(0, 2)
        int[][] surface = [
                [1, 1, 0, 1],
                [1, 1, 0, 1],
                [1, 1, 0, 1]
        ] as int[][]

        int[][] expectedFloodedSurface = [
                [1, 1, 1, 1],
                [1, 1, 1, 1],
                [1, 1, 1, 1]
        ] as int[][]

        when:
        new FloodFill(surface).start(0, 1, startingAt)

        then:
        surface == expectedFloodedSurface
    }

    def "must flood down and left starting from the top"() {
        given:
        def startingAt = new Position(0, 2)
        int[][] surface = [
                [1, 1, 0, 1],
                [1, 1, 0, 1],
                [0, 0, 0, 1]
        ] as int[][]

        int[][] expectedFloodedSurface = [
                [1, 1, 1, 1],
                [1, 1, 1, 1],
                [1, 1, 1, 1]
        ] as int[][]

        when:
        new FloodFill(surface).start(0, 1, startingAt)

        then:
        surface == expectedFloodedSurface
    }

    def "must flood down and right starting from the top"() {
        given:
        def startingAt = new Position(0, 1)
        int[][] surface = [
                [1, 0, 1, 1],
                [1, 0, 1, 1],
                [1, 0, 0, 0]
        ] as int[][]

        int[][] expectedFloodedSurface = [
                [1, 1, 1, 1],
                [1, 1, 1, 1],
                [1, 1, 1, 1]
        ] as int[][]

        when:
        new FloodFill(surface).start(0, 1, startingAt)

        then:
        surface == expectedFloodedSurface
    }

    def "must flood all coming from the bottom"() {
        given:
        def startingAt = new Position(2, 3)
        int[][] surface = [
                [0, 0, 0, 0],
                [0, 0, 0, 0],
                [0, 0, 0, 0]
        ] as int[][]

        int[][] expectedFloodedSurface = [
                [1, 1, 1, 1],
                [1, 1, 1, 1],
                [1, 1, 1, 1]
        ] as int[][]

        when:
        new FloodFill(surface).start(0, 1, startingAt)

        then:
        surface == expectedFloodedSurface
    }

    def "must not flood because the starting point has already the new value"() {
        given:
        def startingAt = new Position(2, 3)
        int[][] surface = [
                [0, 0, 0, 0],
                [0, 0, 0, 0],
                [0, 0, 0, 1]
        ] as int[][]

        int[][] expectedFloodedSurface = [
                [0, 0, 0, 0],
                [0, 0, 0, 0],
                [0, 0, 0, 1]
        ] as int[][]

        when:
        new FloodFill(surface).start(0, 1, startingAt)

        then:
        surface == expectedFloodedSurface
    }

}
