package de.jaehrig.day6;

import static org.assertj.core.api.Assertions.assertThat;

import de.jaehrig.Tools;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class Day6Test {

    private Day6 classUnderTest = new Day6();

    @Test
    void testExampleInput() {
        List<String> rules = Tools.getResourceAsList("/day7.txt");

        // given
        Stream<String> input = Stream.of();

        // when
        Number solution = classUnderTest.solve(input);

        // then
        assertThat(solution).isEqualTo("");
    }
}
