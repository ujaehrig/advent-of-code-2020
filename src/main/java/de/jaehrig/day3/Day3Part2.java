package de.jaehrig.day3;

import de.jaehrig.common.Puzzle;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day3Part2 implements Puzzle<Long> {

    @Override
    public Long solve(final Stream<String> input) {
        List<String> map = input.collect(Collectors.toList());

        return new Day3(1, 1).solve(map.stream())
                * new Day3(3, 1).solve(map.stream())
                * new Day3(5, 1).solve(map.stream())
                * new Day3(7, 1).solve(map.stream())
                * new Day3(1, 2).solve(map.stream());
    }
}
