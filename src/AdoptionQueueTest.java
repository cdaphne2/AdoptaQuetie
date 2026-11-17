
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests AdoptionQueue.
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

    @Before
    public void setUp()
    {
        queue = new AdoptionQueue();

        adopter1 = new Adopter("Amy", "Smith");
        adopter2 = new Adopter("Ben", "Jones");
        adopter3 = new Adopter("Cat", "Brown");
    }


    @Test
    public void testConstructor()
    {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.getSize());
        assertNull(queue.peek());
    }


    @Test
    public void testEnqueue()
    {
        queue.enqueue(adopter1);
        queue.enqueue(adopter2);

        assertEquals(2, queue.getSize());
        assertEquals(adopter1, queue.peek());
    }


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


    @Test
    public void testDequeueEmpty()
    {
        assertNull(queue.dequeue());
        assertEquals(0, queue.getSize());
    }


    @Test
    public void testPeek()
    {
        queue.enqueue(adopter1);
        queue.enqueue(adopter2);

        assertEquals(adopter1, queue.peek());
        assertEquals(2, queue.getSize());
    }


    @Test
    public void testPeekEmpty()
    {
        assertNull(queue.peek());
    }


    @Test
    public void testIsEmpty()
    {
        assertTrue(queue.isEmpty());

        queue.enqueue(adopter1);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }


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


    @Test
    public void testEnqueueAfterEmpty()
    {
        queue.enqueue(adopter1);
        queue.dequeue();

        queue.enqueue(adopter2);

        assertEquals(adopter2, queue.peek());
        assertEquals(1, queue.getSize());
    }


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


    @Test
    public void testEstimatedWaitTime()
    {
        queue.enqueue(adopter1);
        queue.enqueue(adopter2);
        queue.enqueue(adopter3);

        assertEquals(0, queue.getEstimatedWaitTime(adopter1));
        assertEquals(30, queue.getEstimatedWaitTime(adopter2));
        assertEquals(60, queue.getEstimatedWaitTime(adopter3));

        queue.dequeue();

        assertEquals(0, queue.getEstimatedWaitTime(adopter2));
        assertEquals(30, queue.getEstimatedWaitTime(adopter3));
    }


    @Test
    public void testEstimatedWaitTimeNotFound()
    {
        assertEquals(-1, queue.getEstimatedWaitTime(adopter1));
        assertEquals(-1, queue.getEstimatedWaitTime(null));

        queue.enqueue(adopter1);

        assertEquals(-1, queue.getEstimatedWaitTime(adopter2));
    }


    @Test
    public void testInterleavedEnqueueDequeue()
    {
        queue.enqueue(adopter1);
        queue.enqueue(adopter2);

        assertEquals(adopter1, queue.dequeue());

        queue.enqueue(adopter3);

        assertEquals(adopter2, queue.dequeue());
        assertEquals(adopter3, queue.dequeue());

        assertTrue(queue.isEmpty());
    }
}
