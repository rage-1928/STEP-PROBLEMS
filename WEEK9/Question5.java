import java.util.*;

abstract class Appliance {
    double power;

    Appliance(double power) {
        this.power = power;
    }

    double getUnits(double hours) {
        return power * hours / 1000;
    }

    double getCost(double units) {
        return units * 8;
    }
}

interface SaverMode {
    double SAVER_FACTOR = 0.75;

    double applySaver(double units);
}

class Fridge extends Appliance {

    Fridge() {
        super(150);
    }
}

class AC extends Appliance implements SaverMode {

    AC() {
        super(1500);
    }

    @Override
    public double applySaver(double units) {
        return units * SAVER_FACTOR;
    }
}

class TV extends Appliance {

    TV() {
        super(100);
    }
}

class Washer extends Appliance implements SaverMode {

    Washer() {
        super(500);
    }

    @Override
    public double applySaver(double units) {
        return units * SAVER_FACTOR;
    }
}

public class Question5 {

    static Appliance createAppliance(String type) {
        switch (type) {
            case "FRIDGE":
                return new Fridge();
            case "AC":
                return new AC();
            case "TV":
                return new TV();
            case "WASHER":
                return new Washer();
            default:
                throw new IllegalArgumentException(
                    "Invalid appliance type"
                );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                saver = true;
            }

            Appliance appliance = createAppliance(type);

            if (saver && !(appliance instanceof SaverMode)) {
                output.append(
                    type + ": saver mode not supported\n"
                );
                continue;
            }

            double units = appliance.getUnits(hours);

            if (saver) {
                SaverMode saverAppliance =
                    (SaverMode) appliance;

                units = saverAppliance.applySaver(units);
            }

            double cost = appliance.getCost(units);
            totalCost += cost;

            output.append(String.format(
                "%s: Units=%.2f Cost=%.2f%n",
                type,
                units,
                cost
            ));
        }

        output.append(String.format(
            "Total Cost: %.2f%n",
            totalCost
        ));

        System.out.print(output);
    }
}