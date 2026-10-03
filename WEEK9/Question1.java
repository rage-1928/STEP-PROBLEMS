import java.util.*;

abstract class Ticket {
    static final double CONVENIENCE_FEE = 20;

    abstract double getPrice();

    double getAmount(int count) {
        return (getPrice() + CONVENIENCE_FEE) * count;
    }
}

class RegularTicket extends Ticket {
    @Override
    double getPrice() {
        return 150;
    }
}

class PremiumTicket extends Ticket {
    @Override
    double getPrice() {
        return 250;
    }
}

class ReclinerTicket extends Ticket {
    @Override
    double getPrice() {
        return 400;
    }
}

public class Question1 {

    static Ticket createTicket(String seat) {
        switch (seat) {
            case "REGULAR":
                return new RegularTicket();
            case "PREMIUM":
                return new PremiumTicket();
            case "RECLINER":
                return new ReclinerTicket();
            default:
                throw new IllegalArgumentException("Invalid seat type");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            Ticket ticket = createTicket(seat);
            double amount = ticket.getAmount(count);

            total += amount;

            output.append(String.format(
                "%s: %.2f%n", seat, amount
            ));
        }

        output.append(String.format(
            "Total: %.2f%n", total
        ));

        System.out.print(output);
    }
}