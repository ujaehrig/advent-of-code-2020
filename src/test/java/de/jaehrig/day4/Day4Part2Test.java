package de.jaehrig.day4;

import static org.assertj.core.api.Assertions.assertThat;

import de.jaehrig.Tools;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class Day4Part2Test {

    private Day4Part2 classUnderTest = new Day4Part2();

    @Test
    void testExampleInput() {
        // given
        try(Stream<String> input = Tools.getResourceAsStream("/day4part2.txt")) {

            // when
            Long solution = classUnderTest.solve(input);

            // then
            assertThat(solution).isEqualTo(4);
        }
    }
}
