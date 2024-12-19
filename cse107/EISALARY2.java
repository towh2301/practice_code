import java.util.*;

public class EISALARY2 {
    static Scanner reader = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int nEmp = reader.nextInt();
        countSalary(nEmp);
        System.out.println(sb);
    }

    public static void countSalary(int nEmp) {
        double overtime, office;
        double overWage = 0;
        double officeWage = 0;
        double totalOffice = 0;
        double totalOver = 0;
        for (var i = 0; i < nEmp; i++) {
            overtime = 0;
            office = 0;
            for (var j = 0; j < 5; j++) {
                double time = reader.nextDouble();
                overtime += (time - 8 > 0) ? time - 8 : 0;
                office += (time - 8 > 0) ? 8 : time;
            }
            double wagePerHour = reader.nextDouble();
            double wage = office * wagePerHour + overtime * 1.5 * wagePerHour;
            officeWage += (office * wagePerHour);
            overWage += (overtime * 1.5 * wagePerHour);
            totalOffice += office;
            totalOver += overtime;
            sb.append(String.format("%.2f", wage)).append("\n");
        }
        totalOffice = (totalOffice != 0) ? officeWage / totalOffice : 0.0;
        totalOver = (totalOver != 0) ? overWage / totalOver : 0.0;
        sb.append(String.format("%.2f", totalOffice)).append("\n");
        sb.append(String.format("%.2f", totalOver)).append("\n");
    }
}
