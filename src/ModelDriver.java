
/**
 * Tests the adoption model independently.
 *
 * @author Ujay Bhuva
 * @version 11.10.2026
 */
public class ModelDriver
{
    public static void main(String[] args)
    {
        AdoptionQueue queue = new AdoptionQueue();

        Adopter adopter1 = new Adopter("Amy", "Smith");
        Adopter adopter2 = new Adopter("Ben", "Jones");

        queue.enqueue(adopter1);
        queue.enqueue(adopter2);

        System.out.println("Queue size: " + queue.getSize());
        System.out.println("Next adopter: "
            + queue.peek().getFirstName());

        queue.dequeue();

        System.out.println("After meeting: "
            + queue.getSize());
    }
}
