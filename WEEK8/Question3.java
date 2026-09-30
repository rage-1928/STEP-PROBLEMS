import java.util.*;

interface Room {
    double calculateBill();
    String getType();
}

class SingleRoom implements Room {
    int units;
    SingleRoom(int units) {
        this.units = units;
    }
    @Override
    public double calculateBill() {
        return units * 8;
    }
    @Override
    public String getType() {
        return "SINGLE";
    }
}

class SharedRoom implements Room {
    int units;
    int occupants;
    SharedRoom(int units, int occupants) {
        this.units = units;
        this.occupants = occupants;
    }
    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }
    @Override
    public String getType() {
        return "SHARED";
    }
}

class ACRoom implements Room {
    int units;
    ACRoom(int units) {
        this.units = units;
    }

    @Override
    public double calculateBill() {
        return units * 10 + 200;
    }

    @Override
    public String getType() {
        return "AC";
    }
}

public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            Room room;
            if (type.equals("SINGLE")) {
                int units = sc.nextInt();
                room = new SingleRoom(units);
            }
            else if (type.equals("SHARED")) {
                int units = sc.nextInt();
                int occupants = sc.nextInt();
                room = new SharedRoom(units, occupants);
            }
            else {
                int units = sc.nextInt();
                room = new ACRoom(units);
            }
            double bill = room.calculateBill();
            System.out.printf("%s: %.2f%n", room.getType(), bill);
            total += bill;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}