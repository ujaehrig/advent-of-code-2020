package de.jaehrig.day7;

import de.jaehrig.common.Puzzle;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day7 implements Puzzle<Number> {

    @Override
    public Number solve(final Stream<String> input) {
        List<String> inputList = input.collect(Collectors.toList());
        BagParser parser = new BagParser();
        Map<String, Bag> bags = parser.parseRule(inputList);

        Bag shinyGold = bags.get("shiny gold");
        Set<Bag> containedIn = collectContainedIn(shinyGold);
        return containedIn.size();
    }

    private Set<Bag> collectContainedIn(Bag bag) {
        HashSet<Bag> set = new HashSet<>(bag.getContainedIn());
        for(Bag b : bag.getContainedIn()) {
            set.addAll(collectContainedIn(b));
        }
        return set;
    }

}
