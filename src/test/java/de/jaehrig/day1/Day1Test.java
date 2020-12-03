package de.jaehrig.day1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class Day1Test {

    private Day1 classUnderTest = new Day1();

    @Test
    void testExampleInput() {
        // given
        Stream<String> input = Stream.of("1721", "979", "366", "299", "675", "1456");

        // when
        Integer solution = classUnderTest.solve(input);

        // then
        assertThat(solution).isEqualTo(514579);
    }
}
