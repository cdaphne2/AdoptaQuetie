
/**
 * Tests the AdoptionController class.
 *
 * @author Ujay Bhuva
 * @version 11.09.2026
 */

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the AdoptionController class.
 */
public class AdoptionControllerTest
{
    private AdoptionController controller;
    private Animal animal;

    /**
     * Creates test objects before each test.
     */
    @Before
    public void setUp()
    {
        ArrayList<Animal> animals = new ArrayList<Animal>();

        animal =
            new Animal("Buddy", 3, "Male", "Golden Retriever", "Friendly dog");

        animals.add(animal);

        controller = new AdoptionController(animals);
    }


    @Test
    public void testSelectAnimal()
    {
        assertEquals(animal, controller.selectAnimal("Buddy"));
        assertNull(controller.selectAnimal("Unknown"));
    }


    @Test
    public void testSelectAnimalCase()
    {
        assertEquals(animal, controller.selectAnimal("buddy"));
    }


    @Test
    public void testJoinQueue()
    {
        controller.joinQueue("Buddy", "Amy", "Smith");

        assertEquals(1, animal.getQueue().getSize());
        assertEquals(new Adopter("Amy", "Smith"), animal.getQueue().peek());
    }


    @Test
    public void testDuplicateAdopter()
    {
        controller.joinQueue("Buddy", "Amy", "Smith");
        controller.joinQueue("Buddy", "Amy", "Smith");

        assertEquals(1, animal.getQueue().getSize());
    }


    @Test
    public void testInvalidAnimal()
    {
        controller.joinQueue("Unknown", "Amy", "Smith");

        assertEquals(0, animal.getQueue().getSize());
    }


    @Test
    public void testInvalidName()
    {
        controller.joinQueue("Buddy", "", "Smith");

        assertEquals(0, animal.getQueue().getSize());
    }


    @Test
    public void testFinishMeeting()
    {
        controller.joinQueue("Buddy", "Amy", "Smith");
        controller.joinQueue("Buddy", "Ben", "Jones");

        controller.finishMeeting("Buddy");

        assertEquals(1, animal.getQueue().getSize());
        assertEquals(new Adopter("Ben", "Jones"), animal.getQueue().peek());
    }


    @Test
    public void testFinishMeetingEmpty()
    {
        controller.finishMeeting("Buddy");

        assertTrue(animal.getQueue().isEmpty());
    }


    /**
     * Tests that viewing the next adopter does not remove anyone.
     */
    @Test
    public void testShowNextAdopter()
    {
        controller.joinQueue("Buddy", "Amy", "Smith");
        controller.joinQueue("Buddy", "Ben", "Jones");

        controller.showNextAdopter("Buddy");

        assertEquals(2, animal.getQueue().getSize());
        assertEquals(new Adopter("Amy", "Smith"), animal.getQueue().peek());
    }


    /**
     * Tests skipping the first adopter.
     */
    @Test
    public void testSkipAdopter()
    {
        controller.joinQueue("Buddy", "Amy", "Smith");
        controller.joinQueue("Buddy", "Ben", "Jones");

        controller.skipAdopter("Buddy");

        assertEquals(1, animal.getQueue().getSize());
        assertEquals(new Adopter("Ben", "Jones"), animal.getQueue().peek());
    }


    /**
     * Tests skipping when the queue is empty.
     */
    @Test
    public void testSkipEmptyQueue()
    {
        controller.skipAdopter("Buddy");

        assertTrue(animal.getQueue().isEmpty());
    }


    /**
     * Tests that an unknown animal cannot be skipped.
     */
    @Test
    public void testSkipInvalidAnimal()
    {
        controller.skipAdopter("Unknown");

        assertTrue(animal.getQueue().isEmpty());
    }
}
