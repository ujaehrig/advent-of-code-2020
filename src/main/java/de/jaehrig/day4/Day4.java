package de.jaehrig.day4;

import de.jaehrig.common.Puzzle;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day4 implements Puzzle<Long> {

    private final PassportValidator validator;

    public Day4() {
        this(new SimplePassportValidator());
    }

    protected Day4(PassportValidator validator) {
        this.validator = validator;
    }

    @Override
    public Long solve(final Stream<String> input) {
        List<Passport> passports = parse(input);
        return passports.stream().filter(validator::isValid).count();
    }

    private List<Passport> parse(final Stream<String> input) {
        List<Passport> passports = new ArrayList<>();
        PassportParser parser = new PassportParser();

        List<String> list = input.collect(Collectors.toList());
        for (String line : list) {
            if (line.isBlank()) {
                passports.add(parser.getPassport());
                parser.reset();
            } else {
                parser.parse(line);
            }
        }
        passports.add(parser.getPassport());

        return passports;
    }

}
