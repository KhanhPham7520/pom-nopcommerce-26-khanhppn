package Data_Faker;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelperForLanguageEn {

    Locale localeEn = new Locale("en");
    Faker faker = new Faker(localeEn);

    public static DataHelperForLanguageEn getData() {
        return new DataHelperForLanguageEn();
    }

    public String getFirstName() {
        // Generating the first name
        String firstName = faker.name().firstName();
        return firstName;
    }

    public String getLastName() {
        // Generating last name
        String lastName = faker.name().lastName();
        return lastName;
    }

    public String getAddress() {
        return faker.address().streetAddress();
    }

    public String getPhone() {
        return faker.phoneNumber().phoneNumber();
    }

    public String getCompany() {
        return faker.company().name();
    }

    public String getEmail() {
        // Generating email Id
        String emailId = faker.internet().emailAddress();
        return emailId;
    }

    public String getPassword() {
        // Generating password
        String pwd = faker.internet().password();
        return pwd;
    }
}
