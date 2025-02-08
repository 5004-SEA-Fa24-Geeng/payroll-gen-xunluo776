package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class HourlyEmployeeTest {
    HourlyEmployee a1;
    double hoursWorked;

    @BeforeEach
    void setUp() {
        a1 = new HourlyEmployee("Luffy", "s192", 30.00, 20000, 4530, 0);
        hoursWorked = 45;
    }

    @Test
    void setEmployeeType(){
        a1.setEmployeeType("SALARY");
        assertEquals("SALARY", a1.getEmployeeType());
    }
    @Test
     void setYtdEarnings(){
        a1.setYtdEarnings(new BigDecimal(0));
        assertEquals(0, a1.getYTDEarnings());
    }

    @Test
    void setYtdTaxesPaid(){
        a1.setYtdTaxesPaid(new BigDecimal(0));
        assertEquals(0, a1.getYTDTaxesPaid());
    }

    @Test
    void testConstructor() {
        assertEquals("Luffy", a1.getName());
        assertEquals("s192", a1.getID());
        assertEquals(30.00, a1.getPayRate());
        assertEquals(20000, a1.getYTDEarnings());
        assertEquals(4530, a1.getYTDTaxesPaid());
        assertEquals(0, a1.getPretaxDeductions());
        assertEquals("HOURLY", a1.getEmployeeType());
    }

    @Test
    void getName() {
        assertEquals("Luffy", a1.getName());
    }

    @Test
    void getID() {
        assertEquals("s192", a1.getID());
    }

    @Test
    void getPayRate() {
        assertEquals(30.00, a1.getPayRate());
    }

    @Test
    void getYTDEarnings() {
        assertEquals(20000, a1.getYTDEarnings());
    }

    @Test
    void getYTDTaxesPaid() {
        assertEquals(4530, a1.getYTDTaxesPaid());
    }

    @Test
    void getPretaxDeductions() {
        assertEquals(0, a1.getPretaxDeductions());
    }

    @Test
    void getEmployeeType() {
        assertEquals("HOURLY", a1.getEmployeeType());
    }

    @Test
    void runPayroll() {
        PayStub payStub = (PayStub) a1.runPayroll(hoursWorked);
        System.out.println(payStub.getPay());
        assertEquals(1102.24, payStub.getPay(), 0.01);
        assertEquals(322.76, payStub.getTaxesPaid(), 0.01);
        assertEquals(21102.24, payStub.getYtdEarnings(), 0.01);
        assertEquals(4852.76, payStub.getYtdTaxesPaid(), 0.01);
    }

    @Test
    void toCSV() {
        assertEquals("HOURLY,Luffy,s192,30.00,0.00,20000.00,4530.00", a1.toCSV());
    }
}