package de.jaehrig.day1;

import de.jaehrig.common.Puzzle;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1Part2 implements Puzzle<Long> {

    @Override
    public Long solve(final Stream<String> input) {
        List<Long> ints = input.map(Long::parseLong).collect(Collectors.toList());

        int size = ints.size();
        for (int i1 = 0; i1 < size; ++i1) {
            for (int i2 = 0; i2 < size; ++i2) {
                for (int i3 = 0; i3 < size; ++i3) {
                    if (i1 == i2 || i2 == i3 ) {
                        continue;
                    }

                    long v1 = ints.get(i1);
                    long v2 = ints.get(i2);
                    long v3 = ints.get(i3);
                    if (v1 + v2 + v3 == 2020) {
                        return v1 * v2 * v3;
                    }
                }
            }
        }
        return null;
    }
}
