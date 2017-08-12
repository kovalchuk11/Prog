package u2Home.task2;

public class Address {
    public String country;
    public String city;
    public String street;
    @Override
    public String toString() {
        return "\n\t\tCountry: " + country + "\n" +
                "\t\tCity: " + city + "\n" +
                "\t\tStreet: " + street + "\n";
    }
}
