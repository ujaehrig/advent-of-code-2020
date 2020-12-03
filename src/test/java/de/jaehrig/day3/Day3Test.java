package de.jaehrig.day3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class Day3Test {

    private Day3 classUnderTest = new Day3();

    @Test
    void testExampleInput() {
        // given
        Stream<String> input = Stream.of(
                "..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#");

        // when
        String solution = classUnderTest.solve(input);

        // then
        assertThat(solution).isEqualTo("7");
    }
}
