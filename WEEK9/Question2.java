import java.util.*;

abstract class Parcel {
    double weight;
    double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double getCharge();

    double getInsurance() {
        return 0;
    }

    double getTotal() {
        return getCharge() + getInsurance();
    }
}

interface Insurable {
    double INSURANCE_RATE = 0.02;

    double getInsurance();
}

class StandardParcel extends Parcel {

    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    double getCharge() {
        return 40 + 10 * weight;
    }
}

class ExpressParcel extends Parcel implements Insurable {

    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    double getCharge() {
        return 80 + 15 * weight;
    }

    @Override
    public double getInsurance() {
        return declaredValue * INSURANCE_RATE;
    }
}

class FragileParcel extends Parcel implements Insurable {

    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    double getCharge() {
        return 40 + 10 * weight + 50;
    }

    @Override
    public double getInsurance() {
        return declaredValue * INSURANCE_RATE;
    }
}

public class Question2 {

    static Parcel createParcel(
        String type,
        double weight,
        double declaredValue
    ) {
        switch (type) {
            case "STANDARD":
                return new StandardParcel(weight, declaredValue);
            case "EXPRESS":
                return new ExpressParcel(weight, declaredValue);
            case "FRAGILE":
                return new FragileParcel(weight, declaredValue);
            default:
                throw new IllegalArgumentException("Invalid parcel type");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            Parcel parcel = createParcel(
                type,
                weight,
                declaredValue
            );

            double charge = parcel.getCharge();
            double insurance = parcel.getInsurance();
            double total = parcel.getTotal();

            grandTotal += total;

            output.append(String.format(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type,
                charge,
                insurance,
                total
            ));
        }

        output.append(String.format(
            "Grand Total: %.2f%n",
            grandTotal
        ));

        System.out.print(output);
    }
}