package bootcamp.directory;

import bootcamp.data.Address;
import bootcamp.data.Person;
import bootcamp.data.PersonAddressPair;
import bootcamp.data.Status;

import java.util.*;

public class AddressDirectory {
    private final Map<Person, Address> directory;

    public AddressDirectory(final List<PersonAddressPair> addressList) {
        this.directory = new TreeMap<>();
        addressList.forEach((p) -> directory.put(p.getPerson(), p.getAddress()));
    }

    public Optional<Address> getAddress(final Person person) {
        return Optional.ofNullable(directory.get(person));
    }

//    find all the people by address, if address does not exist return empty list
    public List<Person> getPeople(final Address lookupAddress) {
        List<Person> people = new ArrayList<>();
        directory.forEach((person, address) -> {if(address.equals(lookupAddress)) people.add(person);});
        return people;
    }

    public Status updateAddress(Person person, Address address) {
        if(person != null) {
            directory.put(person, address);
        }
        return Status.SUCCESS;
    }

    public Status updateAddress(Address newAddress, Address currentAddress) {
        List<Person> people = getPeople(currentAddress);
        if(people.isEmpty()) {
            return Status.KEY_NOT_FOUND;
        };
        people.forEach(person -> updateAddress(person, newAddress));
        return Status.SUCCESS;
    }

    //    The ability to remove an address. That should remove all persons residing at that address.
    public Status remove(final Person person) {
        if(person != null) {
            directory.remove(person);
            return Status.SUCCESS;
        }
        return Status.KEY_NOT_FOUND;
    }

    public Status remove(Address address) {
        List<Person> people = getPeople(address);
        if(people.isEmpty()) {
            return Status.KEY_NOT_FOUND;
        };
        people.forEach(person -> remove(person));
        return Status.SUCCESS;
    }
}
//update and remove methods should return a status enum indicating success if the operation was carried out
// and a key not found status if the value being searched does not exist.