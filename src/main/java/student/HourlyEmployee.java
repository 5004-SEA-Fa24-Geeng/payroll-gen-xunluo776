package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * a class to represent hourly employee.
 */
public class HourlyEmployee extends Employee {
    private final static int WORKHOURS = 40;
    private final static double taxRate = 0.2265;

    /**
     * constructor of HourlyEmployee
     *
     * @param name             name of the employee
     * @param ID               id of the employee
     * @param payRate          pay rate id of the employee
     * @param YTDEarnings
     * @param YTDTaxesPaid
     * @param pretaxDeductions
     */
    public HourlyEmployee(String name, String ID, double payRate, double YTDEarnings, double YTDTaxesPaid, double pretaxDeductions) {
        super(name, ID, payRate, YTDEarnings, YTDTaxesPaid, pretaxDeductions);
        employeeType = "HOURLY";
    }

    /**
     * run the payroll.
     *
     * @param hoursWorked the hours worked for the pay period
     * @return a pay stub object
     */
    @Override
    public IPayStub runPayroll(double hoursWorked) {

        if (hoursWorked < 0) {
            return null;
        }
        double grossPay;
        if (hoursWorked > WORKHOURS) {
            double overtime = hoursWorked - WORKHOURS;
            grossPay = (WORKHOURS * payRate) + (overtime * payRate * 1.5);
        } else {
            grossPay = hoursWorked * payRate;
        }
        BigDecimal bdGross = new BigDecimal(grossPay).setScale(2, RoundingMode.HALF_UP);
        BigDecimal netPay = bdGross.subtract(new BigDecimal(this.pretaxDeductions));
        BigDecimal taxes = netPay.multiply(new BigDecimal(taxRate));
        netPay = netPay.subtract(taxes);
        YTDEarnings = YTDEarnings.add(netPay).setScale(2, RoundingMode.HALF_UP);
        YTDTaxesPaid = YTDTaxesPaid.add(taxes).setScale(2, RoundingMode.HALF_UP);
        return new PayStub(name, netPay.doubleValue(), taxes.doubleValue(), YTDEarnings.doubleValue(), YTDTaxesPaid.doubleValue());
//        double taxable = totalPayment - pretaxDeductions;
//        double tax = taxable * taxRate;
//        double netPay = taxable - tax;
//        this.YTDTaxesPaid += tax;
//        this.YTDEarnings += netPay;
//        return new PayStub(name, netPay, tax, YTDEarnings, YTDTaxesPaid);

    }
}
