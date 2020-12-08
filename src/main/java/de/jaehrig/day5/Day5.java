package de.jaehrig.day5;

import de.jaehrig.common.Puzzle;
import java.util.stream.Stream;

public class Day5 implements Puzzle<Long> {

    @Override
    public Long solve(final Stream<String> input) {
        return input
                .mapToLong(this::getSeatNumber)
                .max()
                .orElseThrow();
    }

    public Integer getSeatNumber(String s) {
        String x= s
                .replace('F', '0')
                .replace('B', '1')
                .replace('L', '0')
                .replace('R', '1');
        return Integer.parseInt(x, 2);
    }
}
