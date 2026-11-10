
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the AdoptionQueue class.
 *
 * @author Daphne
 * @version 11.07.2026
 */
public class AdoptionQueueTest
{

    private AdoptionQueue queue;
    private Adopter adopter1;
    private Adopter adopter2;
    private Adopter adopter3;

    /**
     * Sets up the test objects.
     */
    @Before
    public void setUp()
    {
        queue = new AdoptionQueue();

        adopter1 = new Adopter("Amy", "Smith");
        adopter2 = new Adopter("Ben", "Jones");
        adopter3 = new Adopter("Cat", "Brown");
    }


    /**
     * Tests creating an empty queue.
     */
    @Test
    public void testConstructor()
    {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.getSize());
        assertNull(queue.peek());
    }


    /**
     * Tests adding adopters.
     */
    @Test
    public void testEnqueue()
    {
        queue.enqueue(adopter1);
        queue.enqueue(adopter2);

        assertEquals(2, queue.getSize());
        assertEquals(adopter1, queue.peek());
    }


    /**
     * Tests FIFO removal order.
     */
    @Test
    public void testDequeue()
    {
        queue.enqueue(adopter1);
        queue.enqueue(adopter2);
        queue.enqueue(adopter3);

        assertEquals(adopter1, queue.dequeue());
        assertEquals(adopter2, queue.dequeue());
        assertEquals(adopter3, queue.dequeue());

        assertTrue(queue.isEmpty());
    }


    /**
     * Tests removing from an empty queue.
     */
    @Test
    public void testDequeueEmpty()
    {
        assertNull(queue.dequeue());
        assertEquals(0, queue.getSize());
    }


    /**
     * Tests viewing the first adopter.
     */
    @Test
    public void testPeek()
    {
        queue.enqueue(adopter1);
        queue.enqueue(adopter2);

        assertEquals(adopter1, queue.peek());
        assertEquals(2, queue.getSize());
    }


    /**
     * Tests peeking at an empty queue.
     */
    @Test
    public void testPeekEmpty()
    {
        assertNull(queue.peek());
    }


    /**
     * Tests whether the queue is empty.
     */
    @Test
    public void testIsEmpty()
    {
        assertTrue(queue.isEmpty());

        queue.enqueue(adopter1);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }


    /**
     * Tests the queue size.
     */
    @Test
    public void testGetSize()
    {
        assertEquals(0, queue.getSize());

        queue.enqueue(adopter1);
        assertEquals(1, queue.getSize());

        queue.enqueue(adopter2);
        assertEquals(2, queue.getSize());

        queue.dequeue();
        assertEquals(1, queue.getSize());
    }


    /**
     * Tests adding after emptying the queue.
     */
    @Test
    public void testEnqueueAfterEmpty()
    {
        queue.enqueue(adopter1);
        queue.dequeue();

        queue.enqueue(adopter2);

        assertEquals(adopter2, queue.peek());
        assertEquals(1, queue.getSize());
    }


    /**
     * Tests rejecting a null adopter.
     */
    @Test
    public void testEnqueueNull()
    {
        try
        {
            queue.enqueue(null);
            fail("Expected IllegalArgumentException");
        }
        catch (IllegalArgumentException e)
        {
            assertTrue(queue.isEmpty());
        }
    }
}
