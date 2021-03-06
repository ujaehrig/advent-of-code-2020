package de.jaehrig;

import de.jaehrig.common.Puzzle;
import de.jaehrig.common.PuzzleException;
import de.jaehrig.day1.Day1;
import de.jaehrig.day1.Day1Part2;
import de.jaehrig.day2.Day2;
import de.jaehrig.day2.Day2Part2;
import de.jaehrig.day3.Day3;
import de.jaehrig.day3.Day3Part2;
import de.jaehrig.day4.Day4;
import de.jaehrig.day4.Day4Part2;
import de.jaehrig.day5.Day5;
import de.jaehrig.day5.Day5Part2;
import de.jaehrig.day7.Day7;
import de.jaehrig.day8.Day8;
import de.jaehrig.day8.Day8Part2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {

    private Stream<String> getResource(String resourceName) {
        URL resource = App.class.getResource(resourceName);

        try {
            @SuppressWarnings("java:S2095")
            BufferedReader rdr = new BufferedReader(new InputStreamReader(resource.openStream()));
            return rdr.lines().onClose(() -> {
                try {
                    rdr.close();
                } catch (IOException exc) {
                    throw new PuzzleException("Error during close", exc);
                }
            });
        } catch (IOException e) {
            throw new PuzzleException(e);
        }
    }

    private void showResult(int day, Puzzle<?> puzzle, String resource) {
        long start = System.currentTimeMillis();
        try (Stream<String> input = getResource(resource)) {
            Object solution = puzzle.solve(input);
            long end = System.currentTimeMillis();
            System.out.printf("day%d: %s (%dms)%n", day, solution, (end-start));
        }

    }

    public static void main(String[] args) {
        App app = new App();
        app.showResult(1, new Day1(), "/day1/input.txt");
        app.showResult(1, new Day1Part2(), "/day1/input.txt");

        app.showResult(2, new Day2(), "/day2/input.txt");
        app.showResult(2, new Day2Part2(), "/day2/input.txt");

        app.showResult(3, new Day3(), "/day3/input.txt");
        app.showResult(3, new Day3Part2(), "/day3/input.txt");

        app.showResult(4, new Day4(), "/day4/input.txt");
        app.showResult(4, new Day4Part2(), "/day4/input.txt");

        app.showResult(5, new Day5(), "/day5/input.txt");
        app.showResult(5, new Day5Part2(), "/day5/input.txt");

        app.showResult(7, new Day7(), "/day7/input.txt");

        app.showResult(8, new Day8(), "/day8/input.txt");
        app.showResult(8, new Day8Part2(), "/day8/input.txt");
    }
}
