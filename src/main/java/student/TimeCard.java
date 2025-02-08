package student;

public class TimeCard implements ITimeCard {
    private final String employeeId;
    private final double hourWorked;

    /**
     * constructor for the TimeCard class.
     *
     * @param employeeId ID of the employee
     * @param hourWorked hour worked of employee
     */
    public TimeCard(String employeeId, double hourWorked) {
        this.employeeId = employeeId;
        this.hourWorked = hourWorked;
    }

    /**
     * return employee ID
     *
     * @return EmployeeID as a String
     */
    @Override
    public String getEmployeeID() {
        return employeeId;
    }

    /**
     * return hour worked
     *
     * @return hourWorked as a double
     */
    @Override
    public double getHoursWorked() {
        return hourWorked;
    }
}
