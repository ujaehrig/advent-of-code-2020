package de.jaehrig.day2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class Day2Test {

    private Day2 classUnderTest = new Day2();

    @Test
    void testExampleInput() {
        // given
        Stream<String> input = Stream.of(
                "1-3 a: abcde",
                "1-3 b: cdefg",
                "2-9 c: ccccccccc"
        );

        // when
        Long solution = classUnderTest.solve(input);

        // then
        assertThat(solution).isEqualTo(2L);
    }

}
