import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected String employeeId;
    protected double baseSalary;

    // Define constants for tax and bonus rates
    public static final double TAX_RATE = 0.15;
    public static final double PERFORMANCE_BONUS_RATE = 0.10;

    public Employee(String name, String employeeId, double baseSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
    }

    // Method to calculate the salary (to be overridden by subclasses)
    public abstract double calculateSalary();

    // Method to generate payslip
    public void generatePayslip() {
        System.out.println("\nPayslip for Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Total Salary (after tax): $" + calculateSalary());
    }
}

class FullTimeEmployee extends Employee {
    private double overtimeHours;
    private double overtimeRate;

    public FullTimeEmployee(String name, String employeeId, double baseSalary, double overtimeHours, double overtimeRate) {
        super(name, employeeId, baseSalary);
        this.overtimeHours = overtimeHours;
        this.overtimeRate = overtimeRate;
    }

    @Override
    public double calculateSalary() {
        double grossSalary = baseSalary + (overtimeHours * overtimeRate);
        double tax = grossSalary * TAX_RATE;
        return grossSalary - tax;
    }
}

class PartTimeEmployee extends Employee {
    private double hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, String employeeId, double hourlyRate, double hoursWorked) {
        super(name, employeeId, 0); // Part-time employees may not have a base salary
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        double grossSalary = hoursWorked * hourlyRate;
        double tax = grossSalary * TAX_RATE;
        return grossSalary - tax;
    }
}

class ContractEmployee extends Employee {
    private double contractPay;
    private boolean performanceBonus;

    public ContractEmployee(String name, String employeeId, double contractPay, boolean performanceBonus) {
        super(name, employeeId, contractPay);
        this.contractPay = contractPay;
        this.performanceBonus = performanceBonus;
    }

    @Override
    public double calculateSalary() {
        double bonus = performanceBonus ? contractPay * PERFORMANCE_BONUS_RATE : 0;
        double grossSalary = contractPay + bonus;
        double tax = grossSalary * TAX_RATE;
        return grossSalary - tax;
    }
}

public class EmployeePayrollSystem {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Loop to process multiple employees
        while (true) {
            System.out.println("\nEmployee Payroll System");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Add Contract Employee");
            System.out.println("4. Generate Payslips");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 5) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();
            System.out.print("Enter employee ID: ");
            String employeeId = scanner.nextLine();

            switch (choice) {
                case 1: // Full-Time Employee
                    System.out.print("Enter base salary: ");
                    double baseSalary = scanner.nextDouble();
                    System.out.print("Enter overtime hours: ");
                    double overtimeHours = scanner.nextDouble();
                    System.out.print("Enter overtime rate: ");
                    double overtimeRate = scanner.nextDouble();
                    employees.add(new FullTimeEmployee(name, employeeId, baseSalary, overtimeHours, overtimeRate));
                    System.out.println("Full-Time Employee added.");
                    break;

                case 2: // Part-Time Employee
                    System.out.print("Enter hourly rate: ");
                    double hourlyRate = scanner.nextDouble();
                    System.out.print("Enter hours worked: ");
                    double hoursWorked = scanner.nextDouble();
                    employees.add(new PartTimeEmployee(name, employeeId, hourlyRate, hoursWorked));
                    System.out.println("Part-Time Employee added.");
                    break;

                case 3: // Contract Employee
                    System.out.print("Enter contract pay: ");
                    double contractPay = scanner.nextDouble();
                    System.out.print("Is there a performance bonus? (true/false): ");
                    boolean performanceBonus = scanner.nextBoolean();
                    employees.add(new ContractEmployee(name, employeeId, contractPay, performanceBonus));
                    System.out.println("Contract Employee added.");
                    break;

                case 4: // Generate Payslips for all employees
                    System.out.println("\nGenerating payslips for all employees...");
                    for (Employee emp : employees) {
                        emp.generatePayslip();
                    }
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}