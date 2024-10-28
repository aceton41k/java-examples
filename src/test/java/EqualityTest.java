import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EqualityTest {


    @Test
    public void testEq1() {
        assertTrue(eq1());
    }
    @Test
    public void testEq2() {
        assertFalse(eq2());
    }

    @Test
    public void testEq3() {
        assertTrue(eq3());
    }

    @Test
    public void testStrEq1() {
        assertTrue(strEq1());
    }

    @Test
    public void testStrEq2() {
        assertFalse(strEq2());
    }

    @Test
    public void testStrEq3() {
        assertTrue(strEq3());
    }

    public boolean eq1() {
        Integer a = 127;
        Integer b = 127;

        return a == b;
    }

    public boolean eq2() {
        Integer a = 128;
        Integer b = 128;

        return a == b;
    }

    public boolean eq3() {
        Integer a = 128;
        Integer b = 128;

        return a.equals(b);
    }

    public boolean strEq1() {
        String a = "123";
        String b = "123";

        return a == b;
    }

    public boolean strEq2() {
        String a = new String("123");
        String b = new String("123");

        return a == b;
    }

    public boolean strEq3() {
        String a = new String("123");
        String b = new String("123");

        return a.equals(b);
    }
}
