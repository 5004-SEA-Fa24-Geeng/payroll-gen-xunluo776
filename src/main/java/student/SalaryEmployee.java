package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * a class to represent salary employee.
 */
public class SalaryEmployee extends Employee {
    /**
     * tax rate
     */
    private final double TAXRATE = 0.2265;

    public SalaryEmployee(
            String name, String ID, double payRate, double YTDEarnings
            , double YTDTaxesPaid, double pretaxDeductions
    ) {
        super(name, ID, payRate, YTDEarnings, YTDTaxesPaid, pretaxDeductions);
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

        BigDecimal taxes = netPay.multiply(new BigDecimal(TAXRATE));
        netPay = netPay.subtract(taxes);

        ytdEarnings = ytdEarnings.add(netPay).setScale(2, RoundingMode.HALF_UP);
        ytdTaxesPaid = ytdTaxesPaid.add(taxes).setScale(2, RoundingMode.HALF_UP);

        return new PayStub(name, netPay.doubleValue(), taxes.doubleValue(), ytdEarnings.doubleValue(), ytdTaxesPaid.doubleValue());
    }

    public double calculateGrossPay(double hoursWorked) {
        return getPayRate() / 24;
    }
}

