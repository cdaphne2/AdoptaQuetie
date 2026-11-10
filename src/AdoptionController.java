import java.util.ArrayList;

/**
 * Controls the adoption application.
 *
 * @author Ujay Bhuva
 * @version 11.10.2026
 */
public class AdoptionController
{
    private ArrayList<Animal> animals;
    private AdoptionView view;

    /**
     * Creates a controller with a list of animals.
     *
     * @param animals
     *            the available animals
     */
    public AdoptionController(ArrayList<Animal> animals)
    {
        this.animals = animals;
        view = new AdoptionView();
    }


    /**
     * Displays all available animals.
     */
    public void displayAnimals()
    {
        if (animals.isEmpty())
        {
            view.displayMessage("No animals available.");
            return;
        }

        for (Animal animal : animals)
        {
            view.displayAnimal(animal);
        }
    }


    /**
     * Finds an animal by its name.
     *
     * @param name
     *            the animal's name
     * @return the animal, or null if not found
     */
    public Animal selectAnimal(String name)
    {
        if (name == null)
        {
            return null;
        }

        for (Animal animal : animals)
        {
            if (animal.getName().equalsIgnoreCase(name.trim()))
            {
                return animal;
            }
        }

        return null;
    }


    /**
     * Adds an adopter to an animal's waiting queue.
     *
     * @param animalName
     *            the animal's name
     * @param firstName
     *            the adopter's first name
     * @param lastName
     *            the adopter's last name
     */
    public void joinQueue(String animalName, String firstName, String lastName)
    {
        Animal animal = selectAnimal(animalName);

        if (animal == null)
        {
            view.displayMessage("Animal not found.");
            return;
        }

        if (firstName == null || lastName == null || firstName.trim().isEmpty()
            || lastName.trim().isEmpty())
        {
            view.displayMessage("Invalid name.");
            return;
        }

        Adopter adopter = new Adopter(firstName.trim(), lastName.trim());

        AdoptionQueue queue = animal.getQueue();

        // Check whether this adopter is already waiting.
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

        // Put everyone back in their original order.
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


    /**
     * Displays how many people are waiting.
     *
     * @param animalName
     *            the animal's name
     */
    public void showQueueSize(String animalName)
    {
        Animal animal = selectAnimal(animalName);

        if (animal == null)
        {
            view.displayMessage("Animal not found.");
            return;
        }

        view.displayMessage("People waiting: " + animal.getQueue().getSize());
    }


    /**
     * Shows the first adopter in the queue without removing them.
     *
     * @param animalName
     *            the animal's name
     */
    public void showNextAdopter(String animalName)
    {
        Animal animal = selectAnimal(animalName);

        if (animal == null)
        {
            view.displayMessage("Animal not found.");
            return;
        }

        Adopter next = animal.getQueue().peek();

        if (next == null)
        {
            view.displayMessage("Nobody is waiting.");
        }
        else
        {
            view.displayMessage(
                "Next up: " + next.getFirstName() + " " + next.getLastName());
        }
    }


    /**
     * Finishes a meeting and removes the first adopter from the queue.
     *
     * @param animalName
     *            the animal's name
     */
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
            view.displayMessage(
                "Meeting finished for " + adopter.getFirstName() + " "
                    + adopter.getLastName() + ".");
        }
    }


    /**
     * Skips the first adopter if they do not arrive.
     *
     * @param animalName
     *            the animal's name
     */
    public void skipAdopter(String animalName)
    {
        Animal animal = selectAnimal(animalName);

        if (animal == null)
        {
            view.displayMessage("Animal not found.");
            return;
        }

        Adopter skipped = animal.getQueue().dequeue();

        if (skipped == null)
        {
            view.displayMessage("Queue is empty.");
        }
        else
        {
            view.displayMessage(
                "Skipped: " + skipped.getFirstName() + " "
                    + skipped.getLastName());
        }
    }


    /**
     * Runs the main application menu.
     */
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
                    showNextAdopter(view.getInput());
                    break;

                case "5":
                    view.displayMessage("Animal name:");
                    finishMeeting(view.getInput());
                    break;

                case "6":
                    view.displayMessage("Animal name:");
                    skipAdopter(view.getInput());
                    break;

                case "7":
                    running = false;
                    view.displayMessage("Goodbye!");
                    break;

                default:
                    view.displayMessage("Invalid choice.");
                    break;
            }
        }
    }
}
