import java.time.LocalDate;
import java.util.*;

interface Plan {
    LocalDate calculateRenewalDate();
    String getName();
}

class BasicPlan implements Plan {
    String name;
    LocalDate startDate;
    BasicPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }

    @Override
    public String getName() {
        return name;
    }
}

class StandardPlan implements Plan {
    String name;
    LocalDate startDate;
    StandardPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }

    @Override
    public String getName() {
        return name;
    }
}

class PremiumPlan implements Plan {
    String name;
    LocalDate startDate;
    PremiumPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }

    @Override
    public String getName() {
        return name;
    }
}

public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();
            LocalDate startDate = LocalDate.parse(date);
            Plan plan;
            if (type.equals("BASIC")) {
                plan = new BasicPlan(name, startDate);
            }
            else if (type.equals("STANDARD")) {
                plan = new StandardPlan(name, startDate);
            }
            else {
                plan = new PremiumPlan(name, startDate);
            }
            LocalDate renewalDate = plan.calculateRenewalDate();
            System.out.println(plan.getName() + ": " + renewalDate);
        }
        sc.close();
    }
}