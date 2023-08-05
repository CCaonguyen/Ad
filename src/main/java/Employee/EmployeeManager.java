/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author admin
 */
class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.calculateSalary();
        }
        return totalSalary;
    }

    public void calculateSalariesForEachEmployee() {
        System.out.println("\nSalaries for each employee:");
        for (Employee employee : employees) {
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Employee Name: " + employee.getName());
            System.out.println("Salary: $" + employee.calculateSalary());
            System.out.println("------------------------");
        }
    }
     public Employee searchEmployee(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                return employee;
            }
        }
        return null; // Employee not found
        
     }
   public List<Employee> searchEmployeeByName(String employeeName) {
        List<Employee> matchingEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(employeeName)) {
                matchingEmployees.add(employee);
            }
        }
        return matchingEmployees;
    }

    public void deleteEmployee(int employeeId) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == employeeId) {
                iterator.remove();
                System.out.println("Employee with ID " + employeeId + " has been deleted.");
                return;
            }
        }
        System.out.println("Employee with ID " + employeeId + " not found.");
    }

    Employee searchEmployeeById(int employeeId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
