package de.jaehrig.day2;

import de.jaehrig.common.Puzzle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Day2 implements Puzzle {

    // "1-3 a: abcde"
    private static final Pattern PARSER = Pattern
            .compile("(?<min>[0-9]+)-(?<max>[0-9]+) (?<char>[a-z]): (?<password>.*)");

    @Override
    public String solve(final Stream<String> input) {
        long count = input.map(Test::parse).filter(this::isValid).count();
        return String.valueOf(count);
    }

    static class Test {

        final int min;
        final int max;
        final char aChar;
        final String password;

        private Test(int min, int max, char aChar, String password) {
            this.min = min;
            this.max = max;
            this.aChar = aChar;
            this.password = password;
        }

        static Test parse(String s) {
            Matcher matcher = PARSER.matcher(s);
            matcher.matches();
            int min = Integer.parseInt(matcher.group("min"));
            int max = Integer.parseInt(matcher.group("max"));
            char aChar = matcher.group("char").charAt(0);
            return new Test(min, max, aChar, matcher.group("password"));
        }
    }

    private boolean isValid(Test test) {
        long count = test.password.chars().filter(c -> c == test.aChar).count();
        return count >= test.min && count <= test.max;
    }
}
