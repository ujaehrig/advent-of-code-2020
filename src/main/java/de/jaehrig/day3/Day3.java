package de.jaehrig.day3;

import de.jaehrig.common.Puzzle;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day3 implements Puzzle<Long> {

    private final int right;
    private final int down;

    public Day3() {
                this(3, 1);
    }

    public Day3(int right, int down) {
        this.right = right;
        this.down = down;
    }

    @Override
    public Long solve(final Stream<String> input) {
        List<String> map = input.collect(Collectors.toList());
        int width = map.get(0).length();

        long treesHit = 0;
        for(int x = 0, y = 0; y < map.size(); x = (x + right) % width, y += down) {
            if (map.get(y).charAt(x) == '#') {
                treesHit++;
            }
        }

        return treesHit;
    }
}
