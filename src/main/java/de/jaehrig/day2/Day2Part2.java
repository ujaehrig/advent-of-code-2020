package de.jaehrig.day2;

import de.jaehrig.common.Puzzle;
import de.jaehrig.common.PuzzleException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Day2Part2 implements Puzzle<String> {

    // "1-3 a: abcde"
    private static final Pattern PARSER = Pattern
            .compile("(?<p1>[0-9]+)-(?<p2>[0-9]+) (?<char>[a-z]): (?<password>.*)");

    @Override
    public String solve(final Stream<String> input) {
        long count = input.map(Test::parse).filter(this::isValid).count();
        return String.valueOf(count);
    }

    static class Test {

        final int p1;
        final int p2;
        final char aChar;
        final String password;

        private Test(int p1, int p2, char aChar, String password) {
            this.p1 = p1;
            this.p2 = p2;
            this.aChar = aChar;
            this.password = password;
        }

        static Test parse(String s) {
            Matcher matcher = PARSER.matcher(s);
            if(matcher.matches()) {
                int p1 = Integer.parseInt(matcher.group("p1"));
                int p2 = Integer.parseInt(matcher.group("p2"));
                char aChar = matcher.group("char").charAt(0);
                return new Test(p1, p2, aChar, matcher.group("password"));
            } else {
                throw new PuzzleException("Parsing failed");
            }
        }
    }

    private boolean isValid(Test test) {
        return test.password.charAt(test.p1 - 1) == test.aChar ^ test.password.charAt(test.p2 - 1) == test.aChar;
    }
}
