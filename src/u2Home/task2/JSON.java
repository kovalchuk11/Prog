package u2Home.task2;

import java.util.Arrays;

public class JSON {
    public String name;
    public String surname;
    public String[] phones;
    public String[] sites;
    public Address address ;
    @Override
    public String toString() {
        return  "Name: " + name + "\n" +
                "\tSurname: " +  surname + "\n" +
                "\tPhones: " + Arrays.toString(phones) + "\n" +
                "\tSites: " + Arrays.toString(sites) + "\n" +
                "\tAddress: " + address.toString() + "\n";
    }
}
