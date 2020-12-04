package de.jaehrig.day4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtendedPassportValidator extends SimplePassportValidator {

    private static final Pattern EYE_COLOR_PATTERN = Pattern.compile("amb|blu|brn|gry|grn|hzl|oth");
    private static final Pattern HAIR_COLOR_PATTERN = Pattern.compile("#[0-9a-f]{6}");
    private static final Pattern PASSPORT_ID_PATTERN = Pattern.compile("[0-9]{9}");
    private static final Pattern HEIGHT_PATTERN = Pattern.compile("(?<height>[0-9]+)(?<x>cm|in)");

    @Override
    public boolean isValid(final Passport passport) {
        return super.isValid(passport)
                && validYearOfBirth(passport.getYearOfBirth())
                && validYearOfIssue(passport.getYearOfIssue())
                && validYearOfExpiration(passport.getYearOfExpiration())
                && validHeight(passport.getHeight())
                && validHairColor(passport.getHairColor())
                && validEyeColor(passport.getEyeColor())
                && validPassportId(passport.getPassportId());
    }

    private boolean validPassportId(final String passportId) {
        return PASSPORT_ID_PATTERN.matcher(passportId).matches();
    }

    private boolean validEyeColor(final String eyeColor) {
        return EYE_COLOR_PATTERN.matcher(eyeColor).matches();
    }

    private boolean validHairColor(final String hairColor) {
        return HAIR_COLOR_PATTERN.matcher(hairColor).matches();
    }

    private boolean validHeight(final String heightString) {
        Matcher matcher = HEIGHT_PATTERN.matcher(heightString);
        if (matcher.matches()) {
            int height = Integer.parseInt(matcher.group("height"));
            String x = matcher.group("x");
            return x.equals("cm") && height >= 150 && height <= 193
                    || x.equals("in") && height >= 59 && height <= 76;
        }
        return false;
    }

    private boolean validYearOfExpiration(final Integer yearOfExpiration) {
        return yearOfExpiration >= 2020 && yearOfExpiration <= 2030;
    }

    private boolean validYearOfIssue(final Integer yearOfIssue) {
        return yearOfIssue >= 2010 && yearOfIssue <= 2020;
    }

    private boolean validYearOfBirth(final Integer yearOfBirth) {
        return yearOfBirth >= 1920 && yearOfBirth <= 2002;
    }
}
