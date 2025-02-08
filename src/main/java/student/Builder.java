package student;

/**
 * This is a static class (essentially functions) that will help you build objects from CSV strings.
 * These objects are then used in the rest of the program. Often these builders are associated
 * with the objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public final class Builder {

    private Builder() {
    }


    /**
     * Builds an employee object from a CSV string.
     * <p>
     * You may end up checking the type of employee (hourly or salary) by looking at the first
     * element of the CSV string. Then building an object specific to that type.
     *
     * @param csv the CSV string
     * @return the employee object
     */
    public static IEmployee buildEmployeeFromCSV(String csv) {

        String[] data = csv.split(",");
        try {
            String type = data[0].trim();
            String name = data[1].trim();
            String id = data[2].trim();
            double payRate = Double.parseDouble(data[3].trim());
            double pretaxDeductions = Double.parseDouble(data[4].trim());
            double ytdEarnings = Double.parseDouble(data[5].trim());
            double ytdTaxesPaid = Double.parseDouble(data[6].trim());
            if (type.equals("HOURLY")) {
                return new HourlyEmployee(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
            } else if (type.equals("SALARY")) {
                return new SalaryEmployee(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
            } else {
                System.out.println("Invalid type");
            }
        } catch (Exception e) {
            System.out.println("Invalid data" + e.getMessage());
        }
        return null;
    }


    /**
     * Converts a TimeCard from a CSV String.
     *
     * @param csv csv string
     * @return a TimeCard object
     */
    public static ITimeCard buildTimeCardFromCSV(String csv) {
        String[] data = csv.split(",");
        try {
            String iD = data[0].trim();
            double hourWorked = Double.parseDouble(data[1].trim());
            return new TimeCard(iD, hourWorked);
        } catch (Exception e) {
            System.out.println("Invalid data" + e.getMessage());
        }
        return null;
    }
}
