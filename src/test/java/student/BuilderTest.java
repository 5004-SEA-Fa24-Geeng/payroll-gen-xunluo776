package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {
    String csv;
    String wrongCsv;
    String tc;
    String wrongTc;

    @BeforeEach
    void setUp() {
        csv = "HOURLY,Luffy,s192,30.00,0,20000,4530";
        wrongCsv = "h,Luffy,s192,30.00,0.00,20000.00,4530.00";
        tc = "s192,45";
        wrongTc = "s192,invalid";
    }

    @Test
    void buildEmployeeFromCSV() {
        IEmployee expected = new HourlyEmployee("Luffy", "s192", 30.00, 20000, 4530, 0);
        IEmployee actual = Builder.buildEmployeeFromCSV(csv);
        assertEquals(expected.toCSV(), actual.toCSV());
    }

    @Test
    void invalidBuildEmployeeFromCSV() {
        IEmployee actual = Builder.buildEmployeeFromCSV(wrongCsv);
        assertNull(actual);
    }

    @Test
    void buildTimeCardFromCSV() {
        ITimeCard expected = new TimeCard("s192", 45.0);
        ITimeCard actual = Builder.buildTimeCardFromCSV(tc);
        assertEquals(expected.getEmployeeID(), actual.getEmployeeID());
        assertEquals(expected.getHoursWorked(), actual.getHoursWorked());

    }

    @Test
    void InvalidBuildTimeCardFromCSV() {
        ITimeCard actual = Builder.buildTimeCardFromCSV(wrongTc);
        assertNull(actual);
    }
}