import java.util.*;

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double getTuition();

    double getTransportFee() {
        return 0;
    }

    double getFee() {
        return getTuition() + getTransportFee();
    }
}

interface BusUser {
    double TRANSPORT_FEE = 12000;

    double getTransportFee();
}

class DayScholar extends Student implements BusUser {

    DayScholar(String name) {
        super(name);
    }

    @Override
    double getTuition() {
        return 40000;
    }

    @Override
    public double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

class Hosteller extends Student {

    Hosteller(String name) {
        super(name);
    }

    @Override
    double getTuition() {
        return 40000 + 60000;
    }
}

class ScholarshipStudent extends Student implements BusUser {

    ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    double getTuition() {
        return 20000;
    }

    @Override
    public double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

public class Question3 {

    static Student createStudent(String type, String name) {
        switch (type) {
            case "DAY_SCHOLAR":
                return new DayScholar(name);
            case "HOSTELLER":
                return new Hosteller(name);
            case "SCHOLAR":
                return new ScholarshipStudent(name);
            default:
                throw new IllegalArgumentException("Invalid student type");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student = createStudent(type, name);

            double fee = student.getFee();
            total += fee;

            output.append(String.format(
                "%s: %.2f%n",
                name,
                fee
            ));
        }

        output.append(String.format(
            "Total Collected: %.2f%n",
            total
        ));

        System.out.print(output);
    }
}