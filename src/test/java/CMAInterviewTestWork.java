import com.arakelian.faker.service.RandomPerson;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CMAInterviewTestWork {
    // Interview test work 14.08.24
    // функция на вход список лист employee, дата
    // на выходе имя сотрудника который получил больше всех бонусов в заданном году

    public static void main(String[] args) {
        var employees = EmployeeFactory.generate();
        System.out.printf("Test data: \n%s", employees);
        System.out.println("\n$$$$$$$$$\n");
        Employee.mostBonuses(employees, 2010);
    }


    @Getter
    static class Employee {
        String employeeId;
        String employeeName;
        List<Bonus> bonuses;

        @Override
        public String toString() {
            return employeeName + "\n" + bonuses + "\n";
        }

        public Employee() {
            this.employeeId = String.valueOf(new Random().nextInt());
            this.employeeName = new RandomPerson().next().getFirstName();
            List<Bonus> bonuses = new ArrayList<>();
            for (int i = 0; i < new Random().nextInt(6) + 2; i++) {
                bonuses.add(new Bonus());
            }
            this.bonuses = bonuses;
        }

        @Getter
        static class Bonus {
            LocalDate date;
            BigDecimal amount;

            public Bonus() {
                this.date = LocalDate.of((new Random().nextInt(2) + 2009), 1, 1);
                this.amount = new BigDecimal(new Random().nextInt(100) + 1);
            }

            @Override
            public String toString() {
                return "Date: " + date + ", amount: " + amount + "\n";

            }
        }

        static void mostBonuses(List<Employee> employees, int year) {
            BigDecimal totalAmountBonus = BigDecimal.valueOf(0);
            BigDecimal currentAmount;
            String maxBonusEmployee = "";
            for (int i = 0; i < employees.size(); i++) {
                currentAmount = BigDecimal.valueOf(0);
                for (int j = 0; j < employees.get(i).getBonuses().size(); j++) {
                    if (employees.get(i).getBonuses().get(j)
                            .getDate().getYear() == year) {
                        currentAmount = currentAmount.add(employees.get(i).getBonuses().get(j).getAmount());
                        if (currentAmount.compareTo(totalAmountBonus) > 0) {
                            totalAmountBonus = currentAmount;
                            maxBonusEmployee = employees.get(i).getEmployeeName();
                        }
                    }
                }
            }
            System.out.printf("Best awarded employee: %s with total %d bonuses of %s", maxBonusEmployee, totalAmountBonus.intValue(), year);
        }
    }

    static class EmployeeFactory {
        public static List<Employee> generate() {
            return new ArrayList<>() {{
                add(new Employee());
                add(new Employee());
                add(new Employee());
                add(new Employee());
                add(new Employee());
            }};
        }
    }
}

