import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Animal class.
 */
public class AnimalTest
{
    private Animal animal;

    @Before
    public void setUp()
    {
        animal =
            new Animal("Buddy", 3, "Male", "Golden Retriever", "Friendly dog");
    }


    @Test
    public void testGetName()
    {
        assertEquals("Buddy", animal.getName());
    }


    @Test
    public void testGetAge()
    {
        assertEquals(3, animal.getAge());
    }


    @Test
    public void testGetGender()
    {
        assertEquals("Male", animal.getGender());
    }


    @Test
    public void testGetBreed()
    {
        assertEquals("Golden Retriever", animal.getBreed());
    }


    @Test
    public void testGetDescription()
    {
        assertEquals("Friendly dog", animal.getDescription());
    }


    @Test
    public void testQueueStartsEmpty()
    {
        assertTrue(animal.getQueue().isEmpty());
        assertEquals(0, animal.getQueue().getSize());
    }


    @Test
    public void testAddToQueue()
    {
        Adopter adopter = new Adopter("Amy", "Smith");
        animal.getQueue().enqueue(adopter);

        assertEquals(1, animal.getQueue().getSize());
        assertEquals(adopter, animal.getQueue().peek());
    }


    @Test
    public void testZeroAge()
    {
        Animal puppy = new Animal("Max", 0, "Male", "Mixed", "Puppy");

        assertEquals(0, puppy.getAge());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testNegativeAge()
    {
        new Animal("Max", -1, "Male", "Mixed", "Puppy");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testEmptyName()
    {
        new Animal("", 2, "Female", "Cat", "Friendly");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testNullBreed()
    {
        new Animal("Luna", 2, "Female", null, "Friendly");
    }
}
