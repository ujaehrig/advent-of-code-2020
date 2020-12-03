package de.jaehrig.day1;

import de.jaehrig.common.Pair;
import de.jaehrig.common.Puzzle;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1 implements Puzzle<String> {

    @Override
    public String solve(final Stream<String> input) {
        Set<Integer> ints = input.map(Integer::parseInt).collect(Collectors.toSet());
        Pair<Integer> pair = findPair(ints, 2020).orElseThrow();
        return String.valueOf(pair.first * pair.second);
    }

    protected Optional<Pair<Integer>> findPair(Set<Integer> set, int expectedSum) {
        for(int v : set) {
            int diff = expectedSum - v;
            if (set.contains(diff)) {
                return Optional.of(new Pair<>(v, diff));
            }
        }
        return Optional.empty();
    }
}
