package tests;

import com.github.javafaker.Faker;

import static utils.RandomUtils.*;

public class TestData {

    static Faker faker = new Faker();

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            mobile = faker.phoneNumber().subscriberNumber(10),
            monthOfBirth = getRandomMonth(),
            yearOfBirth = getRandomYear(),
            dayOfBirth = getRandomDay(),
            subject = getRandomSubject(),
            hobby = getRandomHobby(),
            picture = "mem_1.jpg",
            address = faker.address().fullAddress(),
            state = getRandomState(),
            city = getRandomCity(state),
            stateAndCity = String.format("%s %s", state, city);
}
