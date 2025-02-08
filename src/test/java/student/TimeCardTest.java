package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeCardTest {
    private TimeCard t;

    @BeforeEach
    void setUp() {
        t = new TimeCard("s192", 45.0);

    }

    @Test
    void testGetEmployeeID() {
        assertEquals("s192", t.getEmployeeID());
    }

    @Test
    void testGetHoursWorked() {
        assertEquals(45.0, t.getHoursWorked());
    }
}