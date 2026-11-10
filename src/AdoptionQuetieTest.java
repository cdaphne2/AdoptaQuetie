import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the AdoptionQuetie class.
 */
public class AdoptionQuetieTest
{
    private AdoptionQuetie system;
    private Animal animal;

    @Before
    public void setUp()
    {
        system = new AdoptionQuetie();

        animal =
            new Animal("Buddy", 3, "Male", "Golden Retriever", "Friendly dog");

        system.addAnimal(animal);
    }


    @Test
    public void testAddAnimal()
    {
        assertEquals(1, system.getAnimals().size());
    }


    @Test
    public void testFindAnimal()
    {
        assertEquals(animal, system.findAnimal("Buddy"));
    }


    @Test
    public void testFindAnimalIgnoreCase()
    {
        assertEquals(animal, system.findAnimal("buddy"));
    }


    @Test
    public void testAnimalNotFound()
    {
        assertNull(system.findAnimal("Unknown"));
    }


    @Test
    public void testJoinQueue()
    {
        Adopter adopter = new Adopter("Amy", "Smith");

        assertTrue(system.joinQueue("Buddy", adopter));
        assertEquals(1, animal.getQueue().getSize());
        assertEquals(adopter, animal.getQueue().peek());
    }


    @Test
    public void testJoinInvalidAnimal()
    {
        Adopter adopter = new Adopter("Amy", "Smith");

        assertFalse(system.joinQueue("Unknown", adopter));
        assertEquals(0, animal.getQueue().getSize());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddNullAnimal()
    {
        system.addAnimal(null);
    }
}
