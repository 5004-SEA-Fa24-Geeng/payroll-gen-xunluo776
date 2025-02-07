package student;

/**
 * a class to represent salary employee.
 */
public class SalaryEmployee extends Employee {
    private final static int MONTHS = 24;
    private final static double taxRate = 0.2265;
    public SalaryEmployee(String name, String ID, double payRate, double YTDEarnings, double YTDTaxesPaid, double pretaxDeductions) {
        super(name, ID,payRate,YTDEarnings, YTDTaxesPaid,pretaxDeductions);
        employeeType = "SALARY";
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
        double totalPayment = payRate / MONTHS;
        double taxableIncome = totalPayment - pretaxDeductions;
        double tax = taxableIncome * taxRate;
        double netPay = taxableIncome - tax;
        this.YTDEarnings += netPay;
        this.YTDTaxesPaid += tax;
        return new PayStub(name, netPay, tax, YTDEarnings, YTDTaxesPaid);

    }
}

