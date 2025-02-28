package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayStubTest {
    PayStub p;

    @BeforeEach
    void setUp() {
        p = new PayStub("Luffy", 1102.24, 322.76, 21102.24, 4852.76);
    }

    @Test
    void getPay() {
        assertEquals(1102.24, p.getPay());
    }

    @Test
    void testConstructor() {
        assertEquals(1102.24, p.getPay(), 0.01);
        assertEquals(322.76, p.getTaxesPaid(), 0.01);
        assertEquals(21102.24, p.getYtdEarnings(), 0.01);
        assertEquals(4852.76, p.getYtdTaxesPaid(), 0.01);
    }

    @Test
    void getTaxesPaid() {
        assertEquals(322.76, p.getTaxesPaid());
    }

    @Test
    void toCSV() {
        assertEquals("Luffy,1102.24,322.76,21102.24,4852.76", p.toCSV());
    }
}