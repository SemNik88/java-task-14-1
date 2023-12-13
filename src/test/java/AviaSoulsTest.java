import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void testTicketComparison() {
        Ticket ticket1 = new Ticket("A", "B", 100, 800, 1200);
        Ticket ticket2 = new Ticket("C", "D", 150, 900, 1300);

        Assertions.assertTrue(ticket1.compareTo(ticket2) < 0);
    }

    @Test
    public void testSearchAndSortByPrice() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("A", "B", 100, 800, 1200);
        Ticket ticket2 = new Ticket("A", "B", 80, 900, 1300);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] result = aviaSouls.searchAndSortBy("A", "B", Comparator.naturalOrder());

        Assertions.assertEquals(80, result[0].getPrice());
        Assertions.assertEquals(100, result[1].getPrice());
    }

    @Test
    public void testSearchAndSortByTime() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("A", "B", 100, 800, 1200);
        Ticket ticket2 = new Ticket("A", "B", 80, 900, 1300);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] result = aviaSouls.searchAndSortBy("A", "B", new AviaSouls.TicketTimeComparator());

        Assertions.assertEquals(900, result[0].getTimeFrom());
        Assertions.assertEquals(800, result[1].getTimeFrom());
    }
}