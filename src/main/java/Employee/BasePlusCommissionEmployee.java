/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee;

/**
 *
 * @author admin
 */
class BasePlusCommissionEmployee extends Employee {
    private double baseSalary;
    private double commissionRate;
    private double grossSales;

    public BasePlusCommissionEmployee(int id, String name, double baseSalary, double commissionRate, double grossSales) {
        super(id, name);
        this.baseSalary = baseSalary;
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + (commissionRate * grossSales);
    }
}
