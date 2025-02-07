package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourlyEmployeeTest {
    HourlyEmployee a1;
    double hoursWorked;

    @BeforeEach
    void setUp() {
        a1 = new HourlyEmployee("Luffy","s192",30.00, 20000,4530,0);
        hoursWorked = 50;
    }

    @Test
    void getName() {
        assertEquals("Luffy",a1.getName());
    }

    @Test
    void getID() {
        assertEquals("s192",a1.getID());
    }

    @Test
    void getPayRate() {
        assertEquals(30.00,a1.getPayRate());
    }

    @Test
    void getYTDEarnings() {
        assertEquals(20000,a1.getYTDEarnings());
    }

    @Test
    void getYTDTaxesPaid() {
        assertEquals(4530,a1.getYTDTaxesPaid());
    }

    @Test
    void getPretaxDeductions() {
        assertEquals(0,a1.getPretaxDeductions());
    }

    @Test
    void getEmployeeType() {
        assertEquals("HOURLY",a1.getEmployeeType());
    }

    @Test
    void runPayroll() {
        IPayStub payStub = a1.runPayroll(hoursWorked);
        assertNotNull(payStub);
        double eTotalpayment = (40 * 30) +(10 * 30 * 1.5);
        double eTaxableIncome = eTotalpayment-0;
        double eTax = eTaxableIncome*0.2265;
        double eNetPay = eTaxableIncome-eTax;
        PayStub ePayStub = new PayStub("Luffy", eNetPay,eTax,20000 + eTotalpayment,4530 + eTax);
        assertEquals(ePayStub.getPay(),payStub.getPay());
        assertEquals(ePayStub.getTaxesPaid(),payStub.getTaxesPaid());
    }

    @Test
    void toCSV() {
        assertEquals("HOURLY,Luffy,s192,30.00,0.00,20000.00,4530.00", a1.toCSV());
    }
}