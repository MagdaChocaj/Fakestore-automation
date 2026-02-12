package fakestore.models;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class Customer {

    String email;
    String firstName;
    String lastName;
    String address;
    String postalCode;
    String city;
    String phoneNumber;
    String password;

    Faker faker = new Faker();
    private static final Random random = new Random();

    public Customer() {
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = emailFromName(firstName, lastName, "gmail.com");
        this.address = faker.address().streetAddress();
        this.postalCode = faker.address().zipCode();
        this.city = faker.address().city();
        this.phoneNumber = faker.phoneNumber().cellPhone();
    }

    public String getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getEmail() {
        return email;
    }

    public static String emailFromName(String firstName, String lastName, String domain) {
        String[] patterns = {
                firstName.toLowerCase() + "." + lastName.toLowerCase(),
                firstName.substring(0, 1).toLowerCase() + lastName.toLowerCase(),
                firstName.toLowerCase() + lastName.substring(0, 1).toLowerCase(),
                firstName.toLowerCase() + "_" + lastName.toLowerCase()
        };
        String username = patterns[random.nextInt(patterns.length)];
        return username + "@" + domain;
    }

    public String generatePassword() {
        String newPassword = faker.numerify("7");
        return this.password = newPassword;

    }
}
