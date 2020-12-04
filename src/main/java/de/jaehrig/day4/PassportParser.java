package de.jaehrig.day4;

import de.jaehrig.common.PuzzleException;
import de.jaehrig.day4.Passport.PassportBuilder;

public class PassportParser {

    private PassportBuilder builder = Passport.builder();

    public void parse(String s) {
        for (String parts : s.split("\\s")) {
            String[] token = parts.split(":");
            if (token.length != 2) {
                throw new PuzzleException("Parse failure: " + parts);
            }
            handleToken(token[0], token[1]);
        }
    }

    public void reset() {
        builder = Passport.builder();
    }

    public Passport getPassport() {
        return builder.build();
    }

    private void handleToken(String key, String value) {
        switch (key) {
            case "byr":
                builder.withYearOfBirth(Integer.valueOf(value));
                break;
            case "iyr":
                builder.withYearOfIssue(Integer.valueOf(value));
                break;
            case "eyr":
                builder.withYearOfExpiration(Integer.valueOf(value));
                break;
            case "hgt":
                builder.withHeight(value);
                break;
            case "hcl":
                builder.withHairColor(value);
                break;
            case "ecl":
                builder.withEyeColor(value);
                break;
            case "pid":
                builder.withPasswordId(value);
                break;
            case "cid":
                builder.withCountry(value);
                break;
            default:
                throw new PuzzleException("Unknown token");
        }
    }

}


