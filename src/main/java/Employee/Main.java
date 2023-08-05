/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Employee;
import java.util.List;
import java.util.Scanner;












public class Main {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Salaried Employee");
            System.out.println("2. Add Commission Employee");
            System.out.println("3. Add Base Plus Commission Employee");
            System.out.println("4. Add Hourly Employee");
            System.out.println("5. Calculate Salaries");
            System.out.println("6. Calculate Salaries for each employee");
            System.out.println("7. Display Employee Details");
            System.out.println("8. Display salary for each employee");
            System.out.println("9. Search Employee");
            System.out.println("10. Delete Employee");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addSalariedEmployee(employeeManager, scanner);
                    break;
                case 2:
                    addCommissionEmployee(employeeManager, scanner);
                    break;
                case 3:
                    addBasePlusCommissionEmployee(employeeManager, scanner);
                    break;
                case 4:
                    addHourlyEmployee(employeeManager, scanner);
                    break;
                case 5:
                    calculateTotalSalaries(employeeManager);
                    break;
                case 6:
                    employeeManager.calculateSalariesForEachEmployee();
                    break;
                case 7:
                    displayEmployeeDetails(employeeManager);
                    break;
                case 8:
                    displaySalaryForEachEmployee(employeeManager);
                    break;
                     case 9:
                    searchEmployee(employeeManager, scanner);
                    break;
                case 10:
                    deleteEmployee(employeeManager, scanner);
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close(); // Close the scanner after use
    }

    private static void addSalariedEmployee(EmployeeManager employeeManager, Scanner scanner) {
        System.out.println("\nEnter ID for Salaried Employee:");
        int salariedId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.println("Enter Name for Salaried Employee:");
        String salariedName = scanner.nextLine();
        System.out.println("Enter Monthly Salary for Salaried Employee:");
        double monthlySalary = scanner.nextDouble();
        employeeManager.addEmployee(new SalariedEmployee(salariedId, salariedName, monthlySalary));
    }


    private static void addCommissionEmployee(EmployeeManager employeeManager, Scanner scanner) {
        System.out.println("\nEnter ID for Commission Employee:");
        int commissionId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.println("Enter Name for Commission Employee:");
        String commissionName = scanner.nextLine();
        System.out.println("Enter Commission Rate for Commission Employee:");
        double commissionRate = scanner.nextDouble();
        System.out.println("Enter Gross Sales for Commission Employee:");
        double grossSales = scanner.nextDouble();
        employeeManager.addEmployee(new CommissionEmployee(commissionId, commissionName, commissionRate, grossSales));
    }

    private static void addBasePlusCommissionEmployee(EmployeeManager employeeManager, Scanner scanner) {
        System.out.println("\nEnter ID for Base Plus Commission Employee:");
        int basePlusCommissionId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.println("Enter Name for Base Plus Commission Employee:");
        String basePlusCommissionName = scanner.nextLine();
        System.out.println("Enter Base Salary for Base Plus Commission Employee:");
        double baseSalary = scanner.nextDouble();
        System.out.println("Enter Commission Rate for Base Plus Commission Employee:");
        double basePlusCommissionRate = scanner.nextDouble();
        System.out.println("Enter Gross Sales for Base Plus Commission Employee:");
        double basePlusGrossSales = scanner.nextDouble();
        employeeManager.addEmployee(new BasePlusCommissionEmployee(basePlusCommissionId, basePlusCommissionName, baseSalary, basePlusCommissionRate, basePlusGrossSales));
    }

    private static void addHourlyEmployee(EmployeeManager employeeManager, Scanner scanner) {
        System.out.println("\nEnter ID for Hourly Employee:");
        int hourlyId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.println("Enter Name for Hourly Employee:");
        String hourlyName = scanner.nextLine();
        System.out.println("Enter Hourly Rate for Hourly Employee:");
        double hourlyRate = scanner.nextDouble();
        System.out.println("Enter Hours Worked for Hourly Employee:");
        double hoursWorked = scanner.nextDouble();
        employeeManager.addEmployee(new HourlyEmployee(hourlyId, hourlyName, hourlyRate, hoursWorked));
    }
    private static void searchEmployee(EmployeeManager employeeManager, Scanner scanner) {
        System.out.println("Select search method:");
        System.out.println("1. Search by Employee ID");
        System.out.println("2. Search by Employee Name");
        int searchChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (searchChoice) {
            case 1:
                searchEmployeeById(employeeManager, scanner);
                break;
            case 2:
                searchEmployeeByName(employeeManager, scanner);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
     private static void searchEmployeeById(EmployeeManager employeeManager, Scanner scanner) {
        System.out.println("\nEnter ID of the Employee to search:");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Employee employee = employeeManager.searchEmployeeById(employeeId);
        if (employee != null) {
            System.out.println("Employee found:");
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Employee Name: " + employee.getName());
            System.out.println("Salary: $" + employee.calculateSalary());
        } else {
            System.out.println("Employee with ID " + employeeId + " not found.");
        }
    }

    private static void searchEmployeeByName(EmployeeManager employeeManager, Scanner scanner) {
        System.out.println("\nEnter Name of the Employee to search:");
        String employeeName = scanner.nextLine();

        List<Employee> matchingEmployees = employeeManager.searchEmployeeByName(employeeName);
        if (!matchingEmployees.isEmpty()) {
            System.out.println("Matching Employees found:");
            for (Employee employee : matchingEmployees) {
                System.out.println("Employee ID: " + employee.getId());
                System.out.println("Employee Name: " + employee.getName());
                System.out.println("Salary: $" + employee.calculateSalary());
                System.out.println("------------------------");
            }
        } else {
            System.out.println("No employees with the name '" + employeeName + "' found.");
        }
    }
    private static void deleteEmployee(EmployeeManager employeeManager, Scanner scanner) {
        System.out.println("\nEnter ID of the Employee to delete:");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        employeeManager.deleteEmployee(employeeId);}
     

    private static void calculateTotalSalaries(EmployeeManager employeeManager) {
        double totalSalary = employeeManager.calculateTotalSalary();
        System.out.println("Total salary for all employees: $" + totalSalary);
    }

    private static void displayEmployeeDetails(EmployeeManager employeeManager) {
        List<Employee> employees = employeeManager.getEmployees();
        System.out.println("\nEmployee Details:");
        for (Employee employee : employees) {
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Employee Name: " + employee.getName());
            System.out.println("------------------------");
        }
    }

    private static void displaySalaryForEachEmployee(EmployeeManager employeeManager) {
        employeeManager.calculateSalariesForEachEmployee();
    }
}
