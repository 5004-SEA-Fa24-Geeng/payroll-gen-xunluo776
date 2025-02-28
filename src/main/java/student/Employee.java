package student;

import java.math.BigDecimal;

/**
 * a abstract class to represent employee.
 */
public abstract class Employee implements IEmployee {
    /**
     * name.
     */
    private String name;
    /**
     * ID.
     */
    private String iD;
    /**
     * pay rate.
     */
    private double payRate;
    /**
     * deduction.
     */
    private double pretaxDeductions;
    /**
     * type.
     */
    private String employeeType;
    /**
     * earning.
     */
    private BigDecimal ytdEarnings;
    /**
     * tax.
     */
    private BigDecimal ytdTaxesPaid;


    /**
     * constructor of the Employee class.
     *
     * @param name             name of the employee
     * @param iD               ID of the employee
     * @param payRate          pay rate of the employee
     * @param ytdEarnings      year earning of the employee
     * @param ytdTaxesPaid     year tax paid of the employee
     * @param pretaxDeductions pre-tax deduction of the employee
     */
    public Employee(
            String name, String iD, double payRate,
            double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions
    ) {
        this.name = name;
        this.iD = iD;
        this.payRate = payRate;
        this.ytdEarnings = new BigDecimal(ytdEarnings);
        this.ytdTaxesPaid = new BigDecimal(ytdTaxesPaid);
        this.pretaxDeductions = pretaxDeductions;
    }

    /**
     * set employee type.
     * @param employeeType employee type
     */

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    /**
     * set YtdEarnings.
     * @param ytdEarnings YtdEarnings
     */

    public void setYtdEarnings(BigDecimal ytdEarnings) {
        this.ytdEarnings = ytdEarnings;
    }

    /**
     * set YtdTaxesPaid.
     * @param ytdTaxesPaid YtdTaxesPaid
     */

    public void setYtdTaxesPaid(BigDecimal ytdTaxesPaid) {
        this.ytdTaxesPaid = ytdTaxesPaid;
    }

    /**
     * Gets the employee's name.
     *
     * @return the name of the employee
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the employee's ID.
     *
     * @return the ID of the employee
     */
    @Override
    public String getID() {
        return iD;
    }

    /**
     * Gets the employee's pay rate.
     *
     * @return the pay rate of the employee
     */
    @Override
    public double getPayRate() {
        return payRate;
    }

    /**
     * Gets the YTD earnings of the employee.
     *
     * @return the YTD earnings of the employee
     */
    @Override
    public double getYTDEarnings() {
        return ytdEarnings.doubleValue();
    }

    /**
     * Gets the YTD taxes paid by the employee.
     *
     * @return the YTD taxes paid by the employee
     */
    @Override
    public double getYTDTaxesPaid() {
        return ytdTaxesPaid.doubleValue();
    }

    /**
     * return PretaxDeductions.
     *
     * @return the pretax deductions for the employee
     */
    @Override
    public double getPretaxDeductions() {
        return pretaxDeductions;
    }

    /**
     * return employee type.
     *
     * @return the type of the employee as a string
     */
    @Override
    public String getEmployeeType() {
        return employeeType;
    }

    /**
     * Runs the employee's payroll.
     * <p>
     * This will calculate the pay for the current pay, update the YTD earnings, and update the
     * taxes paid YTD.
     * <p>
     * taxes are calculated as 1.45% for medicare, 6.2% for social security, and 15% for
     * withholding. or 22.65% total. They are calculated on the net pay (after pretax deductions).
     * <p>
     * For hourly employees, the pay is calculated as payRate * hoursWorked for the first 40 hours,
     * then payRate * 1.5 * (hoursWorked - 40) for overtime.
     * <p>
     * For salary employees, it is pay rate divided by 24 for two payments every month.
     * <p>
     * If either type of employee has < 0 hours, they are skipped this payroll period.
     * (suggestion return null, and skip adding nulls to your paystub list)
     * <p>
     * Final net pay is calculated as pay - pretaxDeductions - taxes.
     * <p>
     * All numbers (across all methods) are rounded to the nearest cent. (2 decimal places)
     * <p>
     * SUGGESTION: You may want to use BigDecimal for the calculations to avoid floating point errors.
     * SUGGESTION: You may want to create an protected abstract calculateGrossPay(double hoursWorked)
     * method to calculate the gross pay for the pay period, as runPayroll is exactly
     * the same for both SalaryEmployee and HourlyEmployee, but calculateGrossPay is different.
     *
     * @param hoursWorked the hours worked for the pay period
     * @return the pay stub for the current pay period
     */
    @Override
    public abstract IPayStub runPayroll(double hoursWorked);

    /**
     * Converts the employee to a CSV string.
     * <p>
     * Format of the String s as follows:
     * <p>
     * employee_type,name,ID,payRate,pretaxDeductions,YTDEarnings,YTDTaxesPaid
     * <p>
     * employee_type has the options for HOURLY or SALARY.
     * <p>
     * You do not have to worry about commas in the name or any other field.
     *
     * @return the employee as a CSV string
     */
    @Override
    public String toCSV() {
        return String.format(
                "%s,%s,%s,%.2f,%.2f,%.2f,%.2f",
                employeeType, name, iD, payRate,
                pretaxDeductions, ytdEarnings, ytdTaxesPaid
        );
    }

}
