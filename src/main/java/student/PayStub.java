package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * a class representing pays tub
 */
public class PayStub implements IPayStub {
    private String name;
    private double netPay;
    private double taxesPaid;
    private double ytdEarnings;
    private double ytdTaxesPaid;

    /**
     * constructor of Paystub.
     *
     * @param name         name of the employee
     * @param netPay       net pay of the employee
     * @param taxesPaid    taxes paid of the employee
     * @param ytdEarnings  year to date earnings of the employee
     * @param ytdTaxesPaid year to date tax of the employee
     */
    public PayStub(String name, double netPay, double taxesPaid, double ytdEarnings, double ytdTaxesPaid) {
        this.name = name;
        this.netPay = netPay;
        this.taxesPaid = taxesPaid;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
    }

    /**
     * get the net pay.
     *
     * @return netpay in double
     */
    @Override
    public double getPay() {
        return netPay;
    }

    /**
     * get taxes paid.
     *
     * @return taxes Paid in double
     */
    @Override
    public double getTaxesPaid() {
        return taxesPaid;
    }

    /**
     * get Ytd earning.
     *
     * @return ytd earnings in double
     */
    public double getYtdEarnings() {
        return ytdEarnings;
    }

    /**
     * get Ytd tax.
     *
     * @return ytd tax in double
     */
    public double getYtdTaxesPaid() {
        return ytdTaxesPaid;
    }

    /**
     * get csv string .
     *
     * @return CSV format in String
     */
    @Override
    public String toCSV() {
        return String.format("%s,%.2f,%.2f,%.2f,%.2f", name,
                new BigDecimal(netPay).setScale(2, RoundingMode.HALF_UP).doubleValue(),
                new BigDecimal(taxesPaid).setScale(2, RoundingMode.HALF_UP).doubleValue(),
                new BigDecimal(ytdEarnings).setScale(2, RoundingMode.HALF_UP).doubleValue(),
                new BigDecimal(ytdTaxesPaid).setScale(2, RoundingMode.HALF_UP).doubleValue());
    }


}
