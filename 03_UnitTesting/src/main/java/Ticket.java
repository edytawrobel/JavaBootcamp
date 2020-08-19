import java.util.Objects;

public class Ticket {
    private final String title;
    private final int seat;

    public Ticket(String title, int seat) {
        this.title = title;
        this.seat = seat;
    }

    public String getTitle() {
        return title;
    }

    public int getSeat() {
        return seat;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Ticket ticket = (Ticket) obj;
        return Objects.equals(title, ticket.title) && seat == ticket.seat;
    }
}

