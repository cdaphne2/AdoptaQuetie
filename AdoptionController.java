
import java.util.ArrayList;

/**
 * Controls the adoption application.
 *
 * @author Ujay Bhuva
 * @version 11.09.2026
 */
public class AdoptionController
{
    private ArrayList<Animal> animals;
    private AdoptionView view;

    public AdoptionController(ArrayList<Animal> animals)
    {
        this.animals = animals;
        view = new AdoptionView();
    }


    public void displayAnimals()
    {
        for (Animal animal : animals)
        {
            view.displayAnimal(animal);
        }
    }


    public Animal selectAnimal(String name)
    {
        for (Animal animal : animals)
        {
            if (animal.getName().equalsIgnoreCase(name))
            {
                return animal;
            }
        }
        return null;
    }


    public void joinQueue(
        String animalName,
        String firstName,
        String lastName)
    {
        Animal animal = selectAnimal(animalName);

        if (animal == null)
        {
            view.displayMessage("Animal not found.");
            return;
        }

        if (firstName == null || lastName == null
            || firstName.trim().isEmpty()
            || lastName.trim().isEmpty())
        {
            view.displayMessage("Invalid name.");
            return;
        }

        Adopter adopter = new Adopter(firstName, lastName);

        AdoptionQueue queue = animal.getQueue();

        // Check for duplicate adopters.
        AdoptionQueue temp = new AdoptionQueue();
        boolean duplicate = false;

        while (!queue.isEmpty())
        {
            Adopter current = queue.dequeue();

            if (current.equals(adopter))
            {
                duplicate = true;
            }

            temp.enqueue(current);
        }

        while (!temp.isEmpty())
        {
            queue.enqueue(temp.dequeue());
        }

        if (duplicate)
        {
            view.displayMessage("Already in queue.");
            return;
        }

        queue.enqueue(adopter);
        view.displayMessage("Successfully joined queue!");
    }


    public void showQueueSize(String animalName)
    {
        Animal animal = selectAnimal(animalName);

        if (animal == null)
        {
            view.displayMessage("Animal not found.");
            return;
        }

        view.displayMessage("People waiting: "
            + animal.getQueue().getSize());
    }


    public void finishMeeting(String animalName)
    {
        Animal animal = selectAnimal(animalName);

        if (animal == null)
        {
            view.displayMessage("Animal not found.");
            return;
        }

        Adopter adopter = animal.getQueue().dequeue();

        if (adopter == null)
        {
            view.displayMessage("Queue is empty.");
        }
        else
        {
            view.displayMessage("Meeting finished.");
        }
    }


    public void start()
    {
        boolean running = true;

        while (running)
        {
            view.displayMenu();
            String choice = view.getInput();

            switch (choice)
            {
                case "1":
                    displayAnimals();
                    break;

                case "2":
                    view.displayMessage("Animal name:");
                    String animal = view.getInput();

                    view.displayMessage("First name:");
                    String first = view.getInput();

                    view.displayMessage("Last name:");
                    String last = view.getInput();

                    joinQueue(animal, first, last);
                    break;

                case "3":
                    view.displayMessage("Animal name:");
                    showQueueSize(view.getInput());
                    break;

                case "4":
                    view.displayMessage("Animal name:");
                    finishMeeting(view.getInput());
                    break;

                case "5":
                    running = false;
                    break;

                default:
                    view.displayMessage("Invalid choice.");
            }
        }
    }
}
