public enum BeheshtiUniversityField {
    COMPUTER_SCIENCE("Computer science"),
    LIFE_SCIENCES("Life sciences"),
    SPORT_SCIENCE("Sport science"),
    AGRICULTURE_FORESTRY("Agriculture & forestry"),
    BIOLOGICAL_SCIENCES("Biological sciences"),
    SOCIAL_SCIENCES("Social sciences"),
    ENVIRONMENTAL_STUDIES("Environmental studies"),
    ENGINEERING_TECHNOLOGY("Engineering & technology"),
    ARTS_HUMANITIES("Arts & humanities"),
    ECONOMICS_BUSINESS("Economics & business management"),
    NATURAL_SCIENCES_MATH("Natural sciences & mathematics"),
    PSYCHOLOGY("Psychology"),
    LAW("Law"),
    MEDICINE_HEALTHCARE("Medicine & healthcare studies");

    private final String description;

    BeheshtiUniversityField(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

