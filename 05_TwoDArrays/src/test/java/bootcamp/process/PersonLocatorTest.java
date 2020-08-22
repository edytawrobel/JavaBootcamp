package bootcamp.process;

import bootcamp.data.Location;
import bootcamp.data.Person;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Optional;

import static org.junit.Assert.*;

public class PersonLocatorTest {

    @Test
    public void shouldLocateThePersonInTheArray() {
        Person person = new Person("Jack", "Sparrow");
        Person person1 = new Person("Amanda", "Sparrow");
        Person[][] people = new Person[][]{{person, person1}};
        PersonLocator locator = new PersonLocator(people);
        Optional<Location> location = locator.find(person);
        int x = location.get().getX();
        int y = location.get().getY();

        assertTrue(location.isPresent());
        assertEquals(x, 0);
        assertEquals(y, 0);
    }

    @Test
    public void shouldNotLocateThePersonInTheArray() {
        Person person = new Person("Jack", "Sparrow");
        Person person1 = new Person("Amanda", "Sparrow");
        Person person2 = new Person("Edith", "Piaf");
        Person[][] people = new Person[][]{{person, person1}};
        PersonLocator locator = new PersonLocator(people);
        Optional<Location> location = locator.find(person2);

        assertTrue(location.isEmpty());
    }
}
