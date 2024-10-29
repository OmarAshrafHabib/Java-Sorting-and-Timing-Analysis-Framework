import java.util.*;
import java.text.NumberFormat;

public class TimeTest {
    public static void main(String[] args) {
        int maxQuant = 100000;
        int increment = 10000;

        System.out.println(" ******Selection Sort*******");
        System.out.println(" Quantity       Duration(ms)");
        System.out.println("===========     ============");

        for (int quantity = 0; quantity <= maxQuant; quantity += increment) {
            ComparableDraw compDraw = new ComparableDraw(quantity);
            Random ran = new Random();
            long before;
            long after;
            long duration;

            for (int i = 0; i < quantity; i++) {
                int randomNum = ran.nextInt(9000) + 1000;
                ComparableTicket ticket = new ComparableTicket(randomNum);
                compDraw.addTicket(ticket);
            }
            Sorter<ComparableTicket> ticketSorter = new Sorter<ComparableTicket>();

            before = System.currentTimeMillis();

            ticketSorter.selectionSort(compDraw.getTickets(), compDraw.getTicketQuantity());

            after = System.currentTimeMillis();

            duration = after - before;
            System.out.printf("%6d%12d\n", quantity,duration); 
        }

        System.out.println(" ******Merge Sort*******");
        System.out.println(" Quantity       Duration(ms)");
        System.out.println("===========     ============");

        for(int quantity = 0; quantity <= maxQuant; quantity += increment){
            ComparableDraw compDraw2 = new ComparableDraw(quantity);

            Random ran = new Random();
            long before;
            long after;
            long duration;

            for (int i = 0; i < quantity; i++) {
                int randomNum = ran.nextInt(9000) + 1000;
                ComparableTicket ticket = new ComparableTicket(randomNum);
                compDraw2.addTicket(ticket);
            }
            Sorter<ComparableTicket> ticketSorter2 = new Sorter<ComparableTicket>();
            before = System.currentTimeMillis();
            ticketSorter2.mergeSort(compDraw2.getTickets(), compDraw2.getTicketQuantity());
            after = System.currentTimeMillis();
            duration = after - before;
            System.out.printf("%6d%12d\n", quantity,duration); 
        }
    }
}



