
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

    private class Node
    {
        private Adopter data;
        private Node next;

        public Node(Adopter adopter)
        {
            data = adopter;
            next = null;
        }
    }

    public AdoptionQueue()
    {
        firstNode = null;
        lastNode = null;
        size = 0;
    }


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


    public Adopter peek()
    {
        if (isEmpty())
        {
            return null;
        }

        return firstNode.data;
    }


    public boolean isEmpty()
    {
        return size == 0;
    }


    public int getSize()
    {
        return size;
    }


    /**
     * Calculates estimated waiting time. Each person ahead adds 30 minutes.
     *
     * @param adopter
     *            the adopter to find
     * @return minutes or -1 if not found
     */
    public int getEstimatedWaitTime(Adopter adopter)
    {
        if (adopter == null)
        {
            return -1;
        }

        Node current = firstNode;
        int peopleAhead = 0;

        while (current != null)
        {
            if (current.data.equals(adopter))
            {
                return peopleAhead * 30;
            }

            peopleAhead++;
            current = current.next;
        }

        return -1;
    }
}
