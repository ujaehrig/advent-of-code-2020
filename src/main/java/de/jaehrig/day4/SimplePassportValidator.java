package de.jaehrig.day4;

public class SimplePassportValidator implements PassportValidator {

    @Override
    public boolean isValid(Passport passport) {
        return passport.getYearOfBirth() != null
                && passport.getYearOfIssue() != null
                && passport.getYearOfExpiration() != null
                && passport.getHeight() != null
                && passport.getHairColor() != null
                && passport.getEyeColor()  != null
                && passport.getPassportId() != null;
    }

}
