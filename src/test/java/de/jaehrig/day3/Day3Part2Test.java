package de.jaehrig.day3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class Day3Part2Test {
    private Day3Part2 classUnderTest = new Day3Part2();

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
        long solution = classUnderTest.solve(input);

        // then
        assertThat(solution).isEqualTo(336L);
    }

}
