package bootcamp;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.directory.AddressDirectory;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
// wip BeforeEach() does not work with this set-up
public class AddressDirectoryTest {
    private AddressDirectory addressDirectory;
    private Person alexis;
    private Address address;
    private Person david;
    private Address davidAddress;

    @Test
    public void shouldReturnCorrectAddressIfPersonExistsInDirectory() {
        alexis = new Person("Alexis", "Rose");
        address = new Address("Rosebud Motel", "Canada", "12345", "Schitts Creek");
        david = new Person("Alexis", "Rose");
        davidAddress = new Address("Rosebud Motel", "Canada", "12345", "Schitts Creek");
        PersonAddressPair personAddressPair = new PersonAddressPair(alexis, address);

        HashMap<Person, Address> addressList = new HashMap<>();
        addressList.put(alexis, address);
        addressDirectory = new AddressDirectory(addressList);
        assertEquals(address, addressDirectory.getAddress(alexis).get());
        assertNotEquals(davidAddress, addressDirectory.getAddress(david).get());
    }
}


