package de.jaehrig.day4;

import static org.assertj.core.api.Assertions.assertThat;

import de.jaehrig.Tools;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class Day4Test {

    private Day4 classUnderTest = new Day4();

    @Test
    void testExampleInput() {
        // given
        try(Stream<String> input = Tools.getResource("/day4.txt")) {

            // when
            Long solution = classUnderTest.solve(input);

            // then
            assertThat(solution).isEqualTo(2);
        }
    }
}
