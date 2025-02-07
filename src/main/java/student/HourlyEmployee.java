package student;

/**
 * a class to represent hourly employee.
 */
public class HourlyEmployee extends Employee {
    private final static int WORKHOURS = 40;
    private final static double taxRate = 0.2265;
    public HourlyEmployee(String name, String ID, double payRate, double YTDEarnings, double YTDTaxesPaid, double pretaxDeductions) {
        super(name, ID,payRate,YTDEarnings, YTDTaxesPaid,pretaxDeductions);
        employeeType = "HOURLY";
    }

    /**
     * run the payroll.
     * @param hoursWorked the hours worked for the pay period
     * @return a payroll object
     */
    @Override
    public IPayStub runPayroll(double hoursWorked) {

        if (hoursWorked < 0) {
            return null;
        }
        double totalPayment;
        if (hoursWorked > WORKHOURS) {
            double overtime = hoursWorked - WORKHOURS;
            totalPayment = (WORKHOURS * payRate) + (overtime * payRate * 1.5);
        } else {
            totalPayment = hoursWorked * payRate;
        }

        double taxable = totalPayment - pretaxDeductions;
        double tax = taxable * taxRate;
        double netPay = taxable - tax;
        this.YTDTaxesPaid += tax;
        this.YTDEarnings += totalPayment;
        return new PayStub(name, netPay, tax, YTDEarnings, YTDTaxesPaid);
    }
}
