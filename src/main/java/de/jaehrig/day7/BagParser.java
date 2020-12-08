package de.jaehrig.day7;

import de.jaehrig.common.PuzzleException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BagParser {

    // light red bags contain 1 bright white bag, 2 muted yellow bags.
    // dotted black bags contain no other bags.
    private static final Pattern RULE_PATTERN =
            Pattern.compile("(?<mcol>.*) bags contain(?<cont>.*)");
    private static final Pattern CONTAIN_PATTERN = Pattern.compile(" [1-9] (?<ccol>[^,.]*) bags?,?");

    private Map<String, Bag> bags = new HashMap<>();

    Bag getOrCreate(String bagColor) {
        return bags.computeIfAbsent(bagColor, Bag::new);
    }

    Map<String, Bag> parseRule(List<String> rules) {
        for (String rule : rules) {
            Matcher matcher = RULE_PATTERN.matcher(rule);
            if (matcher.matches()) {
                Bag bag = getOrCreate(matcher.group("mcol"));
                for(String color : parseContainments(matcher.group("cont"))) {
                    Bag containedBag = getOrCreate(color);
                    bag.addContains(containedBag);
                    containedBag.addContainedIn(bag);
                }
            } else {
                throw new PuzzleException("Parsing failed: " + rule);
            }
        }

        return Map.copyOf(bags);
    }

    List<String> parseContainments(String s) {
        List<String> list = new ArrayList<>();
        Matcher matcher = CONTAIN_PATTERN.matcher(s);
        while (matcher.find()) {
            String bagColor = matcher.group("ccol");
            list.add(bagColor);
        }
        return list;
    }

}
