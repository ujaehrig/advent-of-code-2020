package de.jaehrig.day4;

class Passport {

    private final Integer yearOfBirth;
    private final Integer yearOfIssue;
    private final Integer yearOfExpiration;
    private final String height;
    private final String hairColor;
    private final String eyeColor;
    private final String passportId;
    private final String country;

    public Passport(PassportBuilder builder) {
        yearOfBirth = builder.yearOfBirth;
        yearOfIssue = builder.yearOfIssue;
        yearOfExpiration = builder.yearOfExpiration;
        height = builder.height;
        hairColor = builder.hairColor;
        eyeColor = builder.eyeColor;
        passportId = builder.passwordId;
        country = builder.country;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public Integer getYearOfIssue() {
        return yearOfIssue;
    }

    public Integer getYearOfExpiration() {
        return yearOfExpiration;
    }

    public String getHeight() {
        return height;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getPassportId() {
        return passportId;
    }

    public String getCountry() {
        return country;
    }

    static PassportBuilder builder() {
        return new PassportBuilder();
    }

    static class PassportBuilder {

        private Integer yearOfBirth;
        private Integer yearOfIssue;
        private Integer yearOfExpiration;
        private String height;
        private String hairColor;
        private String eyeColor;
        private String passwordId;
        private String country;

        public void withYearOfBirth(final Integer yearOfBirth) {
            this.yearOfBirth = yearOfBirth;
        }

        public void withYearOfIssue(final Integer yearOfIssue) {
            this.yearOfIssue = yearOfIssue;
        }

        public void withYearOfExpiration(final Integer yearOfExpiration) {
            this.yearOfExpiration = yearOfExpiration;
        }

        public void withHeight(final String height) {
            this.height = height;
        }

        public void withHairColor(final String hairColor) {
            this.hairColor = hairColor;
        }

        public void withEyeColor(final String eyeColor) {
            this.eyeColor = eyeColor;
        }

        public void withPasswordId(final String passwordId) {
            this.passwordId = passwordId;
        }

        public void withCountry(final String country) {
            this.country = country;
        }

        public Passport build() {
            return new Passport(this);
        }
    }
}
