package de.jaehrig.day1;

import de.jaehrig.common.Puzzle;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1Part2 extends Day1 implements Puzzle<String> {

    @Override
    public String solve(final Stream<String> input) {
        Set<Integer> ints = input.map(Integer::parseInt).collect(Collectors.toSet());



        for(int v : ints) {
            
            int diff = 2020 - v;
            if (ints.contains(diff)) {
                return String.valueOf(v * diff);
            }
        }
        return null;
    }



}
