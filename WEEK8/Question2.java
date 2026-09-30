import java.util.*;

interface Vehicle {
    double calculateCharge();
    String getType();
}

class Bike implements Vehicle {
    int hours;
    Bike(int hours) {
        this.hours = hours;
    }
    @Override
    public double calculateCharge() {
        return 10 * hours;
    }
    @Override
    public String getType() {
        return "BIKE";
    }
}

class Car implements Vehicle {
    int hours;
    Car(int hours) {
        this.hours = hours;
    }
    @Override
    public double calculateCharge() {
        if (hours == 1) {
            return 30;
        }
        return 30 + 20 * (hours - 1);
    }
    @Override
    public String getType() {
        return "CAR";
    }
}

class Truck implements Vehicle {
    int hours;
    Truck(int hours) {
        this.hours = hours;
    }

    @Override
    public double calculateCharge() {
        double charge = 50 * hours;
        return Math.max(charge, 100);
    }

    @Override
    public String getType() {
        return "TRUCK";
    }
}

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            Vehicle vehicle;
            if (type.equals("BIKE")) {
                vehicle = new Bike(hours);
            }
            else if (type.equals("CAR")) {
                vehicle = new Car(hours);
            }
            else {
                vehicle = new Truck(hours);
            }
            double charge = vehicle.calculateCharge();
            System.out.printf("%s: %.2f%n", vehicle.getType(), charge);
            total += charge;
        }
        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}