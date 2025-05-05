package utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    static Faker faker = new Faker();

    public static String getRandomSubject() {
        return faker.options().option("Maths", "Chemistry", "Economics", "Arts");
    }

    public static String getRandomHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public static String getRandomMonth() {
        return faker.options().option("January",
                            "February",
                            "March",
                            "April",
                            "May",
                            "June",
                            "July",
                            "August",
                            "September",
                            "October",
                            "November",
                            "December"
        );
    }

    public static String getRandomYear() {
        return String.valueOf(getRandomInt(1950, 2000));
    }

    public static String getRandomDay() {
        return String.valueOf(getRandomInt(1, 28));
    }

    public static String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" ->  faker.options().option("Jaipur", "Jaiselmer");
            default -> throw new IllegalArgumentException("Неопределенное значение state: " + state);
        };
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
