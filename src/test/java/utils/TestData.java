package utils;

import com.github.javafaker.Faker;

import java.time.Month;
import java.time.Year;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TestData {

    Faker faker = new Faker(new Locale("en-GB"));

    public static final String[] genders = {"Male","Female","Other"};
    public static final String[] listOfMonths = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
    public static final String[] subjects = {"Maths", "Accounting", "Arts", "Social Studies", "Physics", "Chemistry"};
    public static final String[] hobbies = { "Sports","Reading", "Music" };
    public static String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    public static Map<String, String[]> statesAndCityMap = new HashMap<>();

    public String firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            userEmail = getRandomUserEmail(),
            gender = getRandomGender(),
            userNumber = getRandomPhoneNumber(),
            picture = "file.png",
            subject = getRandomSubjects(),
            hobbie = getRandomHobbies(),
            currentAddress = getRandomAddress(),
            state = getRandomState(),
            city = fillStatesAndGetCity(state),
            year = String.valueOf(getRandomYear()),
            month = getRandomMonth(),
            day = getRandomDay(month);

    public String getRandomFirstName(){
        return faker.name().firstName();
    }
    public String getRandomLastName(){
        return faker.name().lastName();
    }
    public String getRandomUserEmail(){
        return faker.internet().emailAddress();
    }
    public String getRandomGender(){
        return faker.options().option(genders);
    }
    public String getRandomPhoneNumber(){
        return faker.number().digits(10);
    }
    public String getRandomSubjects(){
        return faker.options().option(subjects);
    }
    public String getRandomHobbies(){
        return faker.options().option(hobbies);
    }
    public String getRandomAddress(){
        return faker.address().streetAddress();
    }
    public String getRandomState(){
        return faker.options().option(states);
    }
    public String getRandomMonth(){
        return faker.options().option(listOfMonths);
    }
    public int getRandomYear(){
        return faker.number().numberBetween(1900, Year.now().getValue());
    }

    public String getRandomDay(String month){
        return Integer.toString(faker.number().numberBetween(1, Month.valueOf(month.toUpperCase()).length(true)));
    }
    public String fillStatesAndGetCity(String state){
        statesAndCityMap.put(states[0], new String[]{"Delphi", "Gurgaon", "Noida"});
        statesAndCityMap.put(states[1], new String[]{"Agra", "Lucknow", "Merrut"});
        statesAndCityMap.put(states[2], new String[]{"Karnal", "Panipat"});
        statesAndCityMap.put(states[3], new String[]{"Jaipur", "Jaiselmer"});
        String[] cityArray = statesAndCityMap.get(state);

        return cityArray[faker.number().numberBetween(0, cityArray.length)];

    }

}
