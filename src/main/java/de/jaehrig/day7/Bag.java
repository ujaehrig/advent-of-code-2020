package de.jaehrig.day7;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Bag {

    private final String color;
    private final Set<Bag> contains = new HashSet<>();
    private final Set<Bag> containedIn = new HashSet<>();

    public void addContains(final Bag containedBag) {
        contains.add(containedBag);
    }

    public void addContainedIn(final Bag bag) {
        containedIn.add(bag);
    }

    Bag(String color) {
        this.color = color;
    }

    String color() { return color; }

    Set<Bag> getContained() {
        return Set.copyOf(contains);
    }

    Set<Bag> getContainedIn() {
        return Set.copyOf(containedIn);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bag bag = (Bag) o;
        return color.equals(bag.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Bag.class.getSimpleName() + "[", "]")
                .add("color='" + color + "'")
                .add("contains=" + contains.stream().map(Bag::color).collect(Collectors.toList()))
                .add("contained-in=" + containedIn.stream().map(Bag::color).collect(Collectors.toList()))
                .toString();
    }
}
