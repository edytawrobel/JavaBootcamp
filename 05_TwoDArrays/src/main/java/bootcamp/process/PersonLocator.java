package bootcamp.process;

import bootcamp.data.Location;
import bootcamp.data.Person;

import java.util.Optional;

public class PersonLocator {
    private final Person[][] people;

    public PersonLocator(Person[][] people) {
        this.people = people;
    }

    //nested loop
    public Optional<Location> find(final Person person) {
        if (person == null || people == null) return Optional.empty();
        int rowIndex = 0;
        while(rowIndex < people.length) {
//        for (int rowIndex = 0; rowIndex < people.length; rowIndex++ ) {
            Object[] row = people[rowIndex];
            if (row != null) {
                for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
                    if (person.equals(row[columnIndex])) return Optional.of(new Location(rowIndex, columnIndex));
                }
            }
        }
        return Optional.empty();
    }
}

//    public Optional<Location> find(final Person person) {
//
//        int x = 0;
//        while (x < people.length) {
//            for(int y = 0; y < people[x].length; y++) {
//                if (person.equals(people[x][y])) {
//                    return Optional.of(new Location(x, y));
//                }
//            }
//            x++;
//        }
//        return Optional.empty();
//    }


// an array of people from Person obj (firstName lastName) find a person in people array and return their location