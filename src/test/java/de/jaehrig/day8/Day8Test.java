package de.jaehrig.day8;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class Day8Test {

    private Day8 classUnderTest = new Day8();

    @Test
    void testExampleInput() {
        // given
        Stream<String> input = Stream.of(
                "nop +0",
                "acc +1",
                "jmp +4",
                "acc +3",
                "jmp -3",
                "acc -99",
                "acc +1",
                "jmp -4",
                "acc +6"
        );

        // when
        Number solution = classUnderTest.solve(input);

        // then
        assertThat(solution).isEqualTo(5);
    }
}
