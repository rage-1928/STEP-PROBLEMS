import java.util.*;

abstract class Cab {
    abstract double getRate();

    double calculateFare(double km) {
        double fare = km * getRate();
        return Math.max(fare, 100);
    }
}

interface NightService {
    double NIGHT_MULTIPLIER = 1.20;

    double applyNightFare(double fare);
}

class Mini extends Cab {

    @Override
    double getRate() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {

    @Override
    double getRate() {
        return 14;
    }

    @Override
    public double applyNightFare(double fare) {
        return fare * NIGHT_MULTIPLIER;
    }
}

class SUV extends Cab implements NightService {

    @Override
    double getRate() {
        return 18;
    }

    @Override
    public double applyNightFare(double fare) {
        return fare * NIGHT_MULTIPLIER;
    }
}

public class Question4 {

    static Cab createCab(String type) {
        switch (type) {
            case "MINI":
                return new Mini();
            case "SEDAN":
                return new Sedan();
            case "SUV":
                return new SUV();
            default:
                throw new IllegalArgumentException("Invalid cab type");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab = createCab(type);

            if (time.equals("NIGHT")
                    && !(cab instanceof NightService)) {

                output.append(
                    type + ": night service not available%n"
                );

                continue;
            }

            double fare = cab.calculateFare(km);

            if (time.equals("NIGHT")) {
                NightService nightCab = (NightService) cab;
                fare = nightCab.applyNightFare(fare);
            }

            total += fare;

            output.append(String.format(
                "%s: %.2f%n",
                type,
                fare
            ));
        }

        output.append(String.format(
            "Total: %.2f%n",
            total
        ));

        System.out.print(output);
    }
}