package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * a class to represent salary employee.
 */
public class SalaryEmployee extends Employee {

    /**
     * constructor of SalaryEmployee
     *
     * @param name             name
     * @param iD               id
     * @param payRate          pay rate
     * @param yTDEarnings      year to date earning
     * @param yTDTaxesPaid     year to date tax
     * @param pretaxDeductions pre tax deduction
     */
    public SalaryEmployee(
            String name, String iD, double payRate, double yTDEarnings
            , double yTDTaxesPaid, double pretaxDeductions
    ) {
        super(name, iD, payRate, yTDEarnings, yTDTaxesPaid, pretaxDeductions);
        employeeType = "SALARY";
    }

    /**
     * run the payroll.
     *
     * @param hoursWorked the hours worked for the pay period
     * @return a payroll object
     */
    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) {
            return null;
        }

        double grossPay = calculateGrossPay(hoursWorked);

        BigDecimal bdGross = new BigDecimal(grossPay).setScale(2, RoundingMode.HALF_UP);

        double deductions = getPretaxDeductions();
        BigDecimal netPay = bdGross.subtract(new BigDecimal(deductions));

        BigDecimal taxes = netPay.multiply(new BigDecimal(0.2265));
        netPay = netPay.subtract(taxes);

        ytdEarnings = ytdEarnings.add(netPay).setScale(2, RoundingMode.HALF_UP);
        ytdTaxesPaid = ytdTaxesPaid.add(taxes).setScale(2, RoundingMode.HALF_UP);

        return new PayStub(
                name, netPay.doubleValue()
                , taxes.doubleValue()
                , ytdEarnings.doubleValue(),
                ytdTaxesPaid.doubleValue()
        );
    }

    public double calculateGrossPay(double hoursWorked) {
        return getPayRate() / 24;
    }
}

