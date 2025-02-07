package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryEmployeeTest {
    SalaryEmployee a1;
    double hoursWorked;
    @BeforeEach
    void setUp() {
        a1 = new SalaryEmployee("Nami","s193",200000, 17017,4983,1000);
        hoursWorked = 50;
    }
    @Test
    void runPayroll() {
        IPayStub payStub = a1.runPayroll(hoursWorked);
        double eGrossPay = 200000 / 24.0;
        double eTaxableIncome = eGrossPay - 1000;
        double eTax = eTaxableIncome * 0.2265;
        double eNetPay = eTaxableIncome - eTax;
        PayStub ePayStub = new PayStub("Nami", eNetPay, eTax, 17017 + eGrossPay, 4983 + eTax);
        assertEquals(ePayStub.getPay(), payStub.getPay());
        assertEquals(ePayStub.getTaxesPaid(), payStub.getTaxesPaid());

    }

}