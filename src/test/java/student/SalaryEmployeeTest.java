package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SalaryEmployeeTest {
    SalaryEmployee a1;
    double hoursWorked;

    @BeforeEach
    void setUp() {
        a1 = new SalaryEmployee("Nami", "s193", 200000, 17017, 4983, 1000);
        hoursWorked = 60;
    }

    @Test
    void testConstructor() {
        assertEquals("Nami", a1.getName());
        assertEquals("s193", a1.getID());
        assertEquals(200000, a1.getPayRate());
        assertEquals(17017, a1.getYTDEarnings());
        assertEquals(4983, a1.getYTDTaxesPaid());
        assertEquals(1000, a1.getPretaxDeductions());
        assertEquals("SALARY", a1.getEmployeeType());
    }

    @Test
    void setEmployeeType(){
        a1.setEmployeeType("HOURLY");
        assertEquals("HOURLY", a1.getEmployeeType());
    }
    @Test
    void setYtdEarnings(){
        a1.setYtdEarnings(new BigDecimal(0));
        assertEquals(0, a1.getYTDEarnings());
    }

    @Test
    void setYtdTaxesPaid() {
        a1.setYtdTaxesPaid(new BigDecimal(0));
        assertEquals(0, a1.getYTDTaxesPaid());
    }

    @Test
    void getName() {
        assertEquals("Nami", a1.getName());
    }

    @Test
    void getID() {
        assertEquals("s193", a1.getID());
    }

    @Test
    void getPayRate() {
        assertEquals(200000, a1.getPayRate());
    }

    @Test
    void getYTDEarnings() {
        assertEquals(17017, a1.getYTDEarnings());
    }

    @Test
    void getYTDTaxesPaid() {
        assertEquals(4983, a1.getYTDTaxesPaid());
    }

    @Test
    void getPretaxDeductions() {
        assertEquals(1000, a1.getPretaxDeductions());
    }

    @Test
    void getEmployeeType() {
        assertEquals("SALARY", a1.getEmployeeType());
    }

    @Test
    void runPayroll() {
        PayStub payStub = (PayStub) a1.runPayroll(hoursWorked);
        assertEquals(5672.33, payStub.getPay(), 0.01);
        assertEquals(1661.00, payStub.getTaxesPaid(), 0.01);
        assertEquals(22689.33, payStub.getYtdEarnings(), 0.01);

    }

    @Test
    void toCSV() {
        assertEquals("SALARY,Nami,s193,200000.00,1000.00,17017.00,4983.00", a1.toCSV());
    }

}