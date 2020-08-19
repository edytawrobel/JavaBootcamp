import org.junit.Test;

import static org.junit.Assert.*;

public class CinemaTest {
    @Test
    public void shouldBeAbleToBuyCinemaTicketWhenOlderThanRestriction() {
        int age = 19;
        Customer customer = new Customer(age);
        Movie movie = new Movie("Frozen 2", 12);
        Cinema cinema = new Cinema();
        boolean canGetTicket = cinema.canBuyTicket(movie, customer);
        assertTrue(canGetTicket);
    }

    @Test
    public void shouldNotBeAbleToBuyCinemaTicketWhenYoungerThanRestriction() {

        int age = 17;
        Customer customer = new Customer(age);
        Movie movie = new Movie("Inception", 18);
        Cinema cinema = new Cinema();
        boolean canBuyTicket = cinema.canBuyTicket(movie, customer);
        assertFalse(canBuyTicket);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenTryOrderTicketAndYoungerThanAgeRestriction() {
        int age = 17;
        Customer customer = new Customer(age);
        Movie movie = new Movie("Inception", 18);
        Cinema cinema = new Cinema();
        cinema.orderTicket(movie, customer, 42);
//        assertFalse(canBuyTicket);
    }

    @Test
    public void shouldGetTicketForTheRightSeatAndMovie() {
        //given
        int age = 19;
        String title = "Frozen 2";
        int seat = 42;
        Customer customer = new Customer(age);
        Movie movie = new Movie(title, 12);
        Cinema cinema = new Cinema();
        //when
        Ticket ticket = cinema.orderTicket(movie, customer, seat);
        Ticket ticket1 = cinema.orderTicket(movie, customer, seat);

        //then
        assertEquals(ticket1, ticket);
    }
}
