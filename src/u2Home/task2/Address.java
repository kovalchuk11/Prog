package u2Home.task2;

public class Address {
    private String country;
    private String city;
    private String street;
    @Override
    public String toString() {
        return "\n\t\tCountry: " + country + "\n" +
                "\t\tCity: " + city + "\n" +
                "\t\tStreet: " + street + "\n";
    }
}
