
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the AdoptionController class.
 *
 * @author Ujay Bhuva
 * @version 11.09.2026
 */
public class AdoptionControllerTest
{
    private AdoptionController controller;
    private Animal animal;

    /**
     * Sets up the test objects.
     */
    @Before
    public void setUp()
    {
        ArrayList<Animal> animals = new ArrayList<Animal>();

        animal = new Animal(
            "Buddy", 3, "Male", "Golden Retriever",
            "Friendly dog");

        animals.add(animal);

        controller = new AdoptionController(animals);
    }


    /**
     * Tests selecting an animal.
     */
    @Test
    public void testSelectAnimal()
    {
        assertEquals(animal, controller.selectAnimal("Buddy"));
        assertNull(controller.selectAnimal("Unknown"));
    }


    /**
     * Tests selecting an animal ignoring case.
     */
    @Test
    public void testSelectAnimalCase()
    {
        assertEquals(animal, controller.selectAnimal("buddy"));
    }


    /**
     * Tests joining an animal's queue.
     */
    @Test
    public void testJoinQueue()
    {
        controller.joinQueue("Buddy", "Amy", "Smith");

        assertEquals(1, animal.getQueue().getSize());
        assertEquals(
            new Adopter("Amy", "Smith"),
            animal.getQueue().peek());
    }


    /**
     * Tests rejecting a duplicate adopter.
     */
    @Test
    public void testDuplicateAdopter()
    {
        controller.joinQueue("Buddy", "Amy", "Smith");
        controller.joinQueue("Buddy", "Amy", "Smith");

        assertEquals(1, animal.getQueue().getSize());
    }


    /**
     * Tests joining a nonexistent animal's queue.
     */
    @Test
    public void testInvalidAnimal()
    {
        controller.joinQueue("Unknown", "Amy", "Smith");

        assertEquals(0, animal.getQueue().getSize());
    }


    /**
     * Tests rejecting an empty first name.
     */
    @Test
    public void testInvalidName()
    {
        controller.joinQueue("Buddy", "", "Smith");

        assertEquals(0, animal.getQueue().getSize());
    }


    /**
     * Tests finishing a meeting.
     */
    @Test
    public void testFinishMeeting()
    {
        controller.joinQueue("Buddy", "Amy", "Smith");
        controller.joinQueue("Buddy", "Ben", "Jones");

        controller.finishMeeting("Buddy");

        assertEquals(1, animal.getQueue().getSize());
        assertEquals(
            new Adopter("Ben", "Jones"),
            animal.getQueue().peek());
    }


    /**
     * Tests finishing a meeting with an empty queue.
     */
    @Test
    public void testFinishMeetingEmpty()
    {
        controller.finishMeeting("Buddy");

        assertTrue(animal.getQueue().isEmpty());
    }
}
