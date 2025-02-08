package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * a class to represent hourly employee.
 */
public class HourlyEmployee extends Employee {

    /**
     * tax rate.
     */
    private final double taxRate = 0.2265;

    /**
     * constructor of HourlyEmployee.
     *
     * @param name             name of the employee
     * @param iD               id of the employee
     * @param payRate          pay rate id of the employee
     * @param ytdEarnings
     * @param ytdTaxesPaid
     * @param pretaxDeductions
     */
    public HourlyEmployee(
            String name, String iD, double payRate,
            double ytdEarnings, double ytdTaxesPaid,
            double pretaxDeductions
    ) {
        super(name, iD, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
        this.setEmployeeType("HOURLY");
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
        if (hoursWorked > 40) {
            double overtime = hoursWorked - 40;
            grossPay = (40 * this.getPayRate()) + (overtime * this.getPayRate() * 1.5);
        } else {
            grossPay = hoursWorked *this.getPayRate();
        }
        BigDecimal bdGross = new BigDecimal(grossPay).setScale(2, RoundingMode.HALF_UP);
        BigDecimal netPay = bdGross.subtract(new BigDecimal(this.getPretaxDeductions()));
        BigDecimal taxes = netPay.multiply(new BigDecimal(taxRate));
        netPay = netPay.subtract(taxes);
        setYtdEarnings(new BigDecimal(getYTDEarnings()).add(netPay).setScale(2, RoundingMode.HALF_UP));
        setYtdTaxesPaid(new BigDecimal(getYTDTaxesPaid()).add(taxes).setScale(2, RoundingMode.HALF_UP));
        return new PayStub(
                this.getName(), netPay.doubleValue(), taxes.doubleValue(),
                getYTDEarnings(), getYTDTaxesPaid()
        );

    }
}
