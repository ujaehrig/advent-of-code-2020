package de.jaehrig.day5;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day5Test {

    private Day5 classUnderTest = new Day5();

    @Test
    void testExampleInput() {
        // given
        Stream<String> input = Stream.of();

        // when
        Number solution = classUnderTest.solve(input);

        // then
        assertThat(solution).isEqualTo("");
    }

    @ParameterizedTest
    @MethodSource
    void testSeatCalculation(String code, Integer expected) {

        Integer seatNumber = classUnderTest.getSeatNumber(code);

        assertThat(seatNumber).isEqualTo(expected);
    }


    static Stream<Arguments> testSeatCalculation() {
        return Stream.of(
                Arguments.of("FBFBBFFRLR", 357),
                Arguments.of("BFFFBBFRRR", 567),
                Arguments.of("FFFBBBFRRR", 119),
                Arguments.of("BBFFBBFRLL", 820)
        );
    }

}
