package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddressDirectoryTest {
    private AddressDirectory addressDirectory;

    @Test
    public void getAddress() {
        PersonAddressPair personAddressPair1 = new PersonAddressPair(
                new Person("Paul", "Newman"),
                new Address("25 Cool Cottage", "Avenger Lane", "12345", "New York"));
        PersonAddressPair personAddressPair2 = new PersonAddressPair(
                new Person("Eva", "Coleman"),
                new Address("16 Malibu Drive", "Sleepy Hollow", "45777", "Dallas"));
        PersonAddressPair personAddressPair3 = new PersonAddressPair(
                new Person("Missy", "Elliot"),
                new Address("5 Carnegie Hall", "Parker Street", "RM15 8LX", "London"));
        List<PersonAddressPair> addressList = Arrays.asList(personAddressPair1, personAddressPair2, personAddressPair3);
        addressDirectory = new AddressDirectory(addressList);
        Person testPerson = new Person("Eva", "Coleman");
        Address expectedAddress = new Address("16 Malibu Drive", "Sleepy Hollow", "45777", "Dallas");
        assertEquals(expectedAddress, addressDirectory.getAddress(testPerson).get());
    }

    @Test
    public void shouldReturnEmptyOptionalIfPersonDoesNotExistsInDirectory() {
        PersonAddressPair personAddressPair1 = new PersonAddressPair(
                new Person("Paul", "Newman"),
                new Address("25 Cool Cottage", "Avenger Lane", "12345", "New York"));
        PersonAddressPair personAddressPair2 = new PersonAddressPair(
                new Person("Eva", "Coleman"),
                new Address("16 Malibu Drive", "Sleepy Hollow", "45777", "Dallas"));
        PersonAddressPair personAddressPair3 = new PersonAddressPair(
                new Person("Missy", "Elliot"),
                new Address("5 Carnegie Hall", "Parker Street", "RM15 8LX", "London"));
        List<PersonAddressPair> addressList = Arrays.asList(personAddressPair1, personAddressPair2, personAddressPair3);
        addressDirectory = new AddressDirectory(addressList);
        Person testPerson = new Person("Lilly", "Parsons");
        assertTrue(addressDirectory.getAddress(testPerson).isEmpty());
    }

    @Test
    public void shouldReturnListOfOnePersonLivingAtAnExistingAddress() {
        PersonAddressPair personAddressPair1 = new PersonAddressPair(
                new Person("Paul", "Newman"),
                new Address("25 Cool Cottage", "Avenger Lane", "12345", "New York"));
        PersonAddressPair personAddressPair2 = new PersonAddressPair(
                new Person("Eva", "Coleman"),
                new Address("16 Malibu Drive", "Sleepy Hollow", "45777", "Dallas"));
        PersonAddressPair personAddressPair3 = new PersonAddressPair(
                new Person("Missy", "Elliot"),
                new Address("5 Carnegie Hall", "Parker Street", "RM15 8LX", "London"));
        List<PersonAddressPair> addressList = Arrays.asList(personAddressPair1, personAddressPair2, personAddressPair3);
        addressDirectory = new AddressDirectory(addressList);
        List<Person> expectedPeople = Arrays.asList(new Person("Paul", "Newman"));
        Address testAddress = new Address("25 Cool Cottage", "Avenger Lane", "12345", "New York");
        assertEquals(expectedPeople, addressDirectory.getPeople(testAddress));
    }
}