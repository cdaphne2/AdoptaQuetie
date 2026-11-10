
/**
 * A queue of adopters waiting to meet an animal. Uses first-in, first-out
 * (FIFO) order.
 *
 * @author Daphne
 * @version 11.07.2026
 */
public class AdoptionQueue
{

    private Node firstNode;
    private Node lastNode;
    private int size;

    /**
     * Represents one adopter in the queue.
     */
    private class Node
    {
        private Adopter data;
        private Node next;

        /**
         * Creates a node.
         *
         * @param adopter
         *            the adopter to store
         */
        public Node(Adopter adopter)
        {
            data = adopter;
            next = null;
        }
    }

    /**
     * Creates an empty queue.
     */
    public AdoptionQueue()
    {
        firstNode = null;
        lastNode = null;
        size = 0;
    }


    /**
     * Adds an adopter to the back of the queue.
     *
     * @param adopter
     *            the adopter to add
     */
    public void enqueue(Adopter adopter)
    {
        if (adopter == null)
        {
            throw new IllegalArgumentException("Adopter cannot be null");
        }

        Node newNode = new Node(adopter);

        if (isEmpty())
        {
            firstNode = newNode;
        }
        else
        {
            lastNode.next = newNode;
        }

        lastNode = newNode;
        size++;
    }


    /**
     * Removes the first adopter.
     *
     * @return removed adopter, or null if empty
     */
    public Adopter dequeue()
    {
        if (isEmpty())
        {
            return null;
        }

        Adopter removed = firstNode.data;
        firstNode = firstNode.next;
        size--;

        if (isEmpty())
        {
            lastNode = null;
        }

        return removed;
    }


    /**
     * Looks at the first adopter without removing them.
     *
     * @return first adopter, or null if empty
     */
    public Adopter peek()
    {
        if (isEmpty())
        {
            return null;
        }

        return firstNode.data;
    }


    /**
     * Checks if the queue is empty.
     *
     * @return true if empty
     */
    public boolean isEmpty()
    {
        return size == 0;
    }


    /**
     * Returns how many adopters are waiting.
     *
     * @return queue size
     */
    public int getSize()
    {
        return size;
    }
}
