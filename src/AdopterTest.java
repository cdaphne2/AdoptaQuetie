import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the Adopter class.
 */
public class AdopterTest
{
    @Test
    public void testGetFirstName()
    {
        Adopter adopter = new Adopter("Amy", "Smith");
        assertEquals("Amy", adopter.getFirstName());
    }


    @Test
    public void testGetLastName()
    {
        Adopter adopter = new Adopter("Amy", "Smith");
        assertEquals("Smith", adopter.getLastName());
    }


    @Test
    public void testEquals()
    {
        Adopter first = new Adopter("Amy", "Smith");
        Adopter second = new Adopter("Amy", "Smith");

        assertEquals(first, second);
    }


    @Test
    public void testNotEquals()
    {
        Adopter first = new Adopter("Amy", "Smith");
        Adopter second = new Adopter("Ben", "Jones");

        assertFalse(first.equals(second));
    }


    @Test
    public void testEqualsNull()
    {
        Adopter adopter = new Adopter("Amy", "Smith");
        assertFalse(adopter.equals(null));
    }


    @Test
    public void testEqualsOtherType()
    {
        Adopter adopter = new Adopter("Amy", "Smith");
        assertFalse(adopter.equals("Amy Smith"));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testEmptyFirstName()
    {
        new Adopter("", "Smith");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testEmptyLastName()
    {
        new Adopter("Amy", "");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testNullName()
    {
        new Adopter(null, "Smith");
    }
}
