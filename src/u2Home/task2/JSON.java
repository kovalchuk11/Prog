package u2Home.task2;

import java.util.Arrays;

public class JSON {
    private String name;
    private String surname;
    private String[] phones;
    private String[] sites;
    private Address address ;
    @Override
    public String toString() {
        return  "Name: " + name + "\n" +
                "\tSurname: " +  surname + "\n" +
                "\tPhones: " + Arrays.toString(phones) + "\n" +
                "\tSites: " + Arrays.toString(sites) + "\n" +
                "\tAddress: " + address.toString() + "\n";
    }
}
