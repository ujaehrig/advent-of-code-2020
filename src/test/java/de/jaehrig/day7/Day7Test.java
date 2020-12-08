package de.jaehrig.day7;

import static org.assertj.core.api.Assertions.assertThat;

import de.jaehrig.Tools;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class Day7Test {

    private Day7 classUnderTest = new Day7();

    @Test
    void testExampleInput() {
        // given
        Stream<String> input  = Tools.getResourceAsStream("/day7.txt");

        // when
        Number solution = classUnderTest.solve(input);

        // then
        assertThat(solution).isEqualTo(4);
    }
}
