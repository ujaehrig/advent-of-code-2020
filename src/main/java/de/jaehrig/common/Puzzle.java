package de.jaehrig.common;

import java.util.stream.Stream;

public interface Puzzle<T> {
    T solve(Stream<String>input);
}
