package de.jaehrig.day5;

import java.util.BitSet;
import java.util.stream.Stream;

public class Day5Part2 extends Day5 {

    private BitSet reservedSeats = new BitSet(10);

    @Override
    public Long solve(final Stream<String> input) {
        input.mapToInt(this::getSeatNumber).forEach(reservedSeats::set);

        int found = 0;
        for (int i = 8; i < 1024; ++i) {
            if (!reservedSeats.get(i) && reservedSeats.get(i-1) && reservedSeats.get(i+1)) {
                found = i;
                break;
            }
        }
        return (long)found;
    }
}
