public class Cinema {

    public boolean canBuyTicket(Movie movie, Customer customer){
        return customer.getAge() > movie.getAgeRestriction();
    }

    public Ticket orderTicket(Movie movie, Customer customer) {
        if(canBuyTicket(movie,customer)) {
            return new Ticket("Frozen 2", 42);
        } else {
            throw new RuntimeException("Age restriction violated");
        }
    }
}
