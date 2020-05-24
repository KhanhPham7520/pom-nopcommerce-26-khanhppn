package Data_Faker;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelperForLanguageVi {

	Locale localeVi = new Locale("Vi");
	Faker faker = new Faker(localeVi);

	public static DataHelperForLanguageVi getData() {
		return new DataHelperForLanguageVi();
	}

	public String getFirstName() {
		// Generating the first name
		return faker.name().firstName();
	}

	public String getLastName() {
		// Generating last name
		return faker.name().lastName();
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
		return faker.internet().emailAddress();
	}

	public String getPassword() {
		// Generating password
		return faker.internet().password();
	}

	public String getCountry() {
		// Generating password
		return faker.country().name();
	}

	public String getCity() {
		// Generating password
		return faker.address().cityName();
	}

}
